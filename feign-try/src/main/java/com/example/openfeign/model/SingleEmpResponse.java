package com.example.openfeign.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SingleEmpResponse {

    @JsonProperty("data")
    Employee emp ;
}
