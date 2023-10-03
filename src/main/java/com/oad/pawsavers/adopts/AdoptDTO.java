package com.oad.pawsavers.adopts;

public class AdoptDTO {

    private Long adoptId;
    private String adoptDate;
    private String adoptNotes;
    private Long petId;
    private Long petAdopterId;

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

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getPetAdopterId() {
        return petAdopterId;
    }

    public void setPetAdopterId(Long petAdopterId) {
        this.petAdopterId = petAdopterId;
    }

    @Override
    public String toString() {
        return "AdoptDTO{" +
                "adoptId=" + adoptId +
                ", adoptDate='" + adoptDate + '\'' +
                ", adoptNotes='" + adoptNotes + '\'' +
                ", petId=" + petId +
                ", petAdopterId=" + petAdopterId +
                '}';
    }
}
