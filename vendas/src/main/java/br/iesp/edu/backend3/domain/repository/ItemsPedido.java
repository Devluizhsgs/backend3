package br.iesp.edu.backend3.domain.repository;

import br.iesp.edu.backend3.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido,Integer> {
}
