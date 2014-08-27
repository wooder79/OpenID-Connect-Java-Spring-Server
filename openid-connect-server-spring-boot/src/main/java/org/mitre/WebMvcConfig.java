package org.mitre;

import org.mitre.openid.connect.web.ServerConfigInterceptor;
import org.mitre.openid.connect.web.UserInfoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public UserInfoInterceptor getUserInfoInterceptor() {
		return new UserInfoInterceptor();
	}
	
	@Bean
	public ServerConfigInterceptor getServerConfigInterceptor() {
		return new ServerConfigInterceptor();
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserInfoInterceptor());
        registry.addInterceptor(getServerConfigInterceptor());
    }

}