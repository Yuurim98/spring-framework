package com.example.spring_framework.examples.a1;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BusinessClass {
    Dependency1 dependency1;

    Dependency2 dependency2;

    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("setter 주입 1");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("setter 주입 2");
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "1 : " + dependency1 + " 2 : " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}


@Configuration
@ComponentScan // 현재 클래스 패키지와 하위 패키지를 자동으로 찾음(경로는 지정하지 않아도 됨)
public class DepinjectionLauncherApplication {

    public static void main(String[] args) {

       var context = new AnnotationConfigApplicationContext(DepinjectionLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        // 1) 클래스 만들기 전 : depinjectionLauncherApplication

        /* 2) 클래스 만든 후 : 만든 클래스에 대한 빈이 생성됨
         * depinjectionLauncherApplication
         * businessClass
         * dependency1
         * dependency2
         */

        // System.out.println(context.getBean(BusinessClass.class).toString());
        // 3) 의존성 주입 전 : 1 : null 2 : null

        // 4) @Autowired를 통해 필드 주입 후 :
        // 1 : com.example.spring_framework.examples.a1.Dependency1@4f67eb2a 2 : com.example.spring_framework.examples.a1.Dependency2@4a668b6e

        System.out.println(context.getBean(BusinessClass.class).toString());
        // 5) "setter 주입 1", "setter 주입 2" 출력

    }

}
