package com.oad.pawsavers.pet;

import com.oad.pawsavers.breed.BreedDTO;
import com.oad.pawsavers.color.ColorDTO;
import com.oad.pawsavers.specie.SpecieDTO;
import com.oad.pawsavers.vaccinations.VaccinationDTO;

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
    private SpecieDTO specieDTO;
    private BreedDTO breedDTO;
    private List<ColorDTO> colorDTOList;
    private List<VaccinationDTO> vaccinationDTOList;

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

    public SpecieDTO getSpecieDTO() {
        return specieDTO;
    }

    public void setSpecieDTO(SpecieDTO specieDTO) {
        this.specieDTO = specieDTO;
    }

    public BreedDTO getBreedDTO() {
        return breedDTO;
    }

    public void setBreedDTO(BreedDTO breedDTO) {
        this.breedDTO = breedDTO;
    }

    public List<ColorDTO> getColorDTOList() {
        return colorDTOList;
    }

    public void setColorDTOList(List<ColorDTO> colorDTOList) {
        this.colorDTOList = colorDTOList;
    }

    public List<VaccinationDTO> getVaccinationDTOList() {
        return vaccinationDTOList;
    }

    public void setVaccinationDTOList(List<VaccinationDTO> vaccinationDTOList) {
        this.vaccinationDTOList = vaccinationDTOList;
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
                ", specieDTO=" + specieDTO +
                ", breedDTO=" + breedDTO +
                ", colorDTOList=" + colorDTOList +
                ", vaccinationDTOList=" + vaccinationDTOList +
                '}';
    }
}
