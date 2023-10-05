package com.oad.pawsavers.cares;

import com.oad.pawsavers.caretype.CareType;
import com.oad.pawsavers.employee.Employee;
import com.oad.pawsavers.pet.Pet;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cares")
public class Care {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "care_id", columnDefinition = "serial")
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
            name = "care_type_id",
            referencedColumnName = "care_type_id",
            foreignKey = @ForeignKey(name = "care_type_fk"),
            nullable = false
    )
    private CareType careType;

    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "employee_id"),
            nullable = false
    )
    private Employee employee;

    @Column(name = "care_date_time_start")
    private LocalDateTime careDateTimeStart;

    @Column(name = "care_date_time_end")
    private LocalDateTime careDateTimeEnd;

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

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getCareDateTimeStart() {
        return careDateTimeStart;
    }

    public void setCareDateTimeStart(LocalDateTime careDateTimeStart) {
        this.careDateTimeStart = careDateTimeStart;
    }

    public LocalDateTime getCareDateTimeEnd() {
        return careDateTimeEnd;
    }

    public void setCareDateTimeEnd(LocalDateTime careDateTimeEnd) {
        this.careDateTimeEnd = careDateTimeEnd;
    }

    @Override
    public String toString() {
        return "Care{" +
                "id=" + id +
                ", pet=" + pet +
                ", careType=" + careType +
                ", employee=" + employee +
                ", careDateTimeStart=" + careDateTimeStart +
                ", careDateTimeEnd=" + careDateTimeEnd +
                '}';
    }
}
