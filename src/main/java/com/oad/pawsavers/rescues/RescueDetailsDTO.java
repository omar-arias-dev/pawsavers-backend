package com.oad.pawsavers.rescues;

import com.oad.pawsavers.pet.PetDTO;
import com.oad.pawsavers.petrescuer.PetRescuerDTO;

public class RescueDetailsDTO {
    private Long rescuedPetId;
    private PetDTO petDTO;
    private PetRescuerDTO petRescuerDTO;

    public Long getRescuedPetId() {
        return rescuedPetId;
    }

    public void setRescuedPetId(Long rescuedPetId) {
        this.rescuedPetId = rescuedPetId;
    }

    public PetDTO getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    public PetRescuerDTO getPetRescuerDTO() {
        return petRescuerDTO;
    }

    public void setPetRescuerDTO(PetRescuerDTO petRescuerDTO) {
        this.petRescuerDTO = petRescuerDTO;
    }

    @Override
    public String toString() {
        return "RescueDTO{" +
                "rescuedPetId=" + rescuedPetId +
                ", petDTO=" + petDTO +
                ", petRescuerDTO=" + petRescuerDTO +
                '}';
    }
}
