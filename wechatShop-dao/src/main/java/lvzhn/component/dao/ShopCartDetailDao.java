package lvzhn.component.dao;

import lvzhn.entity.ShopCartDetail;

public interface ShopCartDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCartDetail record);

    int insertSelective(ShopCartDetail record);

    ShopCartDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCartDetail record);

    int updateByPrimaryKey(ShopCartDetail record);
    
    int selectid();
}