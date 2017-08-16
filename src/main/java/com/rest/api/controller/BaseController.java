package com.rest.api.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

/**
 * 
 * @ClassName: BaseController   
 * @Description:多请求映射控制器
 * @author yuting.li
 * @version 1.0 
 * @date 2017年8月16日 上午11:56:50
 */
@Controller
public class BaseController implements ApplicationContextAware {
	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
