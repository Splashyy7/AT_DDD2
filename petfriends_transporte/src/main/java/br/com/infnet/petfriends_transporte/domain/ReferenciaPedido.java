package br.com.infnet.petfriends_transporte.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReferenciaPedido {

	private Long valor;

	public ReferenciaPedido(Long valor) {
		this.valor = valor;
	}
}
