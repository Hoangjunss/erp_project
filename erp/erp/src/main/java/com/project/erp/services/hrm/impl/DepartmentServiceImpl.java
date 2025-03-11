package com.project.erp.services.hrm.impl;

import com.project.erp.dto.hrm.departments.DepartmentDTO;
import com.project.erp.mapper.hrm.DepartmentMapper;
import com.project.erp.mapper.hrm.EmployeeMapper;
import com.project.erp.repositories.hrm.DepartmentRepository;
import com.project.erp.services.hrm.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
            DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDTO getById(Integer id) {
        return departmentMapper.toDepartmentDTO(departmentRepository.findById(id)
                .orElseThrow());
    }
}
