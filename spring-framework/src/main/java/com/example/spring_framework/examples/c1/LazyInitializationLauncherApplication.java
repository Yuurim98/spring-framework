package com.example.spring_framework.examples.c1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("ClassB 생성 로직");
        this.classA = classA;
    }

    public void print() {
        System.out.println("메서드 호출");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
            LazyInitializationLauncherApplication.class);

        System.out.println("컨텍스트 시작");

        context.getBean(ClassB.class).print();

        /*
        컨텍스트 시작
        ClassB 생성 로직
        메서드 호출
         */

    }

}
