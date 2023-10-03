package com.oad.pawsavers.pet;

import com.oad.pawsavers.adopts.Adopt;
import com.oad.pawsavers.common.constants.PetPersonality;
import com.oad.pawsavers.common.constants.PetSize;
import com.oad.pawsavers.common.constants.PetStatus;
import com.oad.pawsavers.rescues.Rescue;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", columnDefinition = "serial")
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSize size;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetPersonality personality;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetStatus status;

    @CreationTimestamp
    @Column(
            name = "registration_date_time",
            nullable = false,
            updatable = false
    )
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registrationDateTime;

    @Column(name = "rescue_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate rescueDate;

    @Column(name = "rescue_history", nullable = false)
    private String rescueHistory;

    private String avatar;

    @Column(name = "special_features")
    private String specialFeatures;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Rescue> rescueList;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Adopt> adoptList;

    public List<Rescue> getRescueList() {
        return rescueList;
    }

    public void setRescueList(List<Rescue> rescueList) {
        this.rescueList = rescueList;
    }

    public List<Adopt> getAdoptList() {
        return adoptList;
    }

    public void setAdoptList(List<Adopt> adoptList) {
        this.adoptList = adoptList;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PetSize getSize() {
        return size;
    }

    public void setSize(PetSize size) {
        this.size = size;
    }

    public PetPersonality getPersonality() {
        return personality;
    }

    public void setPersonality(PetPersonality personality) {
        this.personality = personality;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public LocalDate getRescueDate() {
        return rescueDate;
    }

    public void setRescueDate(LocalDate rescueDate) {
        this.rescueDate = rescueDate;
    }

    public String getRescueHistory() {
        return rescueHistory;
    }

    public void setRescueHistory(String rescueHistory) {
        this.rescueHistory = rescueHistory;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
}
