package br.iesp.edu.backend3.domain.repository;

import br.iesp.edu.backend3.Model.RoleModel;
import br.iesp.edu.backend3.domain.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {

    public List<RoleModel> findByRoleNameIn(List<RoleName> roles);

}