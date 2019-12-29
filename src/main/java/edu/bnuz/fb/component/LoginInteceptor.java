package edu.bnuz.fb.component;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.bnuz.fb.rbac.entity.User;

public class LoginInteceptor implements HandlerInterceptor {
	
	Logger log = LoggerFactory.getLogger(LoginInteceptor.class);
	/*
	 * 进入controller层之前拦截请求 返回值：表示是否将当前的请求拦截下来 false：拦截请求，请求别终止。true：请求不被拦截，继续执行
	 * Object obj:表示被拦的请求的目标对象（controller中方法）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		System.out.println("执行到了preHandle方法");
		StringBuffer requestURL = request.getRequestURL();
		log.info("当前访问路径为"+requestURL);
		User user = (User) request.getSession().getAttribute("session_user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/index.html");// 拦截后跳转的方法
			log.info("已成功拦截并转发跳转到首页");
			return false;
		}
		log.info("******"+user.getUserName()+"已登录******");
		return true;
	}

	/*
	 * 处理请求完成后视图渲染之前的处理操作 通过ModelAndView参数改变显示的视图，或发往视图的方法
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		System.out.println("执行了postHandle方法");

	}

}
