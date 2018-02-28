package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mq.SendMsg;
import com.mq.entity.MQBean;

import io.swagger.annotations.Api;

@Api(value = "MQ管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController("/msg")
public class MsgController {
	
	@Autowired
	private SendMsg sendMsg;
	
	@PostMapping(value="/sendMsg")
	public String sendMsg(@RequestBody MQBean msg) {
		String result = "success";
		try {
			sendMsg.sendMsg(msg);
		} catch (Exception e) {
			e.getStackTrace();
			result = "faile";
		}
		return result;
	}
	
	
}
