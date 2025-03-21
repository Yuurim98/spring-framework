package com.example.spring_framework.examples.e1;

import com.example.spring_framework.examples.d1.BeanScopesLauncherApplication;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("someDependency 주입");
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void close() {
        System.out.println("컨텍스트 종료 직전 실행");
    }


}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("SomeClass 빈 생성 후 바로 실행");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
            PrePostAnnotationsContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        context.close();
    }

}
