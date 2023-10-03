package com.oad.pawsavers.adopts;

import com.oad.pawsavers.pet.PetDTO;
import com.oad.pawsavers.petadopter.PetAdopterDTO;

public class AdoptDetailsDTO {

    private Long adoptId;
    private String adoptDate;
    private String adoptNotes;
    private PetDTO petDTO;
    private PetAdopterDTO petAdopterDTO;

    public Long getAdoptId() {
        return adoptId;
    }

    public void setAdoptId(Long adoptId) {
        this.adoptId = adoptId;
    }

    public String getAdoptDate() {
        return adoptDate;
    }

    public void setAdoptDate(String adoptDate) {
        this.adoptDate = adoptDate;
    }

    public String getAdoptNotes() {
        return adoptNotes;
    }

    public void setAdoptNotes(String adoptNotes) {
        this.adoptNotes = adoptNotes;
    }

    public PetDTO getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    public PetAdopterDTO getPetAdopterDTO() {
        return petAdopterDTO;
    }

    public void setPetAdopterDTO(PetAdopterDTO petAdopterDTO) {
        this.petAdopterDTO = petAdopterDTO;
    }
}
