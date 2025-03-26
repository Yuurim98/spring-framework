package com.example.spring_framework.examples.g1;

import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigurationContextLauncher {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("contextConfiguration.xml");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean("name")); // 홍길동
        System.out.println(context.getBean("age")); // 20
        System.out.println(context.getBean("gameRunner")); // com.example.spring_framework.game.GameRunner@1f9f6368
    }

}
