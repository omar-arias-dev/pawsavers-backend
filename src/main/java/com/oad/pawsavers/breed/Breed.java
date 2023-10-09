package com.oad.pawsavers.breed;

import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.specie.Specie;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id", columnDefinition = "serial")
    private Long id;

    @Column(
            length = 25,
            nullable = false
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "specie_id",
            foreignKey = @ForeignKey(name = "specie_fk"),
            nullable = false
    )
    private Specie specie;

    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL)
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

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
