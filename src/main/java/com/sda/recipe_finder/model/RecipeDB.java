package com.sda.recipe_finder.model;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RecipeDB {
    // Database connection details
    private static final String url = "jdbc:mysql://localhost:3306/recipes_cookbook";
    private static final String username = "root";
    private static final String password = "134679976431";

    private static Connection connection;
    // Static block to initialize the connection
    static {
        try {
            // Establish database connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Custom method to retrieve and print text data from the database
    public static void printRecipeDetails(int recipeNumber) {
        // Define the SQL query to fetch the details of the recipe based on its number
        String sql = "SELECT dish_name, ingredients FROM ingredients WHERE dish_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the recipe number as a parameter in the prepared statement
            statement.setInt(1, recipeNumber);

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has any rows (recipes)
            if (resultSet.next()) {
                // Retrieve the values of the recipe name and description columns
                String recipeName = resultSet.getString("dish_name");
                String recipeDescription = resultSet.getString("ingredients");

                // Print the details of the recipe
                System.out.println("\n--- Recipe Details ---");
                System.out.println("Name: " + recipeName);
                System.out.println("Ingredients: " + recipeDescription);
            } else {
                // If no recipe is found for the given number, print a message
                System.out.println("Recipe not found for the given number.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.err.println("Error fetching recipe details: " + e.getMessage());
        }
    }

    public static void printAllDishes() {
        // SQL query to select all columns from the "ingredients" table
        String sql = "SELECT * FROM ingredients";

        try {
            // Create database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process query results
            while (resultSet.next()) {
                // Retrieve data
                int dishId = resultSet.getInt("dish_id");
                String dishName = resultSet.getString("dish_name");

                // Print data
                System.out.println("Nr: " + dishId);
                System.out.println("Recipe Name: " + dishName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printMainDishes() {
        // SQL query to select all columns from the "maindish" table
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
                // Retrieve data
                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");

                // Print data
                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printBreakfastDishes() {
        // SQL query to select all columns from the "breakfast" table
        String sql = "SELECT * FROM breakfast";

        try {
            // Create database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process query results
            while (resultSet.next()) {
                // Retrieve data
                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");

                // Print data
                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printDesserts() {
        // SQL query to select all columns from the "desserts" table
        String sql = "SELECT * FROM desserts";

        try {
            // Create database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process query results
            while (resultSet.next()) {
                // Retrieve data
                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");

                // Print data
                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printSoupDishes() {
        // SQL query to select all columns from the "soups" table
        String sql = "SELECT * FROM soups";

        try {
            // Create database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process query results
            while (resultSet.next()) {
                // Retrieve data
                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");

                // Print data
                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printSalads() {
        // SQL query to select all columns from the "salads" table
        String sql = "SELECT * FROM salads";

        try {
            // Create database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process query results
            while (resultSet.next()) {
                // Retrieve data
                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");

                // Print data
                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void searchManually() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter search query:");
            String query = scanner.nextLine().toLowerCase(); // Convert query to lowercase

            // Preprocess the query for regex
            query = Pattern.quote(query);

            // Create SQL query to select all rows from the table
            String sql = "SELECT * FROM ingredients";

            // Execute the query
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                // Process the results
                while (resultSet.next()) {
                    String columnValue = resultSet.getString("dish_name").toLowerCase(); // Convert to lowercase for case-insensitive comparison

                    // Create regex pattern to match the query
                    Pattern pattern = Pattern.compile("\\b" + query + "\\b", Pattern.CASE_INSENSITIVE);

                    // Check if the column value matches the query
                    if (pattern.matcher(columnValue).find()) {
                        // Match found, print the row or perform further processing
                        System.out.println("Match found in row: " + resultSet.getString("dish_name"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}