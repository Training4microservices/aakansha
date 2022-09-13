package com.example.openfeign.client;


import com.example.openfeign.model.EmpRequest;
import com.example.openfeign.model.Employee;
import com.example.openfeign.model.SingleEmpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "userFeignClient",
        url = "${client.api.baseUrl}")
public interface EmpFeignClient {

    @GetMapping("/api/emps/{id}")
    SingleEmpResponse getEmpById(@PathVariable("id") Integer id);

    @PostMapping("/api/emps")
    Employee createEmp(@RequestBody EmpRequest empRequest);

    @DeleteMapping("/api/emp/{id}")
    void deleteEmpById(@PathVariable("id") Integer id);

}
