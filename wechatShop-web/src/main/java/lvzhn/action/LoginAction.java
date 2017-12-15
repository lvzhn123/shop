package lvzhn.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lvzhn.component.controller.BaseController;
import lvzhn.component.service.ILoginService;
import lvzhn.core.WebResponse;
import lvzhn.core.enums.Success;

@RestController
public class LoginAction extends BaseController {

	@Autowired
	ILoginService loginService;

	// µÇÂ½
	@RequestMapping("/doLogin")
	WebResponse doLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

		WebResponse wr = new WebResponse();
		if (loginService.loginSuccess(this.context, username, password)) {

			wr.setSuccess(Success.success);
		} else {
			wr.setSuccess(Success.fail);
		}
		return wr;
	}

	// ×¢Ïú
	@RequestMapping("/doLogout")
	WebResponse doLogout() {
		return null;

	}

	// Ô]ƒÔ
	@RequestMapping("/signUp")
	WebResponse signUp() {
		return null;
	}
}
