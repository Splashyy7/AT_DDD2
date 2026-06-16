package br.com.infnet.petfriends_transporte.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "transportes_pedido")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TransportePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private ReferenciaPedido pedido;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusTransporte status;

	public TransportePedido(Long pedidoId) {
		this.pedido = new ReferenciaPedido(pedidoId);
		this.status = StatusTransporte.EM_TRANSITO;
	}

	public void entregar() {
		validarStatusEmTransito();
		this.status = StatusTransporte.ENTREGUE;
	}

	public void devolver() {
		validarStatusEmTransito();
		this.status = StatusTransporte.DEVOLVIDO;
	}

	public void extraviar() {
		validarStatusEmTransito();
		this.status = StatusTransporte.EXTRAVIADO;
	}

	private void validarStatusEmTransito() {
		if (status != StatusTransporte.EM_TRANSITO) {
			throw new IllegalStateException(
					"Somente transportes em trânsito podem ser entregues, devolvidos ou extraviados.");
		}
	}
}
