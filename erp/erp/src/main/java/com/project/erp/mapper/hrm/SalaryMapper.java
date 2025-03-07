package com.project.erp.mapper.hrm;

import com.project.erp.dto.hrm.employeeDTO.DetailSalaryDTO;
import com.project.erp.dto.hrm.employeeDTO.SalaryDTO;
import com.project.erp.dto.hrm.employeeDTO.SubsidyDTO;
import com.project.erp.entities.hrm.DetailSalary;
import com.project.erp.entities.hrm.Salary;
import com.project.erp.entities.hrm.Subsidy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryMapper {

    // TODO: convert entities to dto

    public SalaryDTO toSalaryDTO(Salary salary, DetailSalary detailSalary, List<Subsidy> subsidyList){
        SalaryDTO dto = new SalaryDTO();
        dto.setId(salary.getId());
        dto.setTime(salary.getTime());
        dto.setTotalAmount(salary.getTotalAmount());
        dto.setDetailSalaryDTO(toDetailSalaryDTO(detailSalary));
        if(subsidyList != null){
            dto.setSubsidyDTOList(subsidyList
                    .stream()
                    .map(this::toSubsidyDTO)
                    .collect(java.util.stream.Collectors.toList()));
        }
        return dto;
    }

    public DetailSalaryDTO toDetailSalaryDTO(DetailSalary detailSalary){
        DetailSalaryDTO dto = new DetailSalaryDTO();
        dto.setId(detailSalary.getId());
        dto.setBasicSalary(detailSalary.getBasicSalary());
        return dto;
    }

    public SubsidyDTO toSubsidyDTO(Subsidy subtitle){
        SubsidyDTO dto = new SubsidyDTO();
        dto.setId(subtitle.getId());
        dto.setTypeSubsidy(subtitle.getTypeSubsidy());
        dto.setAmount(subtitle.getAmount());
        return dto;
    }

    // TODO: convert dto to entities

    public Subsidy toSubsidy(SubsidyDTO subsidyDTO){
        Subsidy subtitle = new Subsidy();
        subtitle.setId(subsidyDTO.getId());
        subtitle.setTypeSubsidy(subsidyDTO.getTypeSubsidy());
        subtitle.setAmount(subsidyDTO.getAmount());
        return subtitle;
    }

    public DetailSalary toDetailSalary(DetailSalaryDTO detailSalaryDTO){
        DetailSalary detailSalary = new DetailSalary();
        detailSalary.setId(detailSalaryDTO.getId());
        detailSalary.setBasicSalary(detailSalaryDTO.getBasicSalary());
        return detailSalary;
    }

    public Salary toSalary(SalaryDTO salaryDTO){
        Salary salary = new Salary();
        salary.setId(salaryDTO.getId());
        salary.setTime(salaryDTO.getTime());
        salary.setTotalAmount(salaryDTO.getTotalAmount());
        return salary;
    }
}
