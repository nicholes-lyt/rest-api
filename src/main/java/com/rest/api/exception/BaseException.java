package com.rest.api.exception;

public class BaseException extends RuntimeException{

	/**
	 * @Description: 基本异常类
	 * author yuting.li
	 * @date 2017年9月14日 上午10:45:36 
	 * @version 1.0   
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int code;

	private String message;

	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BaseException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public BaseException(String message, int code, String message1) {
		super(message);
		this.code = code;
		this.message = message1;
	}

	public BaseException(String message, Throwable cause, int code, String message1) {
		super(message, cause);
		this.code = code;
		this.message = message1;
	}

	public BaseException(Throwable cause, int code, String message) {
		super(cause);
		this.code = code;
		this.message = message;
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
		this.message = message1;
	}

	public BaseException(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public BaseException(String message, int code, String message1, Object data) {
		super(message);
		this.code = code;
		this.message = message1;
		this.data = data;
	}

	public BaseException(String message, Throwable cause, int code, String message1, Object data) {
		super(message, cause);
		this.code = code;
		this.message = message1;
		this.data = data;
	}

	public BaseException(Throwable cause, int code, String message, Object data) {
		super(cause);
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1, Object data) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
		this.message = message1;
		this.data = data;
	}

	public BaseException(int code) {
		this.code = code;
	}

	public BaseException(String message, int code) {
		super(message);
		this.code = code;
	}

	public BaseException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}

	public BaseException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}

}
