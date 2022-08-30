package com.training.springBoot.controller;

import com.training.springBoot.services.DefaultWelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WelcomeController {

    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

    @Resource
    private DefaultWelcomeService defaultWelcomeService;

    @Value("${training.welcome.message: Welcome!!!}")
    private String welcomeMsg;

    @Value("${training.init.keys}")
    private int[] keys;

    @Value("${training.init.keys}")
    private List<Integer> keyList;


    @GetMapping("/welcome")
    public String displayWelcomeMsg() {
        LOG.info("keys as integer array {}", keys);
        LOG.info("keys as integer list {}", keyList);
        return defaultWelcomeService.getGreetingMessage();
    }

    @GetMapping("/welcome1")
    public String displayMsg() {
        LOG.info("keys as integer array {}", keys);
        LOG.info("keys as integer list {}", keyList);
        return defaultWelcomeService.getGreetingMessage1();
    }




}