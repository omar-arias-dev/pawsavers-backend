package com.oad.pawsavers.petrescuer;

import com.oad.pawsavers.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "pet_rescuers")
public class PetRescuer {

    @Id
    @Column(columnDefinition = "serial", name = "user_id", unique = true)
    private Long userId;

    @Column(name = "rescuer_level")
    private Integer rescuerLevel = 0;

    @Column(name = "recue_area")
    private String rescueArea;

    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_id_fk"),
            insertable = false,
            updatable = false,
            nullable = false)
    private User user;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRescuerLevel() {
        return rescuerLevel;
    }

    public void setRescuerLevel(Integer rescuerLevel) {
        this.rescuerLevel = rescuerLevel;
    }

    public String getRescueArea() {
        return rescueArea;
    }

    public void setRescueArea(String rescueArea) {
        this.rescueArea = rescueArea;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PetRescuer{" +
                "userId=" + userId +
                ", rescuerLevel=" + rescuerLevel +
                ", rescueArea='" + rescueArea + '\'' +
                ", user=" + user +
                '}';
    }
}
