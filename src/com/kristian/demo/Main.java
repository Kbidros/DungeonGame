package com.kristian.demo;

public class Main {

    public static void main(String[] args) {

        DBConnection db = new DBConnection();
        db.open();
        Game game = new Game();
        game.startGame();
    }
}