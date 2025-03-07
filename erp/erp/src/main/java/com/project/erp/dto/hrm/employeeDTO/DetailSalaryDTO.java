package com.project.erp.dto.hrm.employeeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailSalaryDTO {
    private Integer id;
    private Double basicSalary;
}
