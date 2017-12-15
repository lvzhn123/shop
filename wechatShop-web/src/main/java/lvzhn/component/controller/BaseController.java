package lvzhn.component.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

import lvzhn.core.Context;
import lvzhn.core.utils.ConverterUtils;

public class BaseController {
	protected Context context;

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.context = new Context();
		this.context.setRequest(request);
		this.context.setResponse(response);
	}
	
	protected int getUserId() {
		return ConverterUtils.toInt(this.context.getRequest().getSession().getAttribute("userId"));

	}
}
