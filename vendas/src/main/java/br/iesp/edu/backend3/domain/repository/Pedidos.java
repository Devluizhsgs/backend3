package br.iesp.edu.backend3.domain.repository;

import br.iesp.edu.backend3.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido,Integer> {
}
