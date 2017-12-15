package lvzhn.component.dao;

import java.util.List;

import lvzhn.entity.Goods;

public interface GoodsDao {
	int deleteByPrimaryKey(Integer goodsid);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer goodsid);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);

	List<Goods> getHotSellGoods();
	
	List<Goods> getGoodsByClassId(Integer classId);
	
	List<Goods> getGoodsByName(String name);
}