package com.example.restful_web_services.helloworld;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello World");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloBean helloPathVariable(@PathVariable String name) {
        return new HelloBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-internationalized")
    public String helloInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", null, "Default Message", locale);
    }
}
