package com.project.erp.mapper.hrm;

import com.project.erp.dto.hrm.departments.*;
import com.project.erp.dto.hrm.employeeDTO.ContactDTO;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.entities.hrm.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    // TODO: convert entities to dto

    public EmployeeDTO toEmployeeDTO(Employees employees){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employees.getId());
        employeeDTO.setFirstName(employees.getFirstName());
        employeeDTO.setLastName(employees.getLastName());
        employeeDTO.setEmail(employees.getEmail());
        employeeDTO.setPhone(employees.getPhone());
        employeeDTO.setGender(employees.getGender());
        employeeDTO.setDateOfBirth(employees.getDateOfBirth());
        employeeDTO.setCitizenIdentificationCard(employees.getCitizenIdentificationCard());
        employeeDTO.setAddress(employees.getAddress());
        employeeDTO.setDepartmentDTO(toDepartmentDTO(employees.getDepartment()));
        return employeeDTO;
    }

    public DepartmentDTO toDepartmentDTO(Departments departments){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(departments.getId());
        departmentDTO.setAddress(departments.getAddress());
        departmentDTO.setPhone(departments.getPhone());
        departmentDTO.setDepartmentName(departments.getDepartmentName());
        departmentDTO.setEmail(departments.getEmail());
        departmentDTO.setDescription(departments.getDescription());
        return departmentDTO;
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
        recruitmentRequirementsDTO.setDepartmentDTO(toDepartmentDTO(recruitmentRequirements.getDepartments()));
        recruitmentRequirementsDTO.setEmployeeDTO(toEmployeeDTO(recruitmentRequirements.getEmployees()));
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

    public ApplyDTO toApplyDTO(Apply apply){
        ApplyDTO applyDTO = new ApplyDTO();
        applyDTO.setId(apply.getId());
        applyDTO.setApplyAt(apply.getApplyAt());
        applyDTO.setStatus(apply.getStatus());
        applyDTO.setPosition(apply.getPosition());
        applyDTO.setCandidateProfileDTO(toCandidateProfileDTO(apply.getCandidateProfile()));
        return applyDTO;
    }

    public CandidateProfileDTO toCandidateProfileDTO(CandidateProfile candidateProfile){
        CandidateProfileDTO candidateProfileDTO = new CandidateProfileDTO();
        candidateProfileDTO.setId(candidateProfile.getId());
        candidateProfileDTO.setCreateProfileAt(candidateProfile.getCreateProfileAt());
        candidateProfileDTO.setEmail(candidateProfile.getEmail());
        candidateProfileDTO.setPhone(candidateProfile.getPhone());
        candidateProfileDTO.setExperience(candidateProfile.getExperience());
        candidateProfileDTO.setName(candidateProfile.getName());
        candidateProfileDTO.setLinkCV(candidateProfile.getLinkCV());
        candidateProfileDTO.setSkills(candidateProfile.getSkills());

        return candidateProfileDTO;
    }

    public EvaluateDTO toEvaluateDTO(Evaluate evaluate){
        EvaluateDTO evaluateDTO = new EvaluateDTO();
        evaluateDTO.setId(evaluate.getId());
        evaluateDTO.setEvaluate(evaluate.getEvaluate());
        evaluateDTO.setFeedback(evaluate.getFeedback());
        evaluateDTO.setSuggest(evaluateDTO.getSuggest());
        evaluateDTO.setFeedbackAt(evaluate.getFeedbackAt());
        return evaluateDTO;
    }

    public ContactDTO toContactDTO(Contracts contracts){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contracts.getId());
        contactDTO.setDescription(contracts.getDescription());
        contactDTO.setBaseSalary(contracts.getBaseSalary());
        contactDTO.setTitle(contracts.getTitle());
        contactDTO.setContractSigningDate(contracts.getContractSigningDate());
        contactDTO.setStartDate(contracts.getStartDate());
        contactDTO.setEndDate(contracts.getEndDate());
        return contactDTO;
    }

    public List<EmployeeDTO> toEmployeeDTOList(List<Employees> employees){
        return employees.stream().map(this::toEmployeeDTO).collect(Collectors.toList());
    }


}
