package com.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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


}
