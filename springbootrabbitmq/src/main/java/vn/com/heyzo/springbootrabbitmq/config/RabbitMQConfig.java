package vn.com.heyzo.springbootrabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.com.heyzo.springbootrabbitmq.service.RabbitMQListner;

@Configuration
public class RabbitMQConfig {

	  @Value("${javainuse.rabbitmq.queue}")
	  String queueName;

	  @Value("${javainuse.rabbitmq.exchange}")
	  String exchange;

	  @Value("${javainuse.rabbitmq.routingkey}")
	  private String routingkey;

	  @Bean
	  Queue queue() {
	  	return new Queue(queueName, false);
	  }

       //create MessageListenerContainer using default connection factory
	  @Bean
	  MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory ) {
	  	SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
	  	simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
	  	simpleMessageListenerContainer.setQueues(queue());
	  	simpleMessageListenerContainer.setMessageListener(new RabbitMQListner());
	  	return simpleMessageListenerContainer;

	 }
    
     //create custom connection factory
	/*@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername(username);
		cachingConnectionFactory.setUsername(password);
		return cachingConnectionFactory;
	}*/
	
     //create MessageListenerContainer using custom connection factory
	/*@Bean
	MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(queue());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQListner());
		return simpleMessageListenerContainer;

	}*/
	
}
