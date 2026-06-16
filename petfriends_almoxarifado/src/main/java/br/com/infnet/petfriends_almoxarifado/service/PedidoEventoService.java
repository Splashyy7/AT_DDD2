package br.com.infnet.petfriends_almoxarifado.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infnet.petfriends_almoxarifado.config.MensageriaConfig;
import br.com.infnet.petfriends_almoxarifado.domain.SeparacaoPedido;
import br.com.infnet.petfriends_almoxarifado.event.PedidoEnviadoParaPreparacaoEvent;
import br.com.infnet.petfriends_almoxarifado.repository.SeparacaoPedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoEventoService {

	private final SeparacaoPedidoRepository separacaoPedidoRepository;

	@RabbitListener(queues = MensageriaConfig.QUEUE_PEDIDO_ENVIADO)
	@Transactional
	public void receberPedidoEnviado(PedidoEnviadoParaPreparacaoEvent evento) {
		if (separacaoPedidoRepository.findByPedido_Valor(evento.getPedidoId()).isPresent()) {
			return;
		}

		separacaoPedidoRepository.save(new SeparacaoPedido(evento.getPedidoId()));
	}
}