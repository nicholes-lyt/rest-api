package com.rest.api.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.api.model.Result;
import com.rest.api.model.SysCode;

@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	@SuppressWarnings("deprecation")
	@Override
	@ResponseBody
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error(String.format("remote host %s ,uri %s , referer %s", request.getLocale(), request.getContextPath(), request.getHeader(HttpHeaders.REFERER)));
        logger.error(ex.getMessage(), ex);
		Result<Object> result = new Result<Object>();
		String msg = "系统内部错误";
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
				|| ex instanceof MissingServletRequestPartException || ex instanceof BindException) {
			msg = "错误请求";
		} else if(ex instanceof NotLoginException) {
			msg = "未登录";
		} else if(ex instanceof MethodArgumentNotValidException){
			// 对象值验证
			MethodArgumentNotValidException valid = (MethodArgumentNotValidException)ex;
			BindingResult bindingResult = valid.getBindingResult();
	        List<FieldError> listFieldError = bindingResult.getFieldErrors();
	        List<Map<String, String>> validList = new ArrayList<>();
	        for(FieldError fieldError : listFieldError){
	        	Map<String, String> mapmsg = new HashMap<>();
	        	mapmsg.put(fieldError.getField(), fieldError.getDefaultMessage());
	            validList.add(mapmsg);
	        }
	        result.setBizCodeFallInfo(SysCode.SYS_PARAM_ERROR,validList);
			return new ResponseEntity<>(result, headers, status);
		} else {
			logger.error("系统错误", ex);
			msg = ex.getMessage();
		}

		
		result.setBizCodeFallInfo(SysCode.FAIL,msg);

		return new ResponseEntity<>(result, headers, status);
	}
	
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Result handleException(Throwable e, HttpServletResponse response) throws IOException {
		logger.error(e.getMessage(), e);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		Result<Object> result = new Result<Object>();
		if (e.getCause() instanceof ValidationException || e instanceof ValidationException) {
			result.setBizCodeFallInfo(SysCode.FAIL, e.getCause().getMessage());
		} else {
			if (!StringUtils.isEmpty(e.getMessage())) {
				result.setBizCodeFallInfo(SysCode.FAIL, e.getMessage());
			} else {
				result.setBizCodeFallInfo(SysCode.FAIL, "系统异常!!!");
			}
		}
		return result;
	}


}
