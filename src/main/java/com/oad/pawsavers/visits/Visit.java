package com.oad.pawsavers.visits;

import com.oad.pawsavers.employee.Employee;
import com.oad.pawsavers.petadopter.PetAdopter;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id", columnDefinition = "serial")
    private Long visitId;

    @Column(nullable = false)
    private String notes;

    @Column(name = "visit_date_time", nullable = false)
    private LocalDateTime visitDateTime;

    @ManyToOne
    @JoinColumn(name = "employee_id",
            foreignKey = @ForeignKey(name = "employee_id_fk"),
            referencedColumnName = "user_id"
    )
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "pet_adopter_id",
            foreignKey = @ForeignKey(name = "pet_adopter_id_fk"),
            referencedColumnName = "user_id"
    )
    private PetAdopter petAdopter;

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getVisitDateTime() {
        return visitDateTime;
    }

    public void setVisitDateTime(LocalDateTime visitDateTime) {
        this.visitDateTime = visitDateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PetAdopter getPetAdopter() {
        return petAdopter;
    }

    public void setPetAdopter(PetAdopter petAdopter) {
        this.petAdopter = petAdopter;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + visitId +
                ", notes='" + notes + '\'' +
                ", visitDateTime=" + visitDateTime +
                '}';
    }
}
