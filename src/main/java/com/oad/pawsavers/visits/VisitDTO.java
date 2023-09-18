package com.oad.pawsavers.visits;

public class VisitDTO {

    private Long idOfVisit;
    private String visitNotes;
    private String visitDate;
    private Long employeeId;
    private Long petAdopterId;

    public Long getIdOfVisit() {
        return idOfVisit;
    }

    public void setIdOfVisit(Long idOfVisit) {
        this.idOfVisit = idOfVisit;
    }

    public String getVisitNotes() {
        return visitNotes;
    }

    public void setVisitNotes(String visitNotes) {
        this.visitNotes = visitNotes;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getPetAdopterId() {
        return petAdopterId;
    }

    public void setPetAdopterId(Long petAdopterId) {
        this.petAdopterId = petAdopterId;
    }

    @Override
    public String toString() {
        return "VisitDTO{" +
                "idOfVisit=" + idOfVisit +
                ", visitNotes='" + visitNotes + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", employeeId=" + employeeId +
                ", petAdopterId=" + petAdopterId +
                '}';
    }
}
