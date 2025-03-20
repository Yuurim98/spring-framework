package com.example.spring_framework.game;

public class App01GamingBasicJava {

    public static void main(String[] args) {

        // var game = new MarioGame();
        // var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }

}
