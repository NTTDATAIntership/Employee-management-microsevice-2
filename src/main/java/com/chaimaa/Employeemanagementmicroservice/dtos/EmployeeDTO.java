package com.chaimaa.Employeemanagementmicroservice.dtos;

import com.chaimaa.Employeemanagementmicroservice.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor

public class EmployeeDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private Date dateOfJoining;
    private String departmentName;



    //    public EmployeeDTO(Employee employee) {
//        this.id = employee.getId();
//        this.firstname = employee.getFirstname();
//        this.lastname = employee.getLastname();
//        this.email = employee.getEmail();
//        this.departmentName = employee.getDepartment().getName();
//    }
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.jobTitle = employee.getJobTitle();
        this.dateOfJoining = employee.getDateOfJoining();
        this.departmentName = employee.getDepartment().getName();
    }

    public EmployeeDTO(String firstname, String lastname, String email, String phoneNumber, String jobTitle, Date dateOfJoining, String departmentName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.dateOfJoining = dateOfJoining;
        this.departmentName = departmentName;
    }

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
