package lvzhn.component.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lvzhn.component.dao.UserDao;
import lvzhn.component.service.ILoginService;
import lvzhn.core.Context;
import lvzhn.entity.User;

@Service
public class LoginService implements ILoginService {

	@Autowired
	UserDao userDao;

	public boolean loginSuccess(Context context, String username, String password) {

		User user = userDao.selectByUsername(username);
		if (user == null) {
			return false;
		}
		if (!user.getPassword().equals(password)) {
			return false;
		}
		HttpSession session = context.getRequest().getSession();
		session.setAttribute("username", user.getUsername());
		session.setAttribute("userId", user.getUserid());

		return true;
	}

}
