package lvzhn.component.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import lvzhn.entity.RollAd;

public interface RollAdDao {
	int deleteByPrimaryKey(Integer id);

	int insert(RollAd record);

	int insertSelective(RollAd record);

	RollAd selectByPrimaryKey(Integer id);

	List<RollAd> selectAll();

	int updateByPrimaryKeySelective(RollAd record);

	int updateByPrimaryKey(RollAd record);
}