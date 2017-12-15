package lvzhn.component.service;

import java.math.BigDecimal;

import lvzhn.entity.ShopCart;

public interface IShopCartService {
	ShopCart queryCartsByUserId(Integer userId);

	void addShopCart(int userId, int goodsId, BigDecimal price, BigDecimal num);
	
	void delShopCart(int userId, int id);

}
