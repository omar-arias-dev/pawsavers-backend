package com.oad.pawsavers.vaccinations;

import com.oad.pawsavers.pet.PetDTO;
import com.oad.pawsavers.vaccine.VaccineDTO;

public class VaccinationDetailsDTO {
    private Long vaccinationId;
    private PetDTO petDTO;
    private VaccineDTO vaccineDTO;
    private String vaccinationDate;

    public Long getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Long vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public PetDTO getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    public VaccineDTO getVaccineDTO() {
        return vaccineDTO;
    }

    public void setVaccineDTO(VaccineDTO vaccineDTO) {
        this.vaccineDTO = vaccineDTO;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public String toString() {
        return "VaccinationDetailsDTO{" +
                "vaccinationId=" + vaccinationId +
                ", petDTO=" + petDTO +
                ", vaccineDTO=" + vaccineDTO +
                ", vaccinationDate='" + vaccinationDate + '\'' +
                '}';
    }
}
