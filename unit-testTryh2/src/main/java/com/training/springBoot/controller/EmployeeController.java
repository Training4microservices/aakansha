package com.training.springBoot.controller;

import com.training.springBoot.exception.InsufficientSalaryException;
//import com.training.springBoot.exception.Student;
//import com.training.springBoot.exception.StudentNotFoundException;
import com.training.springBoot.model.Employee;
import com.training.springBoot.repository.EmployeeRepository;
import com.training.springBoot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    private List getAllEmployees() {
        Double avgSalary = 0.0;

        return employeeService.getAllEmployees();
    }
/*

    @GetMapping("/employees/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }
    */



    @PostMapping("/employees")
    private ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        try{
            employeeService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New employee created with id: "+employee.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    private ResponseEntity deleteById(@PathVariable("id") int id) {
        try{
            employeeService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: "+id, HttpStatus.OK);
    }

    @PutMapping("/employees")
    private ResponseEntity updateEmployee(@RequestBody Employee employee) {
        try{
            employeeService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(" employee updated with id: "+employee.getId(), HttpStatus.OK);
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployeeByPatch(@RequestParam("name") String name, @PathVariable("id") Integer id){
        Employee employee = employeeService.updateEmployee(name,id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


    @GetMapping("/employees/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id) {
        if(employeeService.getEmployeeById(id).getSalary()< employeeService.avgSalary()) {
            throw new InsufficientSalaryException("Insufficient Salary for Id -" + id);
        }
        else{
            return employeeService.getEmployeeById(id);
        }
    }


}