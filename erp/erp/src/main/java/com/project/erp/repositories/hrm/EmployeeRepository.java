package com.project.erp.repositories.hrm;

import com.project.erp.entities.hrm.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
