package com.chaimaa.Employeemanagementmicroservice.services;

import com.chaimaa.Employeemanagementmicroservice.models.Department;
import com.chaimaa.Employeemanagementmicroservice.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
