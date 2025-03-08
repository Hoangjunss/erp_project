package com.project.erp.repositories.hrm;

import com.project.erp.entities.hrm.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contracts, Integer> {
}
