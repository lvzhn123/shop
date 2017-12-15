package lvzhn.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import interceptor.loginInterceptor;

@Configuration // ��ע���ļ�Ϊһ�������spring boot�Ż�ɨ�赽�����á���ע��������֮ǰʹ��xml��������
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new loginInterceptor()).addPathPatterns("/**"); //
	}
}
