package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mq.RabbitMqSender;
import com.mq.SendMsg;
import com.mq.entity.MQBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "MQ管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController("/msg")
public class MsgController {
	
	@Autowired
	private SendMsg sendMsg;
	
	@Autowired
	private RabbitMqSender rabbitMqSender;
	
	private final String msgTopic = "topic";
	
	private final String msgQueue = "MQBean";
	

	@ApiOperation(value = "点对点发送消息", notes = "发送MQ消息")
	@PostMapping(value="/sendMsg")
	@ResponseBody
	public String sendMsg(@RequestBody MQBean msg) {
		String result = "success";
		try {
			sendMsg.sendMsg(msg);
			rabbitMqSender.sendToQueue(msgQueue, msg);
		} catch (Exception e) {
			e.getStackTrace();
			result = "faile";
		}
		return result;
	}
	

	@ApiOperation(value = "广播发送消息", notes = "发送MQ消息")
	@PostMapping(value="/sendToTopic")
	@ResponseBody
	public String sendToTopic(@RequestBody MQBean msg) {
		String result = "success";
		try {
			rabbitMqSender.sendToTopic(msgTopic, msg);
		} catch (Exception e) {
			e.getStackTrace();
			result = "faile";
		}
		return result;
	}
	
}
