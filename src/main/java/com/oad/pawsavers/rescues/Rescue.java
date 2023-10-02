package com.oad.pawsavers.rescues;

import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.petrescuer.PetRescuer;
import jakarta.persistence.*;

@Entity
@Table(name = "rescues")
public class Rescue {

    @Id
    @Column(
            name = "rescued_pet_id",
            columnDefinition = "serial",
            unique = true,
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "rescued_pet_id",
            referencedColumnName = "pet_id",
            foreignKey = @ForeignKey(name = "pet_fk"),
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Pet pet;

    @ManyToOne
    @JoinColumn(
            name = "pet_rescuer_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "pet_rescuer_fk"),
            nullable = false,
            insertable = false
    )
    private PetRescuer petRescuer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public PetRescuer getPetRescuer() {
        return petRescuer;
    }

    public void setPetRescuer(PetRescuer petRescuer) {
        this.petRescuer = petRescuer;
    }
}
