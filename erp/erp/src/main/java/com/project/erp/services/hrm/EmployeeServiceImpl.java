package com.project.erp.services.hrm;

import com.project.erp.dto.hrm.employeeDTO.EmployeeCreateDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.entities.hrm.Employees;
import com.project.erp.mapper.hrm.EmployeeMapper;
import com.project.erp.repositories.hrm.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements  EmployeeService{

    private final EmployeeMapper employeeMapper;

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmployeeDTO> getAll() {
        return employeeMapper.toEmployeeDTOList(
                employeeRepository.findAll()
        );
    }

    @Transactional(readOnly = true)
    @Override
    public EmployeeDTO getById(Integer id) {
        return employeeMapper.toEmployeeDTO(
                employeeRepository.findById(id)
                       .orElseThrow(() -> new RuntimeException("Employee not found"))
        );
    }

    @Transactional
    @Override
    public EmployeeDTO create(EmployeeCreateDTO employeeCreateDTO) {
        Employees employee = employeeMapper.employeeCreateToEmployee(employeeCreateDTO);
        return employeeMapper.toEmployeeDTO(employeeRepository.save(employee));
    }
}
