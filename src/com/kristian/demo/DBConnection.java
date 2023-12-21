package com.kristian.demo;

import javax.xml.transform.Result;
import java.sql.*;

public class DBConnection {
    private String URL = "jdbc:mysql://localhost:3306/DungeonRun";
    private String USER = "root";
    private String password = "Hol980add510#";
    private Connection connection;

    public void open() {
        try {
            connection = DriverManager.getConnection(URL, USER, password);


        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public int createPlayer (Player newPlayer) {

        int incrementID = 0;
        String sql = "INSERT INTO player (Name, Lvl, CurrentHP, MaxHP, Strength, Intelligence, Agility, BaseDamage ) values (?, ?, ?, ?, ?, ?, ?, ?)";

        open();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newPlayer.getName());
            preparedStatement.setInt(2, newPlayer.getLevel());
            preparedStatement.setInt(3, newPlayer.getCurrentHP());
            preparedStatement.setInt(4, newPlayer.getMaxHP());
            preparedStatement.setInt(5, newPlayer.getStrength());
            preparedStatement.setInt(6, newPlayer.getIntelligence());
            preparedStatement.setInt(7, newPlayer.getAgility());
            preparedStatement.setInt(8, newPlayer.getBaseDamage());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
                newPlayer.setId(incrementID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }
    public int createMonster (Monster newMonster) {

        int incrementID = 0;
        String sql = "INSERT INTO monster (Name, CurrentHP, MaxHP, Strength, BaseDamage ) values (?, ?, ?, ?, ?)";

        open();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newMonster.getName());
            preparedStatement.setInt(2, newMonster.getCurrentHP());
            preparedStatement.setInt(3, newMonster.getMaxHP());
            preparedStatement.setInt(4, newMonster.getStrength());
            preparedStatement.setInt(5, newMonster.getBaseDamage());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }

    public int updatePlayerStats (Player player) {

        String sql = "UPDATE player SET Lvl = ?, CurrentHP = ?, MaxHP = ?, Strength = ?, Intelligence = ?, Agility = ?, BaseDamage = ? WHERE playerID = ?";
        int incrementID = 0;
        try {
            int playerID = player.getId();

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, player.getLevel());
            preparedStatement.setInt(2, player.getCurrentHP());
            preparedStatement.setInt(3, player.getMaxHP());
            preparedStatement.setInt(4, player.getStrength());
            preparedStatement.setInt(5, player.getIntelligence());
            preparedStatement.setInt(6, player.getAgility());
            preparedStatement.setInt(7, player.getBaseDamage());
            preparedStatement.setInt(8,player.getId());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Player updated successfully.");
            } else {
                System.out.println("No player with ID " + playerID + " found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incrementID;
    }

    public ResultSet getAllPlayersFromDB() {

        ResultSet rs = null;
        String sql = "SELECT * FROM player";

        open();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
