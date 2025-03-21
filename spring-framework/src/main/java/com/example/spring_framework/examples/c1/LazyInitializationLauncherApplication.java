package com.example.spring_framework.examples.c1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("ClassB 생성 로직");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
            LazyInitializationLauncherApplication.class);

        // ClassB 생성자를 호출하는 코드가 없는데도 "ClassB 생성 로직" 이 출력됨
    }

}
