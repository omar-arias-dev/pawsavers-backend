package com.oad.pawsavers.pet;

import com.oad.pawsavers.color.ColorDTO;

import java.util.List;

public class PetDetailsDTO {
    private Long petId;
    private String petName;
    private Integer petAge;
    private String petSize;
    private String petPersonality;
    private String petStatus;
    private String registrationDateTime;
    private String rescueDate;
    private String rescueHistory;
    private String petAvatar;
    private String specialFeatures;
    private List<ColorDTO> colorDTOList;

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetPersonality() {
        return petPersonality;
    }

    public void setPetPersonality(String petPersonality) {
        this.petPersonality = petPersonality;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    public String getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(String registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public String getRescueDate() {
        return rescueDate;
    }

    public void setRescueDate(String rescueDate) {
        this.rescueDate = rescueDate;
    }

    public String getRescueHistory() {
        return rescueHistory;
    }

    public void setRescueHistory(String rescueHistory) {
        this.rescueHistory = rescueHistory;
    }

    public String getPetAvatar() {
        return petAvatar;
    }

    public void setPetAvatar(String petAvatar) {
        this.petAvatar = petAvatar;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public List<ColorDTO> getColorDTOList() {
        return colorDTOList;
    }

    public void setColorDTOList(List<ColorDTO> colorDTOList) {
        this.colorDTOList = colorDTOList;
    }

    @Override
    public String toString() {
        return "PetDetailsDTO{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", petAge=" + petAge +
                ", petSize='" + petSize + '\'' +
                ", petPersonality='" + petPersonality + '\'' +
                ", petStatus='" + petStatus + '\'' +
                ", registrationDateTime='" + registrationDateTime + '\'' +
                ", rescueDate='" + rescueDate + '\'' +
                ", rescueHistory='" + rescueHistory + '\'' +
                ", petAvatar='" + petAvatar + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", colorDTOList=" + colorDTOList +
                '}';
    }
}
