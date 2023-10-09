package com.oad.pawsavers.breed;

import com.oad.pawsavers.specie.SpecieDTO;

public class BreedViewDTO {

    private Long breedId;
    private String breedName;
    private SpecieDTO specieDTO;

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

    public SpecieDTO getSpecieDTO() {
        return specieDTO;
    }

    public void setSpecieDTO(SpecieDTO specieDTO) {
        this.specieDTO = specieDTO;
    }

    @Override
    public String toString() {
        return "BreedViewDTO{" +
                "breedId=" + breedId +
                ", breedName='" + breedName + '\'' +
                ", specieDTO=" + specieDTO +
                '}';
    }
}
