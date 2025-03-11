package com.project.erp.controllers.hrm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.erp.dto.APIResponse;
import com.project.erp.dto.hrm.employeeDTO.EmployeeDTO;
import com.project.erp.services.hrm.EmployeeService;

@RestController
@RequestMapping("/hrm/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    private EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<EmployeeDTO>>> getAllEmployee() {
        List<EmployeeDTO> employees = employeeService.getAll();
        APIResponse<List<EmployeeDTO>> apiResponse = new APIResponse<>(
                true,
                "Get all is successful",
                employees);
        return ResponseEntity.ok(apiResponse);
    }

}
