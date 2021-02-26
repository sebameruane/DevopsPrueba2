package com.nubox.core.demo.domain.repository;

import com.nubox.core.demo.domain.model.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeRepository  {

    @Select("INSERT INTO employee ( firstName,lastName ) VALUES ( #{xEmployee.firstName}, #{xEmployee.lastName}) RETURNING *")
    Employee insertEmployee(@Param("xEmployee") Employee xEmployee);

    @Select("SELECT id, firstName, lastName  FROM employee WHERE id = #{xID}")
    Employee findById(@Param("xID") Long xID);

    @Select("SELECT id, firstName, lastName FROM employee")
    List<Employee> findAll();

}
