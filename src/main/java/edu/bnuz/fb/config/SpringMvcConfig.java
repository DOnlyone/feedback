package edu.bnuz.fb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvcConfigurerAdapter 已过时取而代之的是WebMvcConfigurationSupport 
 * @author zookeeper
 *
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurationSupport {

	
	/*
	 * @Override protected void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new
	 * DemoInterceptor()).addPathPatterns("/login").excludePathPatterns("/static/**"
	 * ); }
	 */

	    @Override	    
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
			super.addResourceHandlers(registry);
	    }
}
