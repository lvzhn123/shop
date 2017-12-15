package lvzhn.component.service;

import java.util.List;

import lvzhn.entity.Goods;
import lvzhn.entity.GoodsClass;

public interface IGoodsService {

	List<Goods> getHotSellGoods();
	
	List<GoodsClass> getAllGoodsClass();
	
	List<Goods> getGoodsByClassId(Integer classId);
	
	List<Goods> getGoodsByName(String name);
	
	Goods selectByPrimaryKey(Integer goodsid);
}
