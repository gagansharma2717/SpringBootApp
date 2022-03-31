package com.sampleapp.SpringBootApp.tutorial.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${Welcome.Message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String HelloWorld(){
            return welcomeMessage;
    }
}
