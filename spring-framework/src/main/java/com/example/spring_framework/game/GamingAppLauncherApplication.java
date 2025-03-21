package com.example.spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.spring_framework.game") // 지정한 패키지에서 @Component 찾아 빈 등록
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

       var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);

       context.getBean(GamingConsole.class).up();
       context.getBean(GameRunner.class).run();
    }

}
