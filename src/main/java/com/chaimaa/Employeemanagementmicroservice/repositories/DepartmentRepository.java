package com.chaimaa.Employeemanagementmicroservice.repositories;

import com.chaimaa.Employeemanagementmicroservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
    Optional<Department> findById(Long id);
}
