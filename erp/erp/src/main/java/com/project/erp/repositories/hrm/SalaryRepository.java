package com.project.erp.repositories.hrm;

import com.project.erp.entities.hrm.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
