package com.sda.recipe_finder.model;

import java.sql.*;

public class RecipeDataManager extends RecipeDB {

    private static final String url = "jdbc:mysql://localhost:3306/recipes_cookbook";
    private static final String username = "root";
    private static final String password = "134679976431";


    private static String lastPrintedCategory;

    public static void printHomePage() {
        System.out.println("\n--- Recipe Finder v0.1 ---");
        System.out.println("\t 1 - All Recipes");
        System.out.println("\t 2 - Search Recipes");
        System.out.println("\t 3 - Search Recipes By Ingredients");
        System.out.println("\t 4 - My Favourite Recipes");
        System.out.println("\t 0 - Quit The Application");
    }

    public static void printRecipeDetails(int recipeNumber) {
        // Define the SQL query to fetch the details of the recipe based on its number
        String sql = "SELECT dish_name, ingredients, instructions FROM ingredients WHERE dish_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {

            // Set the recipe number as a parameter in the prepared statement
            statement.setInt(1, recipeNumber);

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has any rows (recipes)
            if (resultSet.next()) {

                String recipeName = resultSet.getString("dish_name");
                String recipeDescription = resultSet.getString("ingredients");
                String recipeDirections = resultSet.getString("instructions");

                // Print the details of the recipe
                System.out.println("\n--- Recipe Details ---");
                System.out.println();
                System.out.println("Name: " + recipeName);
                System.out.println("Ingredients: " + recipeDescription);
                System.out.println("Instructions: " + recipeDirections);
            } else {
                System.out.println("Recipe not found with this ID.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.err.println("Error fetching recipe details: " + e.getMessage());
        }
    }

    public static void printFavouriteRecipes(int recipeNumber) {
        String sql = "SELECT dish_name, category FROM ingredients WHERE dish_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, recipeNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String recipeName = resultSet.getString("dish_name");
                String category = resultSet.getString("category");

                if (lastPrintedCategory == null || !lastPrintedCategory.equals(category)) {
                    System.out.println(category + ": " + recipeName);
                    lastPrintedCategory = category;
                } else {
                    System.out.println(category + ": " + recipeName);
                }
            } else {
                System.out.println("Recipe not found with this ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching recipe details: " + e.getMessage());
        }
    }

    public static void printAllDishes() {
        String sql = "SELECT * FROM ingredients";

        try {
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

        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printAllIngredients() {
        String sql = "SELECT * FROM ingredients_list";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                int ingredientId = resultSet.getInt("ingredient_id");
                String ingredientListList = resultSet.getString("ingredient_name");

                System.out.println("Nr: " + ingredientId);
                System.out.println("Recipe Name: " + ingredientListList);
            }

        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printMainDishes() {
        String sql = "SELECT * FROM maindish";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);


            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");


                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printBreakfastDishes() {
        String sql = "SELECT * FROM breakfast";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);


            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");


                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printDesserts() {
        String sql = "SELECT * FROM desserts";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);


            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");


                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }

        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printSoupDishes() {
        String sql = "SELECT * FROM soups";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);


            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");


                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }


        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printSalads() {
        String sql = "SELECT * FROM salads";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);


            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                int dishId = resultSet.getInt("dish_id");
                String category = resultSet.getString("category");
                String dishName = resultSet.getString("dish_name");


                System.out.println("Nr: " + dishId);
                System.out.println("Category: " + category);
                System.out.println("Recipe Name: " + dishName);
            }


        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        return connection;
    }

}