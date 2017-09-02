package com.rest.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("deprecation")
	@Override
	@ResponseBody
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String msg = "系统内部错误";
	    ex.printStackTrace();
		if (ex instanceof org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException
				|| ex instanceof NoHandlerFoundException) {
			msg = "未找到";
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			msg = "方法禁用";
		} else if (ex instanceof HttpMediaTypeNotSupportedException) {
			msg = "不支持的媒体类型";
		} else if (ex instanceof HttpMediaTypeNotAcceptableException) {
			msg = "不接受";
		} else if (ex instanceof MissingServletRequestParameterException || ex instanceof ServletRequestBindingException
				|| ex instanceof TypeMismatchException || ex instanceof HttpMessageNotReadableException
				|| ex instanceof MethodArgumentNotValidException || ex instanceof MethodArgumentNotValidException
				|| ex instanceof MissingServletRequestPartException || ex instanceof BindException) {
			msg = "错误请求";
		} else {
			logger.error("系统错误", ex);

			msg = ex.getMessage();
		}

		Map<String, Object> map = new HashMap<>(2);

		map.put("status", status.value());
		map.put("msg", msg);

		return new ResponseEntity<>(map, headers, status);
	}
}
