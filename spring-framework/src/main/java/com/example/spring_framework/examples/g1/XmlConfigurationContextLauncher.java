package com.example.spring_framework.examples.g1;

import com.example.spring_framework.game.GameRunner;
import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigurationContextLauncher {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("contextConfiguration.xml");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean("name")); // 홍길동
        System.out.println(context.getBean("age")); // 20
        System.out.println(context.getBean("marioGame")); // com.example.spring_framework.game.MarioGame@55183b20

        context.getBean(GameRunner.class).run();
    }

}
