
package com.training.springBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControl {
    @GetMapping(value = "/name")
    public String getName() {
        return "Aakanksha";
    }

    @GetMapping(value = "/")
    public String getData(){
        return "Spring Boot testing";
    }

    @GetMapping(value = "/name/{hobby}")
    public String getHobby(@PathVariable("hobby") String hobby){
        return "My hobby is "+hobby;
    }

    @GetMapping(value = "/jerry")
    public String getRecord(){
        return "Hello";
    }
}



