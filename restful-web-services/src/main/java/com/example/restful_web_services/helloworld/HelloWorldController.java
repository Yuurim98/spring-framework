package com.example.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello World");
    }
}
