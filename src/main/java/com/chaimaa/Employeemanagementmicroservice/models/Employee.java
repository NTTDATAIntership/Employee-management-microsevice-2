package com.chaimaa.Employeemanagementmicroservice.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Column(name = "first_name")
    private  String firstname ;

    @Column(name = "last_name")
    private  String lastname ;

//    @NotNull(message = "Email cannot be null")
//    @Email(message = "Invalid email format")
    @NaturalId(mutable = true)
    @Column(name = "email")
    private  String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

//    @Column(name = "birthDate")
//    @NotNull(message = "Birthdate is required")
//    @Past(message = "Birthdate must be in the past")
//    private Date birthDate;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "dateOfJoining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;



    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    public Employee(String firstname, String lastname, String email, String phoneNumber, String jobTitle, Date dateOfJoining, Department department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.dateOfJoining = dateOfJoining;
        this.department = department;
    }

    public Employee() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
