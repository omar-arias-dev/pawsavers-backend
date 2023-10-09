package com.oad.pawsavers.breed;

import com.oad.pawsavers.pet.PetDTO;

import java.util.List;

public class BreedDetailsDTO {

    private Long breedId;
    private String breedName;
    private List<PetDTO> petDTOList;

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public List<PetDTO> getPetDTOList() {
        return petDTOList;
    }

    public void setPetDTOList(List<PetDTO> petDTOList) {
        this.petDTOList = petDTOList;
    }

    @Override
    public String toString() {
        return "BreedDetailsDTO{" +
                "breedId=" + breedId +
                ", breedName='" + breedName + '\'' +
                ", petDTOList=" + petDTOList +
                '}';
    }
}
