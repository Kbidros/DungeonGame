package com.kristian.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.kristian.demo.Colors.*;
import static com.kristian.demo.Colors.RESET;

public class Game {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    DBConnection dbConnection = new DBConnection();

    Player player;
    ArrayList<Monster> monsters;

    public Game() {

    }

    private void initializePlayer() {
        player = new Player(5,5,5,80,1,5,80);
    }
    private void initializeMonsters() {
        monsters = new ArrayList<>();
        monsters.add(new Monster(2, 25, 25, 3, "Giant Mosquito"));
        monsters.add(new Monster(5, 35, 35, 6, "Zombie"));
        monsters.add(new Monster(7, 50, 50, 9, "King Cobra"));
        monsters.add(new Monster(12, 68, 68, 14, "Black Dragon"));
        monsters.add(new Monster(17, 75, 75, 20, "Bloodthirsty Vampire"));
        monsters.add(new Monster(20, 89, 89, 22, "Bowser"));
        monsters.add(new Monster(24, 100, 100, 26, "Godzilla"));
    }

    private static void sleepForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }


    // Starting the game & entering the first menu
    public void startGame() {
        initializePlayer();
        initializeMonsters();
        loadAllPlayers();
        System.out.println(YELLOW + "In a world surrounded by monstrous forces, \nyou stand as the last hope for humanity. \nWe need you rise to the challenge and reclaim a kingdom lost to the shadows." + RESET);
        System.out.println(BLUE + "What's your name soldier?" + RESET);

        player.setName(sc.nextLine());
        dbConnection.createPlayer(player);
        System.out.println(YELLOW + "Alright " + player.getName() + "," + " what would you like to do?" + RESET);

        boolean quit = false;
        do {
            System.out.println("1.Look for monsters and fight!\n2.Status\n3.Exit Game");

            int userChoice = sc.nextInt();
            sc.nextLine();

            switch (userChoice) {
                case 1 -> {
                    act(player);
                    if (player.isDead()) {
                        System.out.println("The monsters are now invading this world!");
                        quit = true;
                    }
                }
                case 2 -> player.getStatus();

                case 3 -> quit = true;

                default -> System.out.println("Incorrect input, please try again");
            }
        } while (!quit);
        System.out.println("Thanks for playing, see you next time!");
        sc.close();

    }
    public void loadAllPlayers() {
        ResultSet rs = dbConnection.getAllPlayersFromDB();

        if (rs == null) {
            System.out.println("Error fetching players from the database.");
            return;
        }

        try {
            System.out.println(PURPLE + "All Players:");
            while (rs.next()) {
                int playerId = rs.getInt("PlayerID");
                String playerName = rs.getString("Name");
                int playerLevel = rs.getInt("Lvl");
                int playerStrength = rs.getInt("Strength");
                int playerIntelligence = rs.getInt("Intelligence");
                int playerAgility = rs.getInt("Agility");
                int playerCurrentHP = rs.getInt("CurrentHP");
                int playerMaxHP = rs.getInt("MaxHP");
                int playerBaseDamage = rs.getInt("BaseDamage");
                System.out.println(BLUE + "Player ID: " + playerId + RESET +
                        GREEN + " Name: " + playerName +  "," + RESET +
                        RED + " Level: " + playerLevel + "," + RESET +
                         " Strength: " + playerStrength + "," +
                         " Intelligence: " + playerIntelligence +
                         " Agility: " + playerAgility +  "," + RESET +
                        RED + " CurrentHP: " + playerCurrentHP +  "," + RESET +
                        GREEN + " MaxHP: " + playerMaxHP +  "," + RESET +
                        BLUE + " BaseDamage: " + playerBaseDamage + RESET
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Player choice and fight menu
    public void act(Player player) {

        System.out.println(YELLOW + "<<<<<<<<<<<<<<<<<<<< Monster approaching >>>>>>>>>>>>>>>>>>>>" + RESET);
        Monster monster = monsters.get(new Random().nextInt(monsters.size()));
        dbConnection.createMonster(monster);
        System.out.println(RED + "You encountered " + monster.getName() + "!" + RESET);

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



    // Method that calculates the chance of escaping a battle, based on your agility level
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

    // Method for the battle between the player and the monster
    public void fighting(Player player, Monster monster) {
        System.out.println(YELLOW + "*************** Inside battle ***************" + RESET);

        // The player is attacking...
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

        // The monster is taking damage
        monster.takeDamageFromPlayer(playerDamage);

        // Checking if the monster is dead
        if (monster.getCurrentHP() == 0) {
            System.out.println(GREEN + "Monster is DEAD!" + RESET);
            System.out.println(GREEN + "You gained 100 EXP!" + RESET);

            player.experienceToLevelUp(100); // Simulera att spelaren får 10 erfarenhetspoäng
            player.levelingUp(); // Kontrollera om spelaren når nästa nivå
            player.setCurrentHP(player.getMaxHP());
            dbConnection.updatePlayerStats(player);
            return;
        }

        // Monster attacking player
        int monsterDamage = monster.calculateAttackDamage();
        System.out.println(RED + monster.getName() + " swings at you!");
        sleepForMilliseconds(1500);
        if (player.didDodge()) {
            System.out.println(GREEN + "You skillfully dodge the monster's attack!" + RESET);
            return;
        }

        System.out.println(RED + "ouch! You took " + monsterDamage + " damage!" + RESET);

        // Player is taking damage
        player.takeDamageFromMonster(monsterDamage);
        dbConnection.updatePlayerStats(player);



        // Checking if player is dead
        if (player.getCurrentHP() == 0) {
            System.out.println(RED_BACKGROUND + "Oh no, you died!" + RESET);
            return;
        }




        // Updating the player and monsters health
        System.out.println(CYAN + "Your health: " + player.getCurrentHP() + "/" + player.getMaxHP() + RESET);
        System.out.println(CYAN + "Monster's health: " + monster.getCurrentHP() + "/" + monster.getMaxHP() + RESET);
    }
}