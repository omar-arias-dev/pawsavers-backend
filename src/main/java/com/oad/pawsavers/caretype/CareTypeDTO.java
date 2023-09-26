package com.oad.pawsavers.caretype;

public class CareTypeDTO {

    private Long careTypeId;
    private String nameOfCare;

    public Long getCareTypeId() {
        return careTypeId;
    }

    public void setCareTypeId(Long careTypeId) {
        this.careTypeId = careTypeId;
    }

    public String getNameOfCare() {
        return nameOfCare;
    }

    public void setNameOfCare(String nameOfCare) {
        this.nameOfCare = nameOfCare;
    }
}
