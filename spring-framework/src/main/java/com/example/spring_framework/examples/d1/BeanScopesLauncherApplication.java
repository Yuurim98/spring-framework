package com.example.spring_framework.examples.d1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
            BeanScopesLauncherApplication.class);

        System.out.println(context.getBean(NormalClass.class));
        System.out.println(context.getBean(NormalClass.class));
        System.out.println(context.getBean(NormalClass.class));

        /*
            com.example.spring_framework.examples.d1.NormalClass@50caa560
            com.example.spring_framework.examples.d1.NormalClass@50caa560
            com.example.spring_framework.examples.d1.NormalClass@50caa560
         */

        System.out.println(context.getBean(PrototypeClass.class));
        System.out.println(context.getBean(PrototypeClass.class));
        System.out.println(context.getBean(PrototypeClass.class));

        /*
            com.example.spring_framework.examples.d1.PrototypeClass@568ff82
            com.example.spring_framework.examples.d1.PrototypeClass@50caa560
            com.example.spring_framework.examples.d1.PrototypeClass@2a266d09
         */

    }

}
