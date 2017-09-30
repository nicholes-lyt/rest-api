package com.rest.api.Interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rest.api.model.User;

/**
 * 
 * @ClassName: RestApiInterceptor   
 * @Description: rest 接口拦截器处理相关的验证逻辑
 * @author yuting.li
 * @version 1.0 
 * @date 2017年9月30日 上午11:07:58
 */
@Service("restApiInterceptor")
public class RestApiInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(RestApiInterceptor.class);
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		
		logger.info("获取拦截方法："+method);
		
		/*HttpSession session = request.getSession(true);
		User user = getLoginUser(session);
		if (user == null) {
			throw new NotLoginException(1111, "您未登录系统或者登录已超时,请重新登录");
		}*/
		
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}
	
	
	/**
	 * 得到登录用户对象
	 *
	 * @param session
	 *            会话对象
	 * @return User
	 */
	private User getLoginUser(HttpSession session) {
		if (session == null)
			return null;
		Object obj = session.getAttribute("loginUser");
		return obj != null && obj instanceof User ? (User) obj : null;
	}
	
}
