package com.training.springBoot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.training.springBoot.model.Employee;
import com.training.springBoot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService emp;

    @Mock
    private EmployeeRepository empR;

    @Test
    public void retrieveAllEmps_basic() {
        when(empR.findAll()).thenReturn(Arrays.asList(new Employee(1,"Jerry",50000.0),
                new Employee(2,"Harry",25000.0)));
        List<Employee> items = emp.getAllEmployees();

        assertEquals(1, items.get(0).getId());
        assertEquals(2, items.get(1).getId());
    }

}
