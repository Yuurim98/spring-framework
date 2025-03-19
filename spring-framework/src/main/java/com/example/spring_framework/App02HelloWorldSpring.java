package com.example.spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        // HelloWorldConfiguration 클래스를 기반으로 컨텍스트를 생성
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 빈을 정의한 메서드명이 빈 이름이 됨
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("customBean"));
        System.out.println(context.getBean(Address.class));

    }

}
