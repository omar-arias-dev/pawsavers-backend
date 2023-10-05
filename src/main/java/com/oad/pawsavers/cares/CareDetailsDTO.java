package com.oad.pawsavers.cares;

import com.oad.pawsavers.caretype.CareTypeDTO;
import com.oad.pawsavers.employee.EmployeeDTO;
import com.oad.pawsavers.pet.PetDTO;

public class CareDetailsDTO {

    private Long careId;
    private PetDTO petDTO;
    private CareTypeDTO careTypeDTO;
    private EmployeeDTO employeeDTO;
    private String careDateTimeStart;
    private String careDateTimeEnd;

    public Long getCareId() {
        return careId;
    }

    public void setCareId(Long careId) {
        this.careId = careId;
    }

    public PetDTO getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    public CareTypeDTO getCareTypeDTO() {
        return careTypeDTO;
    }

    public void setCareTypeDTO(CareTypeDTO careTypeDTO) {
        this.careTypeDTO = careTypeDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public String getCareDateTimeStart() {
        return careDateTimeStart;
    }

    public void setCareDateTimeStart(String careDateTimeStart) {
        this.careDateTimeStart = careDateTimeStart;
    }

    public String getCareDateTimeEnd() {
        return careDateTimeEnd;
    }

    public void setCareDateTimeEnd(String careDateTimeEnd) {
        this.careDateTimeEnd = careDateTimeEnd;
    }
}
