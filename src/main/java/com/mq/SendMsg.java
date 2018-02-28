package com.mq;

import java.util.Arrays;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.mq.entity.MQBean;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SendMsg {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(cron="0 0 12 * * ?")
	public void send() {
		this.rabbitTemplate.convertAndSend("foo", "hello");
	}
	
	@Scheduled(cron="0 0 12 * * ?")
	public void sendObject() {
		MQBean mq = new MQBean();
		mq.setId(1L);
		mq.setName("MQ实体");
		String str = "is list";
		mq.setStrs(Arrays.asList(str));
		log.debug("MQ实体"+ (JSON.toJSONString(mq)));
		rabbitTemplate.convertAndSend("MQBean", mq);
	}
	
	
	public void sendMsg(MQBean msg) {
		rabbitTemplate.convertAndSend("MQBean", msg);
	}

}
