package lvzhn.core;

import java.util.Map;

import lvzhn.core.enums.Success;

public class WebResponse {
	private Success success;

	private Map data;

	public Success getSuccess() {
		return success;
	}

	public void setSuccess(Success success) {
		this.success = success;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

}
