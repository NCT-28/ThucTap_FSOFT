package vn.com.heyzo.springbootrabbitmq.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

	@Bean
	Queue marketingQueue() {
		return new Queue("marketingQueueHD", false);
	}

	@Bean
	Queue financeQueue() {
		return new Queue("financeQueueHd", false);
	}

	@Bean
	Queue adminQueue() {
		return new Queue("adminQueueHd", false);
	}

	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange("header-exchange");
	}

	@Bean
	Binding marketingBinding(Queue marketingQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(marketingQueue).to(headerExchange).where("department").matches("marketing");
	}

	@Bean
	Binding financeBinding(Queue financeQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(financeQueue).to(headerExchange).where("department").matches("finance");
	}

	@Bean
	Binding adminBinding(Queue adminQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(adminQueue).to(headerExchange).where("department").matches("admin");
	}

}
