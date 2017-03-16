package com.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
@SpringBootApplication
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Exception.class);


    @RequestMapping("/hello")
    String home() {
        return "hello word";
    }

}