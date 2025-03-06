package com.project.erp.entities.hrm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecruitmentRequirements {
    @Id
    private Integer id;
    private String description;
    private String positions;
    private Integer quantity;
    private String expectedSalary;
    private String status;
    private LocalDateTime dateRequired;

    @ManyToOne
    @JoinColumn
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "on_upload")
    private Employees employees;
}
