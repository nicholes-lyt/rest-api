package com.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mq.mqenum.MQEnum;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	public Queue fooQueue() {
		return new Queue("foo");
	}
	
	@Bean
	public Queue MQBeanQueue() {
		return new Queue("MQBean");
	}
	
	//topic
	@Bean
	public Queue topic() {
		return new Queue("topic");
	}
	
	/**
	 * 
	 * @Description: 
	 * Fanout模式实现发布/订阅模式
	 * topic必须制定交换机类型
	 * @author yuting.li
	 * @version 1.0 
	 * @date 2018年3月1日 下午3:37:46 
	 * @return 
	 * @return FanoutExchange
	 */
	@Bean  
    FanoutExchange fanoutExchange() {  
        return new FanoutExchange(MQEnum.CONTRACT_TOPIC.getCode());  
    }  
  
    @Bean  
    Binding bindingExchangeA(Queue topic,FanoutExchange fanoutExchange) {  
        return BindingBuilder.bind(topic).to(fanoutExchange);  
    }  
 

}
