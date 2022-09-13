package com.training.springBoot.services;


import com.training.springBoot.model.Employee;
import com.training.springBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    Employee em;

    public List getAllEmployees() {
        List employees = new ArrayList();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }
/*
    public Integer noOfEmployees(){
        List employees = new ArrayList();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        Integer count = employees.size();
        return count;
    }

 */

    public Double avgSalary(){
        int noOfEmp = (int) employeeRepository.count();
        System.out.println(noOfEmp);
        double total = employeeRepository.findAll().stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(total);
        return total/noOfEmp;
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(String name, Integer id) {
        Optional<Employee> originalEmployee = employeeRepository.findById(id);
        Employee employee = originalEmployee.get();
        employee.setName(name);
        return employeeRepository.save(employee);
    }


}
