package br.com.infnet.petfriends_almoxarifado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infnet.petfriends_almoxarifado.domain.SeparacaoPedido;

public interface SeparacaoPedidoRepository extends JpaRepository<SeparacaoPedido, Long> {

	Optional<SeparacaoPedido> findByPedido_Valor(Long valor);
}
