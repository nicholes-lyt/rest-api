package com.rest.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rest.api.Interceptor.RestApiInterceptor;

@Configuration
public class RestApiConfiguration extends WebMvcConfigurerAdapter{
	
	@SuppressWarnings("unused")
	@Autowired
	private RestApiInterceptor restApiInterceptor;
	
	/**
	 * 
	 * 添加API请求拦截处理 <br><pre>
	 * 覆盖方法addInterceptors详细说明 <br>
	 * @author yuting.li
	 * @date 2017年9月30日 上午11:20:43 </pre>
	 * @param 参数类型 参数名 说明
	 * @return 返回值类型 说明
	 * @throws 异常类型 说明
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(restApiInterceptor);
	}
	
}
