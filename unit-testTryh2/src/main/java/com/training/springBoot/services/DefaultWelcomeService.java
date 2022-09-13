
package com.training.springBoot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultWelcomeService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultWelcomeService.class);
    private String secretKey;

    @Value("${training.welcome.message: Welcome!!!}")
    private String welcomeMsg;

    @Value("${training.welcome.message1: Welcome!!!}")
    private String welcomeMsg1;

    @Value("#{'${training.init.keys.new.delimiter}'.split(';')}")
    private List<Integer> newKeys;




    public String getGreetingMessage(){
        LOG.info("Welcome newKeys {} ", newKeys);
        return welcomeMsg;
    }

    public String getGreetingMessage1(){
        LOG.info("Welcome newKeys {} ", newKeys);
        return welcomeMsg1;
    }


}



