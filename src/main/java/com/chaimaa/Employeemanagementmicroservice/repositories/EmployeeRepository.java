package com.chaimaa.Employeemanagementmicroservice.repositories;

import com.chaimaa.Employeemanagementmicroservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {



    Optional<Employee> findByEmail(String email);
    //    List<Employee> findByDepartment(Department department);
    List<Employee> findByJobTitle(String jobTitle);

    List<Employee> findByLastname(String lastname);


    List<Employee> findByDepartmentId(Long departmentId);

    boolean existsByEmail(String email);
}
