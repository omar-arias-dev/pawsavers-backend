package com.oad.pawsavers.vaccinations;

public class VaccinationDTO {
    private Long vaccinationId;
    private Long petId;
    private Long vaccineId;
    private String vaccinationDate;

    public Long getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Long vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public String toString() {
        return "VaccinationDTO{" +
                "vaccinationId=" + vaccinationId +
                ", petId=" + petId +
                ", vaccineId=" + vaccineId +
                ", vaccinationDate='" + vaccinationDate + '\'' +
                '}';
    }
}
