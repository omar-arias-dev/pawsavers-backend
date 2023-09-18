package com.oad.pawsavers.petrescuer;

import com.oad.pawsavers.user.UserDTO;

public class PetRescuerDTO {

    private Long petRescuerId;
    private Integer rescuerLevel;
    private String rescueArea;
    private UserDTO userDTO;

    public Long getPetRescuerId() {
        return petRescuerId;
    }

    public void setPetRescuerId(Long petRescuerId) {
        this.petRescuerId = petRescuerId;
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
                "petRescuerId=" + petRescuerId +
                ", rescuerLevel=" + rescuerLevel +
                ", rescueArea='" + rescueArea + '\'' +
                ", userDTO=" + userDTO +
                '}';
    }
}
