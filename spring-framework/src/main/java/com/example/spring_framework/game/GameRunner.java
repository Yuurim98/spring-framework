package com.example.spring_framework.game;

public class GameRunner {
    MarioGame game;

    public GameRunner(MarioGame marioGame) {
        this.game = marioGame;
    }

    public void run() {
        System.out.println("게임 시작 : " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
