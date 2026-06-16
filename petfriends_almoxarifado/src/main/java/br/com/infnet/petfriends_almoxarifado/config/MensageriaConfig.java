package br.com.infnet.petfriends_almoxarifado.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MensageriaConfig {

	public static final String EXCHANGE_PEDIDOS = "petfriends.pedidos";
	public static final String QUEUE_PEDIDO_ENVIADO = "petfriends.almoxarifado.pedido.enviado";
	public static final String ROUTING_KEY_PEDIDO_ENVIADO = "pedido.enviado.preparacao";

	@Bean
	Queue pedidoEnviadoQueue() {
		return new Queue(QUEUE_PEDIDO_ENVIADO, true);
	}

	@Bean
	TopicExchange pedidosExchange() {
		return new TopicExchange(EXCHANGE_PEDIDOS);
	}

	@Bean
	Binding pedidoEnviadoBinding(Queue pedidoEnviadoQueue, TopicExchange pedidosExchange) {
		return BindingBuilder.bind(pedidoEnviadoQueue)
				.to(pedidosExchange)
				.with(ROUTING_KEY_PEDIDO_ENVIADO);
	}
}
