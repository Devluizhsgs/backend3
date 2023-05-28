package br.iesp.edu.backend3.domain.repository;

import br.iesp.edu.backend3.Model.UrlPermissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlPermissaoRepository extends JpaRepository<UrlPermissao, Long> {
}
