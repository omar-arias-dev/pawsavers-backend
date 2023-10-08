package com.oad.pawsavers.vaccinations;

import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.vaccine.Vaccine;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccination_id", columnDefinition = "serial")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "pet_id",
            referencedColumnName = "pet_id",
            foreignKey = @ForeignKey(name = "pet_fk"),
            nullable = false
    )
    private Pet pet;

    @ManyToOne
    @JoinColumn(
            name = "vaccine_id",
            referencedColumnName = "vaccine_id",
            foreignKey = @ForeignKey(name = "vaccine_fk"),
            nullable = false
    )
    private Vaccine vaccine;

    @Column(name = "vaccination_date", nullable = false)
    private LocalDate vaccinationDate;

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

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "id=" + id +
                ", pet=" + pet +
                ", vaccine=" + vaccine +
                ", vaccinationDate=" + vaccinationDate +
                '}';
    }
}
