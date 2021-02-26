package com.nubox.core.demo.data.api.controller;


import com.nubox.core.demo.data.common.http.ResponseDTO;
import com.nubox.core.demo.data.service.EmployeeService;
import com.nubox.core.demo.data.service.dto.EmployeeDTO;
import com.nubox.core.demo.data.util.Constant;
import com.nubox.core.demo.domain.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = Constant.PATH_EMPLOYEE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = Constant.PATH_VARIABLE_CREATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<EmployeeDTO> create(@Valid @RequestBody Employee employee) {
        return ResponseDTO.accepted().convertTo(employeeService.create(employee), EmployeeDTO.class);
    }

    @GetMapping(value = Constant.PATH_VARIABLE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findOneById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findOneById(id));
    }

    @GetMapping(path = Constant.PATH_VARIABLE_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }



}
