package com.example.openfeign.controller;

import com.example.openfeign.model.EmpRequest;
import com.example.openfeign.model.Employee;
import com.example.openfeign.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmpController {

    private final EmpService empService;

    @GetMapping("/{id}")
    Employee getUserById(@PathVariable("id") Integer id){
        return empService.getEmpById(id);
    }

    @PostMapping
    Employee createEmp(@RequestBody EmpRequest empRequest){
        return empService.createEmp(empRequest);
    }

    @DeleteMapping("/{id}")
    void deleteEmpById(@PathVariable("id") Integer id){
        empService.deleteEmpById(id);
    }

}
