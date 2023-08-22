package com.chaimaa.Employeemanagementmicroservice.services;

//
import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTO;
import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTOCreation;
import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTO;
import com.chaimaa.Employeemanagementmicroservice.exceptions.EmailAlreadyExistsException;
import com.chaimaa.Employeemanagementmicroservice.mappers.EmployeeMapper;
import com.chaimaa.Employeemanagementmicroservice.models.Department;
import com.chaimaa.Employeemanagementmicroservice.models.Employee;
import com.chaimaa.Employeemanagementmicroservice.repositories.DepartmentRepository;
import com.chaimaa.Employeemanagementmicroservice.repositories.EmployeeRepository;
import com.chaimaa.Employeemanagementmicroservice.services.EmployeeService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {



    private  final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private  final EmployeeMapper employeeMapper;


    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper,DepartmentRepository departmentRepository ) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository=departmentRepository;
    }




    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        return employeeMapper.employeeToEmployeeDTO(employee);
    }
    public List<EmployeeDTO> searchEmployeesByLastName(String lastName) {
        List<Employee> employees = employeeRepository.findByLastname(lastName);
        return employees.stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }
    public EmployeeDTO createEmployee(EmployeeDTOCreation employeeDTOCreation) {
        Department department = departmentRepository.findByName(employeeDTOCreation.getDepartmentName())
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + employeeDTOCreation.getDepartmentName()));

        if (employeeRepository.existsByEmail(employeeDTOCreation.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employeeDTOCreation.getEmail());
        }
//        Department department = departmentRepository.findByName(employeeDTOCreation.getDepartmentName())
//                .orElseThrow(() -> new EntityNotFoundException("Department not found with name: " + employeeDTOCreation.getDepartmentName()));

        Employee employee = employeeMapper.employeeDTOCreationToEmployee(employeeDTOCreation);
        employee.setDepartment(department);
//        employee.setDepartment(department);
//        Department department = departmentRepository.findByName(employeeDTOCreation.getDepartmentName())
//                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + employeeDTOCreation.getDepartmentName()));
//        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);

        savedEmployee.setFirstname(employeeDTOCreation.getFirstname());
//        savedEmployee.setDepartment(department);
        savedEmployee.setLastname(employeeDTOCreation.getLastname());
        savedEmployee.setJobTitle(employeeDTOCreation.getJobTitle());
        savedEmployee.setEmail(employeeDTOCreation.getEmail());
        savedEmployee.setDateOfJoining(employeeDTOCreation.getDateOfJoining());
        savedEmployee.setPhoneNumber(employeeDTOCreation.getPhoneNumber());
//       EmployeeDTOCreation employeeDTO = employeeMapper.employeeToEmployeeDTOCreation(savedEmployee);
//        return employeeMapper.employeeDTOCreationToEmployeeDTO(employeeDTO);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }


    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        // Update the fields from updatedEmployeeDTO to existingEmployee
        existingEmployee.setFirstname(updatedEmployeeDTO.getFirstname());
        existingEmployee.setLastname(updatedEmployeeDTO.getLastname());
        existingEmployee.setEmail(updatedEmployeeDTO.getEmail());
        existingEmployee.setPhoneNumber(updatedEmployeeDTO.getPhoneNumber());
        existingEmployee.setLastname(updatedEmployeeDTO.getLastname());
        existingEmployee.setJobTitle(updatedEmployeeDTO.getJobTitle());
        existingEmployee.setDateOfJoining(updatedEmployeeDTO.getDateOfJoining());

        // Update other fields as needed

        // Save the updated employee
        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return employeeMapper.employeeToEmployeeDTO(updatedEmployee);
    }
    public void deleteEmployee(Long id) {
        Employee employeeToDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        employeeRepository.delete(employeeToDelete);
    }


    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
//    private Department getDepartmentByName(String departmentName) {
//        return departmentRepository.findByName(departmentName)
//                .orElseThrow(() -> new EntityNotFoundException("Department not found with name: " + departmentName));
//    }
//
}
