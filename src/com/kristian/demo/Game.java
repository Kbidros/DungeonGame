package com.kristian.demo;

import java.util.Random;
import java.util.Scanner;

import static com.kristian.demo.Colors.*;
import static com.kristian.demo.Colors.RESET;
import static com.kristian.demo.Main.debugReceiveExperience;

public class Game {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    Player player;
    Monster monster;

    public Game(Player player, Monster monster){

        this.player = player;
        this.monster = monster;
    }

    public void startGame() {
        System.out.println(GREEN + "Welcome Adventurer" + RESET);
        System.out.println(BLUE + "What is your name?" + RESET);

        player.setName(sc.nextLine());
        System.out.println("Welcome to the game " + player.getName() + "," + " what would you like to do?");

        boolean quit = false;
        do {

            System.out.println("1.Look for monsters and fight!\n2.Status\n3.Exit Game\n0. Debug Experience");

            int userChoice = sc.nextInt();
            sc.nextLine();

            switch (userChoice) {
                case 1 -> fightMenu(player);
                case 2 -> player.getStatus();
                case 3 -> quit = true;
                case 4 -> debugReceiveExperience(125, player);

                default -> System.out.println("Incorrect input, please try again");
            }
        } while (quit);
        System.out.println("Thanks for playing, see you next time!");
        sc.close();




    }

    public static void fighting (Player player, Monster monster){
        System.out.println(YELLOW + "******** Inside battle ********" + RESET);
        System.out.println(BLUE + "Hunter shoots arrows \uD83C\uDFF9  ➳➳➳➳➳" + RESET);
        System.out.println(GREEN + "Hit success, monster loses 5 hitpoints!" + RESET);

        player.takeDamage(5);
        monster.takeDamage(5);



    }
    public void fightMenu (Player player) {

        System.out.println( YELLOW + "********* Monster approaching *********" + RESET);
        System.out.println(RED + "Monster health: " + monster.getCurrentHP() + "/" + monster.getMaxHP() + RESET);
        System.out.println(GREEN + "Monster strength: " + monster.getStrength() + RESET);
        System.out.println(BLUE + "Monster baseDamage: " + monster.getBaseDamage() + RESET);



        // Fight Menu
        do {

            System.out.println("1.Battle\n2.Status\n3.Flee");

            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1 -> fighting (player, monster);
                case 2 -> player.getStatus();
                // case 3 -> player.flee   --------- 2023-11-11 fix flee method with random chance.

                default -> System.out.println("Incorrect input, please try again");
            }
        }while (true);

    }

}
