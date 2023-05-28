package br.iesp.edu.backend3.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="url_permissao")
public class UrlPermissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissaoId;

    @Column(nullable = false)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "permissao_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<RoleModel> roles;

    public Long getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(Long permissaoId) {
        this.permissaoId = permissaoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }
}