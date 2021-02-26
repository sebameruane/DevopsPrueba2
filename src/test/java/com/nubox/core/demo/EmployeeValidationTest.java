package com.nubox.core.demo;

import com.nubox.core.demo.domain.model.entity.Employee;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class EmployeeValidationTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidationEmployee() {
        // Test validador de Rut
        // RutValidator
        String rut ="46.666.666-1";
        Set<ConstraintViolation<Employee>> violations = validator.validate(new Employee(1L,"Victor", "Carcamo",new Date(),-1,100,"victor.carcamo@nubox.com",rut));
        Assertions.assertTrue(violations.isEmpty());




    }
}
