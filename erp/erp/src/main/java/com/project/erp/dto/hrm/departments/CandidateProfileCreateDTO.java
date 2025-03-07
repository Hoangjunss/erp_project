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
public class CandidateProfileCreateDTO {
    private String name;
    private String email;
    private String phone;
    private String linkCV;
    private String skills;
    private String experience;
    private LocalDateTime createProfileAt;
}
