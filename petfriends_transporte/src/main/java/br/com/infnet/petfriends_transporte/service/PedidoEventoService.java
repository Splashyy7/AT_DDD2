package br.com.infnet.petfriends_transporte.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.petfriends_transporte.config.MensageriaConfig;
import br.com.infnet.petfriends_transporte.domain.TransportePedido;
import br.com.infnet.petfriends_transporte.event.PedidoDespachadoEvent;
import br.com.infnet.petfriends_transporte.repository.TransportePedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoEventoService {

	private final TransportePedidoRepository transportePedidoRepository;

	@RabbitListener(queues = MensageriaConfig.QUEUE_PEDIDO_DESPACHADO)
	@Transactional
	public void receberPedidoDespachado(PedidoDespachadoEvent evento) {
		if (transportePedidoRepository.findByPedido_Valor(evento.getPedidoId()).isPresent()) {
			return;
		}

		transportePedidoRepository.save(new TransportePedido(evento.getPedidoId()));
	}
}
