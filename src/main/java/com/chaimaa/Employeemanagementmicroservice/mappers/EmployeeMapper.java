package com.chaimaa.Employeemanagementmicroservice.mappers;


import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTO;
import com.chaimaa.Employeemanagementmicroservice.dtos.EmployeeDTOCreation;
import com.chaimaa.Employeemanagementmicroservice.models.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface EmployeeMapper {
    Employee employeeDTOCreationToEmployee(EmployeeDTOCreation employeeDTOCreation);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

}
