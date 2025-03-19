package com.example.spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {};
record Address(String city, String gu) {};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Spring";
    }

    @Bean
    public int age() {
        return 20;
    }

    @Bean
    public Person person() {
        return new Person("홍길동", 23);
    }

    @Bean
    public Address address() {
        return new Address("서울시", "송파구");
    }

}
