package com.oad.pawsavers.visits;

import com.oad.pawsavers.employee.EmployeeDTO;
import com.oad.pawsavers.petadopter.PetAdopterDTO;

public class VisitDetailsDTO {

    private Long idOfVisit;
    private String visitNotes;
    private String visitDate;
    private EmployeeDTO employeeDTO;
    private PetAdopterDTO petAdopterDTO;

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

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public PetAdopterDTO getPetAdopterDTO() {
        return petAdopterDTO;
    }

    public void setPetAdopterDTO(PetAdopterDTO petAdopterDTO) {
        this.petAdopterDTO = petAdopterDTO;
    }

    @Override
    public String toString() {
        return "VisitDetailsDTO{" +
                "idOfVisit=" + idOfVisit +
                ", visitNotes='" + visitNotes + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", employeeDTO=" + employeeDTO +
                ", petAdopterDTO=" + petAdopterDTO +
                '}';
    }
}
