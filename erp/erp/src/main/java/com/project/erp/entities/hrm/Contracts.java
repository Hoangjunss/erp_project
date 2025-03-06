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
public class Contracts {
    @Id
    private Integer id;
    private String title;
    private LocalDateTime contractSigningDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double baseSalary;
    private String description;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;

}
