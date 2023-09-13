package com.oad.pawsavers.employee;

import com.oad.pawsavers.user.UserDTO;

public class EmployeeDTO {

    private Long employeeId;
    private String employeeHireDate;
    private UserDTO userDTO;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeHireDate=" + employeeHireDate +
                ", userDTO=" + userDTO +
                '}';
    }
}
