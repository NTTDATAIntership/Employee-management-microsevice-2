package com.chaimaa.Employeemanagementmicroservice.controllers;


import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTO;
import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTOCreation;
import com.chaimaa.Employeemanagementmicroservice.mappers.EmployeeMapper;
import com.chaimaa.Employeemanagementmicroservice.models.Employee;
import com.chaimaa.Employeemanagementmicroservice.repositories.EmployeeRepository;
import com.chaimaa.Employeemanagementmicroservice.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    private  EmployeeService employeeService;

    private  EmployeeRepository employeeRepository;

    private  EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDTO);
    }
    @GetMapping("/exists/{id}")
    public boolean checkIfEmployeeExists(@PathVariable Long id) {
        return employeeService.existsById(id);
    }
    @GetMapping("/employees/searchByLastName/{lastname}")
    public List<EmployeeDTO> searchEmployeesByLastName(@PathVariable String lastname) {
        return employeeService.searchEmployeesByLastName(lastname);
    }
    @PostMapping("/add")

    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTOCreation employeeDTOCreation) {
        return employeeService.createEmployee(employeeDTOCreation);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO updatedEmployeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, updatedEmployeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }
    //    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee with ID  has been deleted");
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee with ID  has been deleted");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/searchByDepartment/{departmentId}")
    public ResponseEntity<List<Employee>> searchEmployeesByDepartment(@PathVariable Long departmentId) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }
}
