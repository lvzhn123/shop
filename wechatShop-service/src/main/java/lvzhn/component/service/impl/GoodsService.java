package lvzhn.component.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lvzhn.component.dao.GoodsClassDao;
import lvzhn.component.dao.GoodsDao;
import lvzhn.component.service.IGoodsService;
import lvzhn.entity.Goods;
import lvzhn.entity.GoodsClass;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	GoodsDao goodsDao;

	@Autowired
	GoodsClassDao goodsClassDao;

	public List<Goods> getHotSellGoods() {
		return goodsDao.getHotSellGoods();
	}

	public List<GoodsClass> getAllGoodsClass() {
		return goodsClassDao.selectAll();
	}
	
	public List<Goods> getGoodsByClassId(Integer classId){
		return goodsDao.getGoodsByClassId(classId);
	}

	public List<Goods> getGoodsByName(String name) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByName(name);
	}

	public Goods selectByPrimaryKey(Integer goodsid) {
		// TODO Auto-generated method stub
		return goodsDao.selectByPrimaryKey(goodsid);
	}
}
