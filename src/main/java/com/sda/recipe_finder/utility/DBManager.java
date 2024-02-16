package com.sda.recipe_finder.utility;
import java.sql.*;

public class DBManager {
        public static void main(String[] args) {
            // Database credentials
            String url = "jdbc:mysql://localhost:3306/recipes_cookbook";
            String username = "root";
            String password = "134679976431";

            // SQL query to select data from the "maindish" table
            String sql = "SELECT * FROM maindish";



            // Establishing a connection
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                // Create statement
                Statement statement = connection.createStatement();

                // Execute query
                ResultSet resultSet = statement.executeQuery(sql);

                if (connection != null) {
                    System.out.println("Connected to the database!");
                    // Perform database operations here
                    // Remember to close the connection when done

                    // Process query results
                    while (resultSet.next()) {
                        // Retrieve data from result set
                        int id = resultSet.getInt("dish_id");
                        String name = resultSet.getString("dish_name");
                        String instructions = resultSet.getString("instructions");
                        // Access other columns as needed

                        // Process retrieved data
                        System.out.println("ID: " + id + ", Name: " + name + ", Instructions: " + instructions);
                    }
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println("Connection failed! Error: " + e.getMessage());
            }
        }

        public static void showRecipeList() {

        }

}
