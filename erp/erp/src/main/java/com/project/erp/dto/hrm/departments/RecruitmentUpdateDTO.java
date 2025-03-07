package com.project.erp.dto.hrm.departments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentUpdateDTO {
    private Integer id;
    private String position;
    private String contactPhone;
    private String email;
    private LocalDateTime deadline;
    private String jobDescription;
    private LocalDateTime createAt;
    private Integer recruitmentRequirementId;
}
