package br.com.infnet.petfriends_transporte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infnet.petfriends_transporte.domain.TransportePedido;

public interface TransportePedidoRepository extends JpaRepository<TransportePedido, Long> {

	Optional<TransportePedido> findByPedido_Valor(Long valor);
}
