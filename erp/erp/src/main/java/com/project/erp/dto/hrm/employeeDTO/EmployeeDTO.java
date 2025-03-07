package com.project.erp.dto.hrm.employeeDTO;

import com.project.erp.dto.hrm.departments.DepartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String position;
    private String image;
    private String citizenIdentificationCard;
    private String status;
    private DepartmentDTO departmentDTO;
}
