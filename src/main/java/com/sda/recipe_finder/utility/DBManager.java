package com.sda.recipe_finder.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
        public static void main(String[] args) {
            // Database credentials
            String url = "jdbc:mysql://localhost:3306/recipes_cookbook";
            String username = "root";
            String password = "134679976431";

            // Establishing a connection
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                if (connection != null) {
                    System.out.println("Connected to the database!");
                    // Perform database operations here
                    // Remember to close the connection when done
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Connection failed! Error: " + e.getMessage());
            }
        }

}
