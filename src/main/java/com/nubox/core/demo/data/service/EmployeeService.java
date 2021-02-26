package com.nubox.core.demo.data.service;

import java.util.List;


import com.nubox.core.demo.domain.model.entity.Employee;


public interface EmployeeService{

    Employee findOneById(Long xID);
    List<Employee> findAll();
    Employee create(Employee xEmployee);
    
}
