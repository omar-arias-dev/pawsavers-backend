package com.oad.pawsavers.petadopter;

import com.oad.pawsavers.common.constants.MaritalStatus;
import com.oad.pawsavers.common.constants.Sizes;
import com.oad.pawsavers.user.User;
import com.oad.pawsavers.visits.Visit;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pet_adopters")
public class PetAdopter {

    @Id
    @Column(columnDefinition = "serial", name = "user_id", unique = true)
    private Long id;

    @Column(name = "home_size", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sizes homeSize;

    @Column(name = "number_of_pets", nullable = false)
    private Integer numberOfPets;

    @Column(name = "marital_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    private String avatar;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_id_fk"),
            insertable = false,
            updatable = false,
            nullable = false)
    private User user;

    @OneToMany(mappedBy = "petAdopter")
    private List<Visit> visitList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sizes getHomeSize() {
        return homeSize;
    }

    public void setHomeSize(Sizes homeSize) {
        this.homeSize = homeSize;
    }

    public Integer getNumberOfPets() {
        return numberOfPets;
    }

    public void setNumberOfPets(Integer numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
        return "PetAdopter{" +
                "id=" + id +
                ", homeSize=" + homeSize +
                ", numberOfPets=" + numberOfPets +
                ", maritalStatus=" + maritalStatus +
                ", avatar='" + avatar + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
