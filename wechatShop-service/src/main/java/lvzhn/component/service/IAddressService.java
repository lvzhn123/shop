package lvzhn.component.service;

import java.util.List;

import lvzhn.entity.Address;

public interface IAddressService {
	List<Address> selectByUserId(Integer userid);

	void updateDefaultAddress(Integer userid, Integer addressId);

	int deleteByPrimaryKey(Integer id);

	Address selectByPrimaryKey(Integer id);
	
	void updateOrInsert(Address address);

}
