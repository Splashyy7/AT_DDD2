package br.com.infnet.petfriends_almoxarifado.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "separacoes_pedido")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeparacaoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private Long pedidoId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusSeparacao status;

	public SeparacaoPedido(Long pedidoId) {
		this.pedidoId = pedidoId;
		this.status = StatusSeparacao.EM_PREPARACAO;
	}

	public void despachar() {
		validarStatusEmPreparacao();
		this.status = StatusSeparacao.DESPACHADO;
	}

	public void cancelar() {
		validarStatusEmPreparacao();
		this.status = StatusSeparacao.CANCELADO;
	}

	private void validarStatusEmPreparacao() {
		if (status != StatusSeparacao.EM_PREPARACAO) {
			throw new IllegalStateException(
					"Somente separações em preparação podem ser despachadas ou canceladas.");
		}
	}
}
