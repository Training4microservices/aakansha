package com.training.springBoot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InsufficientSalaryException extends RuntimeException{
    public InsufficientSalaryException(String exception) {
        super(exception);
    }
}
