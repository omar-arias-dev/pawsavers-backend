package com.oad.pawsavers.user;

import com.oad.pawsavers.common.constants.Gender;
import com.oad.pawsavers.employee.Employee;
import com.oad.pawsavers.petRescuer.PetRescuer;
import com.oad.pawsavers.usertype.UserType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String lastname;

    @Column(name = "second_lastname", length = 20, nullable = false)
    private String secondLastname;

    @Column(length = 18)
    private String curp;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "cellphone_number", length = 10, nullable = false)
    private String cellphoneNumber;

    @Column(name = "house_number", length = 10, nullable = false)
    private String houseNumber;

    @Column(name = "postal_code", length = 6, nullable = false)
    private String postalCode;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(length = 20)
    private String occupation;

    @ManyToOne
    @JoinColumn(name = "user_type_id", foreignKey = @ForeignKey(name = "user_type_fk"), nullable = false)
    private UserType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PetRescuer> petRescuerList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<PetRescuer> getPetRescuerList() {
        return petRescuerList;
    }

    public void setPetRescuerList(List<PetRescuer> petRescuerList) {
        this.petRescuerList = petRescuerList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", secondLastname='" + secondLastname + '\'' +
                ", curp='" + curp + '\'' +
                ", gender=" + gender +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", registrationDate=" + registrationDate +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
