package com.project.erp.dto.hrm.departments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequirementsUpdateDTO {
    private Integer id;
    private String description;
    private String positions;
    private Integer quantity;
    private String expectedSalary;
    private String status;
    private LocalDateTime dateRequired;
    private Integer departmentId;
    private Integer createdBy;
}
