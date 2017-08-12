package com.util;

import com.rest.api.model.Result;

/**
 * 
 * @ClassName: ResultUtil   
 * @Description: 返回结果集
 * @author yuting.li
 * @version 1.0 
 * @date 2017年8月12日 下午4:45:56
 */
public class ResultUtil {
	
	/**
	 * 
	 * @Description: 返回结果集
	 * @author yuting.li
	 * @version 1.0 
	 * @date 2017年8月12日 下午4:47:32 
	 * @param t
	 * @param code
	 * @param msg
	 * @return 
	 * @return Result<Object>
	 */
	public static Result<Object> setData(Object t,Integer code,String msg){
		Result<Object> result = new Result<>();
		result.setData(t == null ? "{无数据}" : t);
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
}
