package com.kristian.demo;

import java.util.Scanner;

import static com.kristian.demo.Colors.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Instantiate Objects
        Player player = new Player();


        System.out.println(GREEN + "Welcome Adventurer" + RESET);
        System.out.println(BLUE + "What is your name?" + RESET);
        player.setName(sc.nextLine());

        System.out.println("Welcome to the game " + player.getName() + "," + " what would you like to do?");

        // Menu

        do {

            System.out.println("1.Fight\n2.Status\n3.Exit Game");
            switch (sc.nextLine()) {
                case "1" -> fightMenu(player);
                case "2" -> player.getStatus();
                case "3" -> System.exit(0);

                default -> System.out.println("Try again!");
            }
        }while (true);

    }

    public static void fightMenu (Player player) {

        System.out.println("Inside another MENU");
        switch (sc.nextLine()) {
            case "1" -> System.out.println("Player " + player.getName() + " is fighting");
            case "2" -> System.out.println("Number #2");

            default -> System.out.println("Try again");


        }



    }



}
