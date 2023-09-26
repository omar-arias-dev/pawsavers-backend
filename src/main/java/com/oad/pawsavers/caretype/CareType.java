package com.oad.pawsavers.caretype;

import jakarta.persistence.*;

@Entity
@Table(name = "care_types")
public class CareType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "care_type_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "care_name", nullable = false)
    private String careName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCareName() {
        return careName;
    }

    public void setCareName(String careName) {
        this.careName = careName;
    }
}
