package lvzhn.component.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

import lvzhn.component.service.IAddressService;
import lvzhn.component.service.IGoodsService;
import lvzhn.component.service.IShopCartService;
import lvzhn.component.service.impl.BaseService;
import lvzhn.core.utils.ConverterUtils;
import lvzhn.entity.Address;
import lvzhn.entity.Goods;
import lvzhn.entity.GoodsClass;
import lvzhn.entity.RollAd;
import lvzhn.entity.ShopCart;
import lvzhn.entity.ShopCartDetail;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = { "lvzhn.component.service", "lvzhn.action", "lvzhn.configure" })
@MapperScan("lvzhn.component.dao")
@EnableTransactionManagement
public class PageController extends BaseController {

	@Autowired
	BaseService baseService;

	@Autowired
	IGoodsService goodsService;

	@Autowired
	IShopCartService shopCartService;

	@Autowired
	IAddressService addressService;

	@RequestMapping("/index")
	String index(Map data) {
		List<RollAd> rollads = baseService.getAllRollAD();
		data.put("rollads", rollads);
		List<Goods> hotsellGoods = goodsService.getHotSellGoods();
		data.put("hotsellGoods", hotsellGoods);
		return "index";
	}

	@RequestMapping("/category")
	String category(Map data) {
		List<GoodsClass> goodsClass = goodsService.getAllGoodsClass();
		data.put("goodsClass", goodsClass);
		return "category";
	}

	@RequestMapping("/goodsDetail")
	String goodsDetail(Map data) {
		Integer goodsId = ConverterUtils.toInt(this.context.getRequest().getParameter("goodsId"));
		Goods goods = goodsService.selectByPrimaryKey(goodsId);
		data.put("goods", goods);
		return "goodsDetail";
	}

	@RequestMapping("/login")
	String login(Map data) {
		return "login";
	}

	@RequestMapping("/shopCart")
	String shopCart(Map data) {
		int userId = ConverterUtils.toInt(this.context.getRequest().getSession().getAttribute("userId"));
		ShopCart shopCart = shopCartService.queryCartsByUserId(userId);
		if (shopCart != null) {
			List<ShopCartDetail> scs = shopCart.getShopCartDetails();
			if (scs != null) {
				BigDecimal amount = new BigDecimal(0);
				for (ShopCartDetail sc : scs) {
					if (sc != null) {
						amount = amount.add(sc.getAmount());
					}
				}
				shopCart.setAmount(amount);
			}
		}
		data.put("shopCart", shopCart);
		return "shopCart";
	}

	@RequestMapping("/order")
	String order(Map data) {
		if (null == this.context.getRequest().getParameter("fromCart")) {
			String goodsName = ConverterUtils.toString(this.context.getRequest().getParameter("goodsName"));
			String pictureUrl = ConverterUtils.toString(this.context.getRequest().getParameter("pictureUrl"));
			BigDecimal price = new BigDecimal(ConverterUtils.toString(this.context.getRequest().getParameter("price")));
			BigDecimal num = new BigDecimal(ConverterUtils.toString(this.context.getRequest().getParameter("num")));
			BigDecimal amount = price.multiply(num);
			Map goods = new HashMap();
			goods.put("amount", amount);
			goods.put("pictureUrl", pictureUrl);
			goods.put("goodsName", goodsName);
			goods.put("price", price);
			goods.put("num", num);
			List goodsList = new ArrayList();
			goodsList.add(goods);
			data.put("goodsList", goodsList);
			data.put("amount", amount);
		} else {
			int userId = ConverterUtils.toInt(this.context.getRequest().getSession().getAttribute("userId"));
			String expids = ConverterUtils.toString(this.context.getRequest().getParameter("expids"));
			String[] ids = expids.split(",");
			ShopCart shopCart = shopCartService.queryCartsByUserId(userId);
			List goodsList = new ArrayList();
			if (shopCart != null) {
				List<ShopCartDetail> scs = shopCart.getShopCartDetails();
				if (scs != null) {
					BigDecimal amount = new BigDecimal(0);
					for (ShopCartDetail sc : scs) {
						if (sc != null) {
							Integer scid = sc.getId();
							boolean flag = false;
							for (String id : ids) {
								if (id.equals(ConverterUtils.toString(scid))) {
									flag = true;
									break;
								}
							}
							if (flag) {
								continue;
							}
							Map goods = new HashMap();
							int goodsId = sc.getGoods().getGoodsid();
							Goods g = goodsService.selectByPrimaryKey(goodsId);
							amount = amount.add(sc.getAmount());
							goods.put("amount", sc.getAmount());
							goods.put("pictureUrl", g.getPictureurl());
							goods.put("goodsName", g.getGoodsname());
							goods.put("price", sc.getPrice());
							goods.put("num", sc.getNums());
							goodsList.add(goods);
						}
					}
					data.put("amount", amount);
					data.put("goodsList", goodsList);
				}
			}
		}
		
		int userId = getUserId();
		List<Address> addresses = addressService.selectByUserId(userId);
		Address  address = null;
		if(addresses!=null&& addresses.size()>0){
			address = addresses.get(0);
			for(Address x : addresses){
				if(x.getIsdefault().equals("1")){
					address = x;
				}
			}
		}
		data.put("address",address);
		return "order";
	}

	@RequestMapping("/gladdress")
	String gladdress(Map data) {
		int userId = getUserId();
		String backUrl = ConverterUtils.toString(this.context.getRequest().getParameter("backUrl"));
		List<Address> addresses = addressService.selectByUserId(userId);
		data.put("addresses", addresses);
		data.put("backUrl", backUrl);
		return "gladdress";
	}

	@RequestMapping("/address")
	String address(Map data) {
		String backUrl = ConverterUtils.toString(this.context.getRequest().getParameter("backUrl"));
		data.put("backUrl", backUrl);
		if (null != this.context.getRequest().getParameter("addressId")){
			int addressId = ConverterUtils.toInt(this.context.getRequest().getParameter("addressId"));
			Address address = addressService.selectByPrimaryKey(addressId);
			data.put("address", address);
		}
		return "address";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PageController.class, args);
	}
}
