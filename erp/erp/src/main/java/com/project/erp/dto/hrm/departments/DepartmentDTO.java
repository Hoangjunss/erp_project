package com.project.erp.dto.hrm.departments;

import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Integer id;
    private String departmentName;
    private String description;
    private String address;
    private String email;
    private String phone;
    //private List<EmployeeDTO> employeeDTOList;
}
