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
public class Apply {
    @Id
    private Integer id;
    private LocalDateTime applyAt;
    private String status;
    private String position;

    @ManyToOne
    @JoinColumn
    private Recruitment recruitment;

    @ManyToOne
    @JoinColumn
    private CandidateProfile candidateProfile;

}
