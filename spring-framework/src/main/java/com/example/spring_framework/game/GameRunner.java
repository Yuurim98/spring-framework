package com.example.spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("게임 시작 : " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
