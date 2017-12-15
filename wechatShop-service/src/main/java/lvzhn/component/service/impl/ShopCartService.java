package lvzhn.component.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lvzhn.component.dao.ShopCartDao;
import lvzhn.component.dao.ShopCartDetailDao;
import lvzhn.component.service.IShopCartService;
import lvzhn.entity.ShopCart;
import lvzhn.entity.ShopCartDetail;

@Service
public class ShopCartService implements IShopCartService {

	@Autowired
	ShopCartDao shopCartDao;

	@Autowired
	ShopCartDetailDao shopCartDetailDao;

	public ShopCart queryCartsByUserId(Integer userId) {
		return shopCartDao.queryCartsByUserId(userId);

	}

	@Transactional
	public void addShopCart(int userId, int goodsId, BigDecimal price, BigDecimal num) {
		// TODO Auto-generated method stub
		ShopCart cart = shopCartDao.queryCartsByUserId(userId);
		if (cart == null) {
			int maxid = shopCartDao.selectid();
			BigDecimal dnum = new BigDecimal(1);
			BigDecimal amount = price.multiply(num);
			ShopCart sc = new ShopCart();
			sc.setId(maxid);
			sc.setNums(dnum);
			sc.setUserid(userId);
			sc.setAmount(amount);
			shopCartDao.insert(sc);
			ShopCartDetail scd = new ShopCartDetail();
			scd.setGoodsid(goodsId);
			scd.setAmount(amount);
			scd.setNums(num);
			scd.setSid(maxid);
			scd.setPrice(price);
			int maxdid = shopCartDetailDao.selectid();
			scd.setId(maxdid);
			shopCartDetailDao.insert(scd);
		} else {
			cart.setNums(cart.getNums().add(new BigDecimal(1)));
			BigDecimal amount = cart.getAmount().add(price.multiply(num));
			cart.setAmount(amount);
			shopCartDao.updateByPrimaryKeySelective(cart);
			ShopCartDetail scd = new ShopCartDetail();
			scd.setGoodsid(goodsId);
			scd.setAmount(price.multiply(num));
			scd.setNums(num);
			scd.setSid(cart.getId());
			scd.setPrice(price);
			int maxdid = shopCartDetailDao.selectid();
			scd.setId(maxdid);
			shopCartDetailDao.insert(scd);
		}
	}
	
	public void delShopCart(int userId, int id){
		shopCartDetailDao.deleteByPrimaryKey(id);
		ShopCart cart = shopCartDao.queryCartsByUserId(userId);
		cart.setNums(cart.getNums().subtract(new BigDecimal(1)));
		shopCartDao.updateByPrimaryKeySelective(cart);
	}
}