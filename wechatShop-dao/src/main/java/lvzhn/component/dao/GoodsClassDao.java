package lvzhn.component.dao;

import java.util.List;

import lvzhn.entity.GoodsClass;

public interface GoodsClassDao {
	int deleteByPrimaryKey(Integer classid);

	int insert(GoodsClass record);

	int insertSelective(GoodsClass record);

	GoodsClass selectByPrimaryKey(Integer classid);

	int updateByPrimaryKeySelective(GoodsClass record);

	int updateByPrimaryKey(GoodsClass record);

	List<GoodsClass> selectAll();
}