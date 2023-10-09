package com.oad.pawsavers.specie;

import com.oad.pawsavers.breed.Breed;
import com.oad.pawsavers.pet.Pet;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "species")
public class Specie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specie_id", columnDefinition = "serial")
    private Long id;

    @Column(
            length = 25,
            nullable = false,
            unique = true
    )
    private String name;

    @OneToMany(mappedBy = "specie", cascade = CascadeType.ALL)
    private List<Pet> petList;

    @OneToMany(mappedBy = "specie", cascade = CascadeType.ALL)
    private List<Breed> breedList;

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

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }
}
