package com.example.openfeign.service;

import com.example.openfeign.client.EmpFeignClient;
import com.example.openfeign.model.EmpRequest;
import com.example.openfeign.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpService {

    private final EmpFeignClient empFeignClient;

    public Employee getEmpById(Integer id) {
        return empFeignClient.getEmpById(id).getEmp();
    }

    public Employee createEmp(EmpRequest empRequest){
        return empFeignClient.createEmp(empRequest);
    }

    public void deleteEmpById(Integer id){
        empFeignClient.deleteEmpById(id);
    }

}
