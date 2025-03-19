package com.example.spring_framework;

import com.example.spring_framework.game.GameRunner;
import com.example.spring_framework.game.GamingConsole;
import com.example.spring_framework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

       var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

       context.getBean(GamingConsole.class).up();
       context.getBean(GameRunner.class).run();
    }

}
