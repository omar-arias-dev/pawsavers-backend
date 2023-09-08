package com.oad.pawsavers.user;

public class UserDTO {

    private Long userId;
    private String userName;
    private String userLastname;
    private String userSecondLastname;
    private String curp;
    private String userGender;
    private String cellphoneNumber;
    private String houseNumber;
    private String postalCode;
    private String registrationDate;
    private String userOccupation;
    private Long userTypeId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserSecondLastname() {
        return userSecondLastname;
    }

    public void setUserSecondLastname(String userSecondLastname) {
        this.userSecondLastname = userSecondLastname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUserOccupation() {
        return userOccupation;
    }

    public void setUserOccupation(String userOccupation) {
        this.userOccupation = userOccupation;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userSecondLastname='" + userSecondLastname + '\'' +
                ", curp='" + curp + '\'' +
                ", userGender='" + userGender + '\'' +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", userOccupation='" + userOccupation + '\'' +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
