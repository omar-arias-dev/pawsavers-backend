package com.oad.pawsavers.usertype;

public class UserTypeDTO {

    private Long userTypeId;
    private String typeOfUser;

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    @Override
    public String toString() {
        return "UserTypeDTO{" +
                "userTypeId=" + userTypeId +
                ", typeOfUser='" + typeOfUser + '\'' +
                '}';
    }
}
