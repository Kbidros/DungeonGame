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


    private static void sleepForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }


    public void startGame() {
        System.out.println(GREEN + "Welcome to the Dungeon Game!");
        System.out.println(GREEN + "What's your name soldier?" + RESET);

        player.setName(sc.nextLine());
        System.out.println(CYAN + "Alright " + player.getName() + "," + " what would you like to do?" + RESET);

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

        System.out.println(YELLOW + "<<<<<<<<<<<<<<<<<<<< Monster approaching >>>>>>>>>>>>>>>>>>>>" + RESET);
        Monster monster = monsters.get(new Random().nextInt(monsters.size()));
        System.out.println(RED + "You encountered " + monster.getName() + "!" + RESET);


        // Fight Menu
        boolean fleeSuccessful = false;
        boolean quit = false;
        do {

            System.out.println("1.Attack\n2.Status\n3.Flee");

            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    fighting(player, monster);
                    break;
                case 2:
                    player.getStatus();
                    break;
                case 3:
                    fleeSuccessful = flee(player, monster);
                    if (fleeSuccessful) {
                        System.out.println("Returning to main menu...");
                    }
                    break;
                default:
                    System.out.println("Incorrect input, please try again");
            }
        } while (player.playerIsAlive() && monster.monsterIsAlive() && !fleeSuccessful);

    }

    public boolean flee(Player player, Monster monster) {
        int randomChance = random.nextInt(100) + 1;
        int fleeChance = player.getAgility() * 3;

        if (randomChance <= fleeChance) {
            System.out.println(GREEN + "You successfully fled from " + monster.getName() + "!" + RESET);
            return true;
        } else {
            System.out.println(RED + "You failed to flee! The battle continues." + RESET);
            return false;
        }
    }


    public static void fighting(Player player, Monster monster) {
        System.out.println(YELLOW + "*************** Inside battle ***************" + RESET);

        // Spelaren utför sitt anfall
        int playerDamage = player.calculateAttackDamage();
        System.out.println(BLUE + "You swing your sword ⚔️" + RESET);
        sleepForMilliseconds(1500);
        if (player.doubleHit()) {
            playerDamage *= 2;
            System.out.println(GREEN + "Double hit! You managed to double your damage! You did " + playerDamage + " damage to " + monster.getName() + "!" + RESET);
        } else {
            System.out.println(GREEN + "Hit success! You did " + playerDamage + " damage to " + monster.getName() + "!" + RESET);
        }
        System.out.println(YELLOW + "*********************************************" + RESET);
        sleepForMilliseconds(1500);


        // Monstret tar skada
        monster.takeDamageFromPlayer(playerDamage);

        // Kontrollera om monstret är dött
        if (monster.getCurrentHP() == 0) {
            System.out.println(GREEN + "Monster is DEAD!" + RESET);
            System.out.println(GREEN + "You gained 50 EXP!" + RESET);

            player.experienceToLevelUp(50); // Simulera att spelaren får 10 erfarenhetspoäng
            player.levelingUp(); // Kontrollera om spelaren når nästa nivå

            player.setCurrentHP(player.getMaxHP());
            return;
        }

        // Monstret gör sitt anfall
        int monsterDamage = monster.calculateAttackDamage();
        System.out.println(RED + monster.getName() + " swings at you!");
        sleepForMilliseconds(1500);
        if (player.didDodge()) {
            System.out.println(GREEN + "You skillfully dodge the monster's attack!" + RESET);
            return; // Sluta striden om spelaren undviker attacken
        }

        System.out.println(RED + "ouch! You took " + monsterDamage + " damage!" + RESET);

        // Spelaren tar skada
        player.takeDamageFromMonster(monsterDamage);

        // Kontrollera om spelaren är död
        if (player.getCurrentHP() == 0) {
            System.out.println(RED_BACKGROUND + "Oh no, you died!" + RESET);
            return;
        }

        // Uppdatera spelarens och monstrets hälsa

        System.out.println(CYAN + "Your health: " + player.getCurrentHP() + "/" + player.getMaxHP() + RESET);
        System.out.println(CYAN + "Monster's health: " + monster.getCurrentHP() + "/" + monster.getMaxHP() + RESET);
    }
}
