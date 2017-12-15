package lvzhn.component.dao;

import java.util.List;

import lvzhn.entity.Address;

public interface AddressDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    List<Address> selectByUserId(Integer userid);
    
    int updateDefaultByUserId(Integer userid);
    
    int selectid();
}