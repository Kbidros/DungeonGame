package com.kristian.demo;

import java.util.Scanner;

import static com.kristian.demo.Colors.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Instantiate Objects
        Player player = new Player(
                5,
                5,
                5,
                50,
                1,
                5

        );


        System.out.println(GREEN + "Welcome Adventurer" + RESET);
        System.out.println(BLUE + "What is your name?" + RESET);
        player.setName(sc.nextLine());

        System.out.println("Welcome to the game " + player.getName() + "," + " what would you like to do?");

        // Menu

        do {

            System.out.println("1.Fight\n2.Status\n3.Exit Game\n0. Debug Experience");
            switch (sc.nextLine()) {
                case "1" -> fightMenu(player);
                case "2" -> player.getStatus();
                case "3" -> System.exit(0);

                case "0" -> debugReceiveExperience(125, player);

                default -> System.out.println("Try again!");
            }
        } while (true);

    }

    public static void fightMenu(Player player) {

        Monster monster = new Monster(5,20,5);

        // Fight Menu
        do {

            System.out.println("----Monster approaching----");
            System.out.println("Monster: " + monster.getHealth());

            System.out.println("1.Battle\n2.Status\n3.Flee");

            switch (sc.nextLine()) {
                case "1" -> battle(player, monster);
                case "2" -> player.getStatus();

                default -> System.out.println("Try again");
            }
        }while (true);


    }
    public static void debugReceiveExperience(int amountOfExp, Player player) {
    }


    public static void battle(Player player, Monster monster){
        System.out.println("Inside Battle");

        player.takeDamage(5);
        monster.takeDamage(5);



    }


}
