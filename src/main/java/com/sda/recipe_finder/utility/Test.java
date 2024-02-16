package com.sda.recipe_finder.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public class DatabasePullExample {
        public static void main(String[] args) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/recipes_cookbook";
            String username = "root";
            String password = "134679976431";

            // SQL query to select data from the "maindish" table
            String sql = "SELECT * FROM maindish";

            try {
                // Create database connection
                Connection connection = DriverManager.getConnection(url, username, password);

                // Create statement
                Statement statement = connection.createStatement();

                // Execute query
                ResultSet resultSet = statement.executeQuery(sql);

                // Process query results
                while (resultSet.next()) {
                    // Retrieve data from result set
                    int dish_id = resultSet.getInt("dish_id");
                    String dish_name = resultSet.getString("dish_name");
                    // Access other columns as needed

                    // Process retrieved data
                    System.out.println("Dish ID: " + dish_id + ", Dish Name: " + dish_name);
                }

                // Close resources
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
