package lvzhn.component.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lvzhn.component.dao.AddressDao;
import lvzhn.component.service.IAddressService;
import lvzhn.entity.Address;

@Service
public class AddressService implements IAddressService {

	@Autowired
	AddressDao addressDao;

	public List<Address> selectByUserId(Integer userid) {
		return addressDao.selectByUserId(userid);
	}

	@Transactional
	public void updateDefaultAddress(Integer userid, Integer addressId) {
		addressDao.updateDefaultByUserId(userid);
		Address address = new Address();
		address.setIsdefault("1");
		address.setId(addressId);
		addressDao.updateByPrimaryKeySelective(address);

	}

	public int deleteByPrimaryKey(Integer id) {
		return addressDao.deleteByPrimaryKey(id);
	}

	public Address selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return addressDao.selectByPrimaryKey(id);
	}

	@Transactional
	public void updateOrInsert(Address address) {
		// TODO Auto-generated method stub
		if(address.getId() == 0){
			int addressid = addressDao.selectid();
			address.setId(addressid);
			addressDao.insert(address);
		}else{
			addressDao.updateByPrimaryKeySelective(address);
		}
		
	}

}
