package com.mq;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.mq.entity.MQBean;

@Component
public class ReceiveMsg {
	
	@RabbitListener(queues="foo")
	@RabbitHandler
	public void process(@Payload String foo) {
		System.out.println(new Date() + ": " + foo);
	}
	
	@RabbitListener(queues="MQBean")
	@RabbitHandler
	public void process2(@Payload MQBean mq) {
		System.out.println("MQBean"+ new Date() + ": " + JSON.toJSONString(mq));
	}
	
	
	
}
