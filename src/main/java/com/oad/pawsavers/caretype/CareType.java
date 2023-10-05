package com.oad.pawsavers.caretype;

import com.oad.pawsavers.cares.Care;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "care_types")
public class CareType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "care_type_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "care_name", nullable = false)
    private String careName;

    @OneToMany(mappedBy = "careType", cascade = CascadeType.ALL)
    private List<Care> careList;

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

    public List<Care> getCareList() {
        return careList;
    }

    public void setCareList(List<Care> careList) {
        this.careList = careList;
    }
}
