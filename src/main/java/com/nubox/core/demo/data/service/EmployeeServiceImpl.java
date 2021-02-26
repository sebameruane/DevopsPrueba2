package com.nubox.core.demo.data.service;

import com.nubox.core.demo.domain.model.entity.Employee;
import com.nubox.core.demo.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	 EmployeeRepository employeeRepository;


	 /**
     * find employee in object
     *
     * @param xID the employee id
     * @return one employee
     */
    public Employee findOneById(Long xID) {
        return employeeRepository.findById(xID);
    }

    /**
     * find all employees in list
     *
     * @return list employees
     */
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }



    /**
     * create new employee
     *
     * @param xEmployee the person to be create
     * @return created employee
     */
    public Employee create(Employee xEmployee) {
    	
        return employeeRepository.insertEmployee(xEmployee);
    }
    
    
   
    
}
