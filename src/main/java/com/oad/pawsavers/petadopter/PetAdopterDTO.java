package com.oad.pawsavers.petadopter;

import com.oad.pawsavers.user.UserDTO;

public class PetAdopterDTO {

    private Long petAdopterId;
    private String sizeOfHome;
    private Integer petsNumber;
    private String maritalStatus;
    private String petAdopterAvatar;
    private String commentsAboutPetAdopter;
    private UserDTO userDTO;

    public Long getPetAdopterId() {
        return petAdopterId;
    }

    public void setPetAdopterId(Long petAdopterId) {
        this.petAdopterId = petAdopterId;
    }

    public String getSizeOfHome() {
        return sizeOfHome;
    }

    public void setSizeOfHome(String sizeOfHome) {
        this.sizeOfHome = sizeOfHome;
    }

    public Integer getPetsNumber() {
        return petsNumber;
    }

    public void setPetsNumber(Integer petsNumber) {
        this.petsNumber = petsNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPetAdopterAvatar() {
        return petAdopterAvatar;
    }

    public void setPetAdopterAvatar(String petAdopterAvatar) {
        this.petAdopterAvatar = petAdopterAvatar;
    }

    public String getCommentsAboutPetAdopter() {
        return commentsAboutPetAdopter;
    }

    public void setCommentsAboutPetAdopter(String commentsAboutPetAdopter) {
        this.commentsAboutPetAdopter = commentsAboutPetAdopter;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "PetAdopterDTO{" +
                "petAdopterId=" + petAdopterId +
                ", sizeOfHome='" + sizeOfHome + '\'' +
                ", petsNumber=" + petsNumber +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", petAdopterAvatar='" + petAdopterAvatar + '\'' +
                ", commentsAboutPetAdopter='" + commentsAboutPetAdopter + '\'' +
                ", userDTO=" + userDTO +
                '}';
    }
}
