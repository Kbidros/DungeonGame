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
            System.out.println("Database connected");

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

    public String createTablePlayer() {
        String sql = "CREATE TABLE player (playerID INT NOT NULL AUTO_INCREMENT, name VARCHAR(60), health INT, primary KEY(playerID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public String createTableMonster() {
        String sql = "CREATE TABLE monster (monsterID INT NOT NULL AUTO_INCREMENT, type VARCHAR(100), primary KEY(monsterID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public int createPlayer (Player newPlayer) {

        int incrementID = 0;
        String sql = "INSERT INTO player (name, health ) values (?, ?)";

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newPlayer.getName());
            preparedStatement.setInt(2, newPlayer.getMaxHP());
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

    public int updatePlayerHealth(int health, int id) {

        String sql = "UPDATE player set health = ? where PlayerID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, health);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

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
