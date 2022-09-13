package com.example.openfeign.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    Integer id;
    String name;
    Double salary;

}
