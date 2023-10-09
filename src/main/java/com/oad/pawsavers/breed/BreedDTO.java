package com.oad.pawsavers.breed;

public class BreedDTO {

    private Long breedId;
    private String breedName;
    private Long specieId;

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

    public Long getSpecieId() {
        return specieId;
    }

    public void setSpecieId(Long specieId) {
        this.specieId = specieId;
    }

    @Override
    public String toString() {
        return "BreedDTO{" +
                "breedId=" + breedId +
                ", breedName='" + breedName + '\'' +
                ", specieId='" + specieId + '\'' +
                '}';
    }
}
