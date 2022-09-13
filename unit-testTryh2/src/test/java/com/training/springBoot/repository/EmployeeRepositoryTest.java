package com.training.springBoot.repository;

import com.training.springBoot.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository empR;

    @Test
    public void testFindAll() {
        List<Employee> emps = empR.findAll();
        assertEquals(5,emps.size());
    }

    @Test
    public void testFindOne() {
        Employee emp = empR.findById(1).get();
        assertEquals("Jerry",emp.getName());
    }

}
