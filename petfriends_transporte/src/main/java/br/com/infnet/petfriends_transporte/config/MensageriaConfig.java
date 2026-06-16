package br.com.infnet.petfriends_transporte.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MensageriaConfig {

	public static final String EXCHANGE_PEDIDOS = "petfriends.pedidos";
	public static final String QUEUE_PEDIDO_DESPACHADO = "petfriends.transporte.pedido.despachado";
	public static final String ROUTING_KEY_PEDIDO_DESPACHADO = "pedido.despachado";

	@Bean
	Queue pedidoDespachadoQueue() {
		return new Queue(QUEUE_PEDIDO_DESPACHADO, true);
	}

	@Bean
	TopicExchange pedidosExchange() {
		return new TopicExchange(EXCHANGE_PEDIDOS);
	}

	@Bean
	Binding pedidoDespachadoBinding(Queue pedidoDespachadoQueue, TopicExchange pedidosExchange) {
		return BindingBuilder.bind(pedidoDespachadoQueue)
				.to(pedidosExchange)
				.with(ROUTING_KEY_PEDIDO_DESPACHADO);
	}
}
