package com.oad.pawsavers.cares;

public class CareDTO {

    private Long careId;
    private Long petId;
    private Long careTypeId;
    private Long employeeId;
    private String careDateTimeStart;
    private String careDateTimeEnd;

    public Long getCareId() {
        return careId;
    }

    public void setCareId(Long careId) {
        this.careId = careId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getCareTypeId() {
        return careTypeId;
    }

    public void setCareTypeId(Long careTypeId) {
        this.careTypeId = careTypeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public String toString() {
        return "CareDTO{" +
                "careId=" + careId +
                ", petId=" + petId +
                ", careTypeId=" + careTypeId +
                ", employeeId=" + employeeId +
                ", careDateTimeStart='" + careDateTimeStart + '\'' +
                ", careDateTimeEnd='" + careDateTimeEnd + '\'' +
                '}';
    }
}
