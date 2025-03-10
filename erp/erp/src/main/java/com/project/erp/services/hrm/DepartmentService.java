package com.project.erp.services.hrm;

import com.project.erp.dto.hrm.departments.DepartmentDTO;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    DepartmentDTO getById(Integer id);
}
