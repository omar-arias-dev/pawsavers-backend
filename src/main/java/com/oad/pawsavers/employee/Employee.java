package com.oad.pawsavers.employee;

import com.oad.pawsavers.user.User;
import com.oad.pawsavers.visits.Visit;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(columnDefinition = "serial", name = "user_id", unique = true)
    private Long id;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_id_fk"),
            insertable = false,
            updatable = false,
            nullable = false)
    private User user;

    @OneToMany(mappedBy = "employee")
    private List<Visit> visitList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", hireDate=" + hireDate +
                ", user=" + user +
                '}';
    }
}
