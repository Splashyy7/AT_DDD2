package br.com.infnet.petfriends_almoxarifado.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoEnviadoParaPreparacaoEvent {

	private Long pedidoId;
}
