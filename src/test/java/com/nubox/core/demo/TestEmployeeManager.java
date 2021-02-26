package com.nubox.core.demo;

import com.nubox.core.demo.data.service.EmployeeService;
import com.nubox.core.demo.data.service.EmployeeServiceImpl;
import com.nubox.core.demo.domain.model.entity.Employee;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TestEmployeeManager {

    @BeforeEach
    public void init() {

    }

    @Test
    void getEmployeeByIdTest() {
        EmployeeService mock = Mockito.mock(EmployeeServiceImpl.class);
        when(mock.findOneById(1L)).thenReturn(new Employee(1L, "500-2","Victor", "Carcamo"));

        Employee emp = mock.findOneById(1L);

        Assertions.assertEquals("Victor", emp.getFirstName());
        Assertions.assertEquals("Carcamo", emp.getLastName());

    }
}
