package com.kristian.demo;

import java.util.Scanner;

import static com.kristian.demo.Colors.*;

public class Main {

    public static void main(String[] args) {



        Player player = new Player(
                50,
                5,
                5,
                50,
                1,
                5,
                50
        );
        Monster monster = new Monster(5,20,20,5);

        Game game = new Game(player, monster);
        game.startGame();



    }


    public static void debugReceiveExperience(int amountOfExp, Player player) {
    }





}
