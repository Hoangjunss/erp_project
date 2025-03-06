package com.project.erp.entities.hrm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subsidy {
    @Id
    private Integer id;
    private String typeSubsidy;
    private Double amount;

    @ManyToOne
    @JoinColumn
    private Salary salary;
}
