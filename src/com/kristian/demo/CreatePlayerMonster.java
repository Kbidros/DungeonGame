package com.kristian.demo;

import java.util.Scanner;

public class CreatePlayerMonster {

    DBConnection dbConnection = new DBConnection();

    public void createPlayer() {

        dbConnection.open();
        Player newPlayer = new Player(5,5,5,80,1,5,80);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter players name");
        String playerName = scanner.nextLine();
        System.out.println("Enter health");
        int playerHealth = scanner.nextInt();

        newPlayer.setName(playerName);
        newPlayer.setMaxHP(playerHealth);

        System.out.println("Player created with id: " + dbConnection.createPlayer(newPlayer));
        dbConnection.closeConnection();

    }
}
