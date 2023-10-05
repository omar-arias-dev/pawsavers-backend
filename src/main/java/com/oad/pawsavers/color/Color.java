package com.oad.pawsavers.color;

import com.oad.pawsavers.pet.Pet;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id", columnDefinition = "serial")
    private Long id;

    @Column(nullable = false, length = 15, unique = true)
    private String name;

    @Column(nullable = false, length = 6, unique = true)
    private String hex;

    @ManyToMany(mappedBy = "colorList")
    private List<Pet> petList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
