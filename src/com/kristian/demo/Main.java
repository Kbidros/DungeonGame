package com.kristian.demo;

import java.util.ArrayList;
import java.util.Scanner;

import static com.kristian.demo.Colors.*;

public class Main {

    public static void main(String[] args) {

        Player player = new Player(
                5,
                5,
                5,
                80,
                1,
                5,
                80
        );
        ArrayList<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster(4,20,20,6, "Giant Mosquito"));
        monsters.add(new Monster(7,35,35,13, "One-eyed pirate"));
        monsters.add(new Monster(12,50,50,19, "Scorpion"));
        monsters.add(new Monster(22,68,68,28, "King Black Dragon"));

        Game game = new Game(player, monsters);
        game.startGame();
    }

    public static void debugReceiveExperience(int amountOfExp, Player player) {
    }

}
