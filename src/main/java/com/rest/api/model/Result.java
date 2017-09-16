package com.rest.api.model;

import java.io.Serializable;


import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: Result
 * @Description: 返回结果说明
 * @author yuting.li
 * @version 1.0
 * @date 2017年8月7日 上午11:48:28
 */
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 3997124446365032582L;
	@ApiModelProperty(value = "业务码")
	private String code;
	@ApiModelProperty(value = "数据", required = true)
	private T data;
	@ApiModelProperty(value = "消息提示")
	private String msg;


	public Result() {
		super();
	}

	public Result(String code, String bizCode, String msg) {
		super();
		this.code = bizCode;
		this.msg = msg;
	}

	public Result(String code, String bizCode, String msg, T data) {
		super();
		this.code = bizCode;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setBizCodeSuccessInfo(SysCode bizCodeInfo) {
		this.code = bizCodeInfo.getCode();
		this.msg=bizCodeInfo.getMessage();
	}

	public void setBizCodeSuccessInfo(SysCode bizCodeInfo,T data) {
		this.code = bizCodeInfo.getCode();
		this.msg=bizCodeInfo.getMessage();
		this.data=data;
	}
	public void setBizCodeSuccessInfo(String code,String msg,T data) {
		this.code = code;
		this.msg = msg;
		this.setData(data);
	}
	public void setBizCodeFallInfo(SysCode bizCodeInfo) {
		this.code = SysCode.FAIL.getCode();
		this.msg=SysCode.FAIL.getMessage();
	}
	public void setBizCodeFallInfo(SysCode bizCodeInfo,T data) {
		this.code = SysCode.FAIL.getCode();
		this.msg=SysCode.FAIL.getMessage();
		this.setData(data);
	}
	public void setBizCodeFallInfo(SysCode bizCodeInfo, String msg) {
		this.code = SysCode.FAIL.getCode();
		this.msg = msg;
	}

	public void setBizCodeFallInfo(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
