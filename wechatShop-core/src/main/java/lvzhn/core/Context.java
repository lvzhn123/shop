package lvzhn.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map form;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
		initForm(this.form, request);
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public Map getForm(){
		return this.form;
	}
	
	@SuppressWarnings("rawtypes")
	public void initForm(Map form, HttpServletRequest request) {
		form = request.getParameterMap();
	}
}
