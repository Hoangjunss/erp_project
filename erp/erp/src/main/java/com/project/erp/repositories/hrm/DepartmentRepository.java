package com.project.erp.repositories.hrm;

import com.project.erp.entities.hrm.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
}
