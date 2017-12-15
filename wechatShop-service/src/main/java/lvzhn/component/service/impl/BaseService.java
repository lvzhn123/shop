package lvzhn.component.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lvzhn.component.dao.RollAdDao;
import lvzhn.entity.RollAd;

@Service
public class BaseService {

	@Autowired
	RollAdDao rollAdDao;

	public List<RollAd> getAllRollAD() {
		return rollAdDao.selectAll();
	}
}
