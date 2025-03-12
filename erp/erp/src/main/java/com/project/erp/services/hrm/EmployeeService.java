package com.project.erp.services.hrm;

import com.project.erp.dto.hrm.employeeDTO.EmployeeCreateDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDTO> getAll();
    EmployeeDTO getById(Integer id);
    Boolean checkExists(Integer employeeId);
    EmployeeDTO create(EmployeeCreateDTO employeeCreateDTO);
    EmployeeDTO update(EmployeeUpdateDTO employeeUpdateDTO);
    void delete(Integer employeeId);
}
