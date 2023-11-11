package com.kristian.demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.kristian.demo.Colors.*;
import static com.kristian.demo.Colors.RESET;
import static com.kristian.demo.Main.debugReceiveExperience;

public class Game {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    Player player;
    ArrayList<Monster> monsters;


    public Game(Player player, ArrayList<Monster> monsters) {
        this.player = player;
        this.monsters = monsters;
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
                case 1 -> act(player);
                case 2 -> player.getStatus();
                case 3 -> quit = true;
                case 4 -> debugReceiveExperience(125, player);

                default -> System.out.println("Incorrect input, please try again");
            }
        } while (!quit);
        System.out.println("Thanks for playing, see you next time!");
        sc.close();


    }
    public void act(Player player) {

        System.out.println(YELLOW + "*************** Monster approaching ***************" + RESET);
        Monster monster = monsters.get(new Random().nextInt(monsters.size()));
        System.out.println(RED + "You encountered " + monster.getName() + "!" + RESET);

        // Fight Menu
        do {

            System.out.println("1.Attack\n2.Status\n3.Flee");

            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1 -> fighting(player, monster);
                case 2 -> player.getStatus();
                // case 3 -> player.flee   --------- 2023-11-11 fix flee method with random chance.

                default -> System.out.println("Incorrect input, please try again");
            }
        } while (player.playerIsAlive() && monster.monsterIsAlive());

    }

    public static void fighting(Player player, Monster monster) {
        System.out.println(YELLOW + "*************** Inside battle ***************" + RESET);

        // Spelaren utför sitt anfall
        int playerDamage = player.calculateAttackDamage();
        System.out.println(BLUE + "Ranger shoots arrows \uD83C\uDFF9  ➳➳➳➳➳" + RESET);
        System.out.println(GREEN + "Hit success! You did " + playerDamage + " damage to " + monster.getName() + "!"+ RESET);
        System.out.println(YELLOW + "*********************************************" + RESET);

        // Monstret tar skada
        monster.takeDamageFromPlayer(playerDamage);

        // Kontrollera om monstret är dött
        if (monster.getCurrentHP() == 0) {
            System.out.println(GREEN + "Monster is DEAD!" + RESET);
            player.experienceToLevelUp(50);
            return;
        }

        // Monstret gör sitt anfall
        int monsterDamage = monster.calculateDamageToPlayer();
        System.out.println(RED + monster.getName() + " swings at you!");
        System.out.println(RED + "ouch! You took " + monsterDamage + " damage!" + RESET);

        // Spelaren tar skada
        player.takeDamageFromMonster(monsterDamage);

        // Kontrollera om spelaren är död
        if (player.getCurrentHP() == 0) {
            System.out.println(RED_BACKGROUND + "Damn, you died!" + RESET);
            return;
        }

        // Uppdatera spelarens och monstrets hälsa

        System.out.println("Your health: " + player.getCurrentHP() + "/" + player.getMaxHP());
        System.out.println("Monster's health: " + monster.getCurrentHP() + "/" + monster.getMaxHP());



    }



}
