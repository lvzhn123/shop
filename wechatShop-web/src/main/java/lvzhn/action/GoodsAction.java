package lvzhn.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lvzhn.component.controller.BaseController;
import lvzhn.component.service.IGoodsService;
import lvzhn.core.utils.ConverterUtils;
import lvzhn.entity.Goods;

@RestController
public class GoodsAction extends BaseController {

	@Autowired
	IGoodsService goodsService;
	
	// ��ȡ������Ʒ
	@RequestMapping("/getActivity")
	List<Goods> getActivity() {

		
		return goodsService.getHotSellGoods();

	}

	// ��ȡ������Ʒ
	@RequestMapping("/getGoodsByClass")
	List<Goods> getGoodsByClassId(@RequestParam("classId") String classId) {

		return goodsService.getGoodsByClassId(ConverterUtils.toInt(classId));

	}
	
	// ��ȡ������Ʒ
	@RequestMapping("/getGoodsByName")
	List<Goods> getGoodsByName(@RequestParam("name") String name) {

		return goodsService.getGoodsByName(name);

	}


}


