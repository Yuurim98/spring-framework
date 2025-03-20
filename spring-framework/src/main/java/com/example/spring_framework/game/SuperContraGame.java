package com.example.spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 여기에 빈 이름 지정할 수도 있음
@Qualifier("SuperContraGameQualifier") // 명시하지 않아도 됨 - 주입받는 곳에서 어노테이션과 빈 이름 명시도 가능함
public class SuperContraGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("위로 가기");
    }

    @Override
    public void down() {
        System.out.println("앉기");
    }

    @Override
    public void left() {
        System.out.println("뒤로 가기");
    }

    @Override
    public void right() {
        System.out.println("총알 발사");
    }
}
