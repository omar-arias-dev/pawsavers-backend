package com.oad.pawsavers.adopts;

import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.petadopter.PetAdopter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "adopts")
public class Adopt {

    @Id
    @Column(
            name = "adopted_pet_id",
            columnDefinition = "serial",
            unique = true,
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "adopted_pet_id",
            referencedColumnName = "pet_id",
            foreignKey = @ForeignKey(name = "pet_fk"),
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Pet pet;

    @ManyToOne
    @JoinColumn(
            name = "pet_adopter_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "pet_adopter_fk"),
            nullable = false
    )
    private PetAdopter petAdopter;

    @Column(
            name = "adopt_date",
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private LocalDate adoptDate;

    private String notes;

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

    public PetAdopter getPetAdopter() {
        return petAdopter;
    }

    public void setPetAdopter(PetAdopter petAdopter) {
        this.petAdopter = petAdopter;
    }

    public LocalDate getAdoptDate() {
        return adoptDate;
    }

    public void setAdoptDate(LocalDate adoptDate) {
        this.adoptDate = adoptDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Adopt{" +
                "id=" + id +
                ", pet=" + pet +
                ", petAdopter=" + petAdopter +
                ", adoptDate=" + adoptDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
