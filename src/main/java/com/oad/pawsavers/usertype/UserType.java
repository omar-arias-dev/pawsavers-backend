package com.oad.pawsavers.usertype;

import com.oad.pawsavers.common.constants.UserTypes;
import com.oad.pawsavers.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_types")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "type", nullable = false, length = 20, unique = true)
    @Enumerated(EnumType.STRING)
    private UserTypes type;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserTypes getType() {
        return type;
    }

    public void setType(UserTypes type) {
        this.type = type;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
