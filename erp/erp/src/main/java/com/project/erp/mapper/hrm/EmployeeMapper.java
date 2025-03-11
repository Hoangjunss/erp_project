package com.project.erp.mapper.hrm;

import com.project.erp.dto.hrm.departments.*;
import com.project.erp.dto.hrm.employeeDTO.ContactDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeCreateDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.entities.hrm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    private final DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }

    // TODO: convert entities to dto

    public EmployeeDTO toEmployeeDTO(Employees employees){
        return EmployeeDTO.builder()
                .id(employees.getId())
                .firstName(employees.getFirstName())
                .lastName(employees.getLastName())
                .email(employees.getEmail())
                .phone(employees.getPhone())
                .gender(employees.getGender())
                .dateOfBirth(employees.getDateOfBirth())
                 .citizenIdentificationCard(employees.getCitizenIdentificationCard())
                 .address(employees.getAddress())
                 .departmentDTO(departmentMapper.toDepartmentDTO(employees.getDepartment()))
                .build();
    }

    public ContactDTO toContactDTO(Contracts contracts){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contracts.getId());
        contactDTO.setDescription(contracts.getDescription());
        contactDTO.setBaseSalary(contracts.getBaseSalary());
        contactDTO.setTitle(contracts.getTitle());
        contactDTO.setContractSigningDate(contracts.getContractSigningDate());
        contactDTO.setStartDate(contracts.getStartDate());
        contactDTO.setEndDate(contracts.getEndDate());
        contactDTO.setEmployeeDTO(toEmployeeDTO(contracts.getEmployee()));
        return contactDTO;
    }

    public List<EmployeeDTO> toEmployeeDTOList(List<Employees> employees){
        return employees.stream().map(this::toEmployeeDTO).collect(Collectors.toList());
    }

    public Employees employeeCreateToEmployee(EmployeeCreateDTO employeeCreateDTO, DepartmentDTO departmentDTO){
        return Employees.builder()
                .firstName(employeeCreateDTO.getFirstName())
                .lastName(employeeCreateDTO.getLastName())
                .email(employeeCreateDTO.getEmail())
                .phone(employeeCreateDTO.getPhone())
                 .gender(employeeCreateDTO.getGender())
                 .dateOfBirth(employeeCreateDTO.getDateOfBirth())
                 .citizenIdentificationCard(employeeCreateDTO.getCitizenIdentificationCard())
                 .address(employeeCreateDTO.getAddress())
                 .department(departmentMapper.toDepartment(departmentDTO))
                .build();
    }


}
