package com.oad.pawsavers.petRescuer;

import com.oad.pawsavers.user.UserDTO;

public class PetRescuerDTO {

    private Long userId;
    private Integer rescuerLevel;
    private String rescueArea;
    private UserDTO userDTO;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "PetRescuerDTO{" +
                "userId=" + userId +
                ", rescuerLevel=" + rescuerLevel +
                ", rescueArea='" + rescueArea + '\'' +
                ", userDTO=" + userDTO +
                '}';
    }
}
