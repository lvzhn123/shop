package lvzhn.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lvzhn.component.controller.BaseController;
import lvzhn.component.service.IAddressService;
import lvzhn.core.WebResponse;
import lvzhn.core.enums.Success;
import lvzhn.entity.Address;

@RestController
public class AddressAction extends BaseController {

	@Autowired
	IAddressService addressService;

	// 更改默认地址
	@RequestMapping("/updateDefault")
	WebResponse updateDefault(@RequestParam("addressId") int addressId) {

		WebResponse wr = new WebResponse();
		int userid = getUserId();
		addressService.updateDefaultAddress(userid, addressId);
		wr.setSuccess(Success.success);
		return wr;
	}

	// 更改默认地址
	@RequestMapping("/deleteAddr")
	WebResponse deleteAddr(@RequestParam("addressId") int addressId) {
		WebResponse wr = new WebResponse();
		addressService.deleteByPrimaryKey(addressId);
		wr.setSuccess(Success.success);

		return wr;
	}

	// 保存收货地址
	@RequestMapping("/saveAddress")
	WebResponse saveAddress(@RequestParam("receiver") String receiver, @RequestParam("phone") String phone,
			@RequestParam("address") String address, @RequestParam("addressId") int addressId) {
		WebResponse wr = new WebResponse();
		Address record = new Address();
		record.setId(addressId);
		if(addressId == 0){
			record.setUserid(getUserId());
			record.setIsdefault("0");
		}
		record.setReceiver(receiver);
		record.setAddress(address);
		record.setPhone(phone);
		addressService.updateOrInsert(record);
		wr.setSuccess(Success.success);
		return wr;
	}
}
