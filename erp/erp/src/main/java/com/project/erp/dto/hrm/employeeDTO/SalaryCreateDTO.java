package com.project.erp.dto.hrm.employeeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryCreateDTO {
    private LocalDateTime time;
    private Double totalAmount;
    private Integer employeeId;
}
