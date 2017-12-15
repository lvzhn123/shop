package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class loginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String url = arg0.getRequestURI();
		if (url.indexOf("login") >= 0||url.indexOf("doLogin") >= 0) {
			return true;
		}

		HttpSession session = arg0.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			return true;
		}
		String context = arg0.getContextPath();
		arg1.sendRedirect(context + "/login");
		return false;
	}

}
