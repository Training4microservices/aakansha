package com.training.springBoot.model;

//import jdk.jshell.Snippet;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")
//@Document(collection ="EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    //@Size(min=4, message="Name should have atleast 4 characters")
    String name;
    Double salary;



    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }


}
