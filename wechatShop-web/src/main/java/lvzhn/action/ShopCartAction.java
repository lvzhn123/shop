package lvzhn.action;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lvzhn.component.controller.BaseController;
import lvzhn.component.service.IShopCartService;
import lvzhn.core.WebResponse;
import lvzhn.core.enums.Success;
import lvzhn.core.utils.ConverterUtils;
import lvzhn.entity.ShopCart;

@RestController
public class ShopCartAction extends BaseController {

	@Autowired
	IShopCartService shopCartService;

	// 加入购物车
	@RequestMapping("/addToShopCart")
	WebResponse addToShopCart(@RequestParam("goodsId") int goodsId, @RequestParam("price") BigDecimal price,
			@RequestParam("num") BigDecimal num) {
		int userId = ConverterUtils.toInt(this.context.getRequest().getSession().getAttribute("userId"));
		shopCartService.addShopCart(userId, goodsId, price, num);
		WebResponse wr = new WebResponse();
		wr.setSuccess(Success.success);
		return wr;
	}

	//刪除购物车
	@RequestMapping("/delShopCart")
	WebResponse delShopCarts(@RequestParam("id") int id) {
		int userId = ConverterUtils.toInt(this.context.getRequest().getSession().getAttribute("userId"));
		shopCartService.delShopCart(userId, id);
		WebResponse wr = new WebResponse();
		wr.setSuccess(Success.success);
		return wr;
	}
}
