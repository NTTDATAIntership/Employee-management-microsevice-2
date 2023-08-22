package com.chaimaa.Employeemanagementmicroservice.services;

import com.chaimaa.Employeemanagementmicroservice.models.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
}