package edu.bnuz.fb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import edu.bnuz.fb.component.LoginInteceptor;

/**
 * WebMvcConfigurerAdapter 已过时取而代之的是WebMvcConfigurationSupport 
 * @author zookeeper
 *
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurationSupport {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("index.html");
		//WebMvcConfigurer.super.addViewControllers(registry);
	}

	

	    @Override	    
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	    	registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
			super.addResourceHandlers(registry);
	    }
	    
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new LoginInteceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/index.html","/login","/asserts/**","/static/**","/webjars/**","/getVcode","/logout","/api/**");
			//WebMvcConfigurer.super.addInterceptors(registry);
		}
}
