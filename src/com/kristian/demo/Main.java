package com.kristian.demo;

import java.util.ArrayList;

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

        monsters.add(new Monster(2,20,20,3, "Giant Mosquito"));
        monsters.add(new Monster(5,35,35,6, "Zombie"));
        monsters.add(new Monster(7,50,50,9, "King Cobra"));
        monsters.add(new Monster(12,68,68,14, "Black Dragon"));
        monsters.add(new Monster(17,75,75,20, "Bloodthirsty Vampire"));

        Game game = new Game(player, monsters);
        game.startGame();
    }

    public static void debugReceiveExperience(int amountOfExp, Player player) {
    }

}
