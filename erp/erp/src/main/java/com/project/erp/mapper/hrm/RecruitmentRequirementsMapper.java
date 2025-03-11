package com.project.erp.mapper.hrm;

import com.project.erp.dto.hrm.departments.ApplyDTO;
import com.project.erp.dto.hrm.departments.RecruitmentDTO;
import com.project.erp.dto.hrm.departments.RecruitmentRequirementsDTO;
import com.project.erp.entities.hrm.Apply;
import com.project.erp.entities.hrm.Recruitment;
import com.project.erp.entities.hrm.RecruitmentRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecruitmentRequirementsMapper {
    private final DepartmentMapper departmentMapper;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public RecruitmentRequirementsMapper(DepartmentMapper departmentMapper, EmployeeMapper employeeMapper) {
        this.departmentMapper = departmentMapper;
        this.employeeMapper = employeeMapper;
    }

    public RecruitmentRequirementsDTO toRecruitmentRequirementsDTO(RecruitmentRequirements recruitmentRequirements){
        RecruitmentRequirementsDTO recruitmentRequirementsDTO = new RecruitmentRequirementsDTO();
        recruitmentRequirementsDTO.setId(recruitmentRequirements.getId());
        recruitmentRequirementsDTO.setDateRequired(recruitmentRequirements.getDateRequired());
        recruitmentRequirementsDTO.setDescription(recruitmentRequirements.getDescription());
        recruitmentRequirementsDTO.setExpectedSalary(recruitmentRequirements.getExpectedSalary());
        recruitmentRequirementsDTO.setPositions(recruitmentRequirements.getPositions());
        recruitmentRequirementsDTO.setQuantity(recruitmentRequirements.getQuantity());
        recruitmentRequirementsDTO.setStatus(recruitmentRequirements.getStatus());
        recruitmentRequirementsDTO.setDepartmentDTO(departmentMapper.toDepartmentDTO(recruitmentRequirements.getDepartments()));
        recruitmentRequirementsDTO.setEmployeeDTO(employeeMapper.toEmployeeDTO(recruitmentRequirements.getEmployees()));
        return recruitmentRequirementsDTO;
    }

    public RecruitmentDTO toRecruitmentDTO(Recruitment recruitment){
        RecruitmentDTO recruitmentDTO = new RecruitmentDTO();
        recruitmentDTO.setId(recruitment.getId());
        recruitmentDTO.setEmail(recruitment.getEmail());
        recruitmentDTO.setDeadline(recruitment.getDeadline());
        recruitmentDTO.setPosition(recruitment.getPosition());
        recruitmentDTO.setCreateAt(recruitmentDTO.getCreateAt());
        recruitmentDTO.setJobDescription(recruitmentDTO.getJobDescription());
        recruitmentDTO.setRecruitmentRequirementsDTO(toRecruitmentRequirementsDTO(recruitment.getRecruitmentRequirements()));
        return recruitmentDTO;
    }


}
