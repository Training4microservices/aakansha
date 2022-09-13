package com.training.springBoot.controller;

import com.training.springBoot.model.Employee;
import com.training.springBoot.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getAllEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(
                Arrays.asList(new Employee(1,"Jerry",50000.0),
                        new Employee(2,"Harry",25000.0))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/employees")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:Harry,salary:25000.0}, {id:1,name:Jerry,salary:50000.0}]"))
                .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }


}
