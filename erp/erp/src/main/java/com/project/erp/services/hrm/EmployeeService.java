package com.project.erp.services.hrm;

import com.project.erp.dto.hrm.employeeDTO.EmployeeCreateDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.repositories.hrm.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDTO> getAll();
    EmployeeDTO getById(Integer id);
    EmployeeDTO create(EmployeeCreateDTO employeeCreateDTO);
}
