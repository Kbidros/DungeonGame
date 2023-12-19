package com.kristian.demo;

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

    public int updatePlayerStats(int playerId, int Lvl, int CurrentHP, int MaxHP, int Strength, int Intelligence, int Agility, int BaseDamage) {

        String sql = "UPDATE player SET Lvl = ?, CurrentHP = ?, MaxHP = ?, Strength = ?, Intelligence = ?, Agility = ?, BaseDamage = ? WHERE playerID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Lvl);
            preparedStatement.setInt(2, CurrentHP);
            preparedStatement.setInt(3, MaxHP);
            preparedStatement.setInt(4, Strength);
            preparedStatement.setInt(5, Intelligence);
            preparedStatement.setInt(6, Agility);
            preparedStatement.setInt(7, BaseDamage);
            preparedStatement.setInt(8, playerId);

            affectedRows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public String getPlayerWithId(int id) {

        String sql = "SELECT * from player where PlayerID = ?";
        String playerName;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                playerName = rs.getString("name");
                return playerName;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }




}
