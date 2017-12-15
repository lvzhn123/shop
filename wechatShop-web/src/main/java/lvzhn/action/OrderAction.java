package lvzhn.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lvzhn.component.controller.BaseController;
import lvzhn.component.service.IOrderService;
import lvzhn.core.WebResponse;
import lvzhn.core.enums.Success;
import lvzhn.core.utils.JsonTools;
import net.sf.json.JSONObject;

@RestController
public class OrderAction extends BaseController {

	@Autowired
	IOrderService orderService;

	// ×¢Ïú
	@RequestMapping("/saveOrder")
	WebResponse saveOrder() {
		WebResponse wr = new WebResponse();
		wr.setSuccess(Success.success);
		String orders = this.context.getRequest().getParameter("order");
		String odLists = this.context.getRequest().getParameter("odList");
		int userid = getUserId();
		JSONObject jb = JSONObject.fromObject(orders);
		Map<String, Object> order = (Map<String, Object>) jb;

		List<Map<String, Object>> odList = JsonTools.parseJSON2List(odLists);
		orderService.SaveOrder(userid, order, odList);
		return wr;

	}

}
