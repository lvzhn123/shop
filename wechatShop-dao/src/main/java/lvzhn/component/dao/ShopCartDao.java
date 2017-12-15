package lvzhn.component.dao;

import lvzhn.entity.ShopCart;

public interface ShopCartDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
    
    ShopCart queryCartsByUserId(Integer userId);
    
    int selectid();
}