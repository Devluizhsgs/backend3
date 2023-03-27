package br.iesp.edu.backend3.domain.repository;

import br.iesp.edu.backend3.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}