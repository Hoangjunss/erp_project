package com.project.erp.entities.hrm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.erp.entities.Enum.StatusEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employees {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String position;
    private String image;
    private String CitizenIdentificationCard;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEmployee status;

    @ManyToOne
    @JoinColumn
    private Departments department;

//    @JsonBackReference
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Contracts> contracts;
}
