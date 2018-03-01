package com.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mq.mqenum.MQEnum;

/**
 * 
 * @ClassName: RabbitMqSender   
 * @Description: rabbitmq发送消息工具类
 * @author yuting.li
 * @version 1.0 
 * @date 2018年3月1日 下午2:20:48
 */
@Component
public class RabbitMqSender{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void sendToQueue(String queue,Object obj) {
		rabbitTemplate.convertAndSend(queue, obj);
	}
	
	public void sendToTopic(String topic,Object obj) {
		rabbitTemplate.convertAndSend(MQEnum.CONTRACT_TOPIC.getCode(), topic, obj);
	}
	
	
}
