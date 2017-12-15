package lvzhn.component.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lvzhn.component.dao.OrderDao;
import lvzhn.component.dao.OrderDetailDao;
import lvzhn.component.service.IOrderService;
import lvzhn.core.utils.ConverterUtils;
import lvzhn.entity.Order;
import lvzhn.entity.OrderDetail;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderDetailDao orderDetailDao;

	@Transactional
	public void SaveOrder(int userid, Map order, List<Map<String, Object>> odList) {
		// TODO Auto-generated method stub
		Order record = new Order();
		record.setAddress(ConverterUtils.toString(order.get("address")));
		record.setUserid(userid);
		record.setAmount(new BigDecimal(ConverterUtils.toString(order.get("amount"))));
		record.setPayway(ConverterUtils.toString(order.get("payWay")));
		int orderid = orderDao.selectid();
		record.setId(orderid);
		orderDao.insertSelective(record);
		for (Map od : odList) {
			OrderDetail record2 = new OrderDetail();
			record2.setOrderid(orderid);
			record2.setGoodsid(ConverterUtils.toInt(od.get("goodsid")));
			record2.setGoodsname(ConverterUtils.toString(od.get("goodsname")));
			record2.setNums(new BigDecimal(ConverterUtils.toString(od.get("nums"))));
			record2.setPrice(new BigDecimal(ConverterUtils.toString(od.get("price"))));
			record2.setAmount(new BigDecimal(ConverterUtils.toString(od.get("amount"))));
			record2.setId(orderDetailDao.selectid());
			orderDetailDao.insertSelective(record2);
		}
	}

}
