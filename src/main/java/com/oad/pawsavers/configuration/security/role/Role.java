package com.oad.pawsavers.configuration.security.role;

import com.oad.pawsavers.common.constants.ManagerRole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", columnDefinition = "serial")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ManagerRole name;

    public Role() {
    }

    public Role(ManagerRole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ManagerRole getName() {
        return name;
    }

    public void setName(ManagerRole name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
