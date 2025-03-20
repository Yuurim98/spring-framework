package com.example.spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole{

    @Override
    public void up() {
        System.out.println("점프");
    }

    @Override
    public void down() {
        System.out.println("구멍에 들어가기");
    }

    @Override
    public void left() {
        System.out.println("뒤로 가기");
    }

    @Override
    public void right() {
        System.out.println("앞으로 가기");
    }

}
