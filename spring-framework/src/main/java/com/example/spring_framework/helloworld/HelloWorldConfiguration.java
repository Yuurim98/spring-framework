package com.example.spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {};
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
        return new Person("홍길동", 23, new Address("서울시", "강동구"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); // 빈을 정의한 메서드를 호출하여 가져옴
    }

    @Bean
    public Person person3Parameters(String name, int age, @Qualifier("address2Qualifier") Address address) { // 빈 타입으로 매개변수 주입
        return new Person(name, age, address);
    }

    @Bean(name = "customBean")
    @Primary
    public Address address() {
        return new Address("서울시", "송파구");
    }

    @Bean()
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("서울시", "강동구");
    }

}
