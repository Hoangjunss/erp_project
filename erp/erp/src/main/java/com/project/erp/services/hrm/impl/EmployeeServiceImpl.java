package com.project.erp.services.hrm.impl;

import com.project.erp.dto.hrm.departments.DepartmentDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeCreateDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeUpdateDTO;
import com.project.erp.entities.hrm.Employees;
import com.project.erp.mapper.hrm.DepartmentMapper;
import com.project.erp.mapper.hrm.EmployeeMapper;
import com.project.erp.repositories.hrm.EmployeeRepository;
import com.project.erp.services.hrm.DepartmentService;
import com.project.erp.services.hrm.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final DepartmentService departmentService;
    private final EmployeeRepository employeeRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeMapper employeeMapper,
                               DepartmentService departmentService,
                               DepartmentMapper departmentMapper) {
        this.employeeMapper = employeeMapper;
        this.departmentService = departmentService;
        this.employeeRepository = employeeRepository;
        this.departmentMapper = departmentMapper;
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

    @Transactional(readOnly = true)
    @Override
    public Boolean checkExists(Integer employeeId) {
        return employeeRepository.findById(employeeId).isPresent();
    }

    @Transactional
    @Override
    public EmployeeDTO create(EmployeeCreateDTO employeeCreateDTO) {
        DepartmentDTO departmentDTO = departmentService.getById(employeeCreateDTO.getDepartmentId());
        Employees employee = employeeMapper.employeeCreateToEmployee(employeeCreateDTO, departmentDTO);
        employee.setId(getGenerationId());
        return employeeMapper.toEmployeeDTO(employeeRepository.save(employee));
    }


    @Transactional
    @Override
    public EmployeeDTO update(EmployeeUpdateDTO employeeUpdateDTO) {
        Employees employees = employeeMapper.toEntity(getById(employeeUpdateDTO.getId()));
        if (employeeUpdateDTO.getFirstName() != null) employees.setFirstName(employeeUpdateDTO.getFirstName());
        if (employeeUpdateDTO.getLastName()!= null) employees.setLastName(employeeUpdateDTO.getLastName());
        if (employeeUpdateDTO.getDepartmentId()!= null) {
            DepartmentDTO departmentDTO = departmentService.getById(employeeUpdateDTO.getDepartmentId());
            employees.setDepartment(departmentMapper.toDepartment(
                    departmentService.getById(employeeUpdateDTO.getDepartmentId())
            ));
        }
        if(employeeUpdateDTO.getEmail() != null) employees.setEmail(employeeUpdateDTO.getEmail());
        if(employeeUpdateDTO.getPhone()!= null) employees.setPhone(employeeUpdateDTO.getPhone());
        if(employeeUpdateDTO.getGender() != null) employees.setGender(employeeUpdateDTO.getGender());
        if(employeeUpdateDTO.getDateOfBirth() != null) employees.setDateOfBirth(employeeUpdateDTO.getDateOfBirth());
        if((employeeUpdateDTO.getCitizenIdentificationCard()) != null) employees.setCitizenIdentificationCard(employees.getCitizenIdentificationCard());
        if(employeeUpdateDTO.getAddress() != null) employees.setAddress(employeeUpdateDTO.getAddress());

        return employeeMapper.toEmployeeDTO(employeeRepository.save(employees));
    }

    @Transactional
    @Override
    public void delete(Integer employeeId){
        if(checkExists(employeeId)) employeeRepository.deleteById(employeeId);
        else throw new RuntimeException("Employee not found");
    }

    private Integer getGenerationId(){
        UUID uuid = UUID.randomUUID();
        return (int) (uuid.getMostSignificantBits() & 0xFFFFFFFFL);
    }
}
