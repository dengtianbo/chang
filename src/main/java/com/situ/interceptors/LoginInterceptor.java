package com.situ.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.situ.model.User;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在到达Controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("@@user_login");
		if(user==null) {
			response.sendRedirect(request.getContextPath() + "/login");
			// return false表示请求至此为止。请求中断。
			return false;
		}else {
			// return true表示继续交给下一个拦截器，如果拦截器没有了，交给controller
			return true;
		}
	}

	
}
