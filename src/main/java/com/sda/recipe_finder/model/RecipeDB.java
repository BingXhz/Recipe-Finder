package com.sda.recipe_finder.model;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RecipeDB extends Main {
    // Database connection details
    private static final String url = "jdbc:mysql://localhost:3306/recipes_cookbook";
    private static final String username = "root";
    private static final String password = "134679976431";

    static Connection connection;

    // Static block to initialize the connection
    static {
        try {
            // Establish database connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /////////////////////
    // Custom Methods //
    /////////////////////

    public static void selectFromAllRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            System.out.print("\nUse a corresponding number to view it's details (enter 0 to go back): ");

            try {
                int recipeNumber = scanner.nextInt();
                scanner.nextLine();

                if (recipeNumber == 0) {
                    returnToMainMenu = true;
                } else {
                    // Print details of the selected recipe
                    RecipeDataManager.printRecipeDetails(recipeNumber);

                    // Ask if the user wants to add this recipe to favorites
                    System.out.print("Want to Add this Recipe to My Favorites? (yes/no): ");
                    String addFavoriteChoice = scanner.nextLine().toLowerCase();

                    if (addFavoriteChoice.equals("yes")) {
                        addToFavorites(recipeNumber);
                    } else {
                        System.out.println("Recipe not Added to Favorites.");
                        Main.allRecipes(scanner);
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static void selectRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
        System.out.println();
        System.out.println("--- My Favourites ---");
        System.out.println();
        for (int i = 0; i < favoritesList.size(); i++) {
            int recipeNumber = favoritesList.get(i);
            RecipeDataManager.printFavouriteRecipes(recipeNumber);
            System.out.println("Enter " + (i + 1) + " to select this Recipe.");
        }
        while (!returnToMainMenu) {

            System.out.println();
            System.out.println("---------------------");
            System.out.print("Use a corresponding number to Select from Favorites (enter 0 to go back): ");
            System.out.println();

            try {
                int recipeNumber = scanner.nextInt();
                scanner.nextLine();

                if (recipeNumber == 0) {
                    returnToMainMenu = true;
                } else {
                    // Check if the entered recipe number is valid
                    if (recipeNumber <= favoritesList.size() && recipeNumber > 0) {
                        int selectedRecipeId = favoritesList.get(recipeNumber - 1);
                        RecipeDataManager.printRecipeDetails(selectedRecipeId);
                    } else {
                        System.out.println("Invalid recipe ID. Please select a valid number.");
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static void searchManually() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter search query:");
            String query = scanner.nextLine().toLowerCase();

            // Preprocess the query for regex
            query = Pattern.quote(query);

            // Create SQL query to select all rows from the table
            String sql = "SELECT * FROM ingredients";

            // Execute the query
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                // Process the results
                while (resultSet.next()) {
                    String columnValue = resultSet.getString("dish_name").toLowerCase();

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

    public static void searchByIngredient() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter search query:");
            String query = scanner.nextLine().toLowerCase();

            query = Pattern.quote(query);

            String sql = "SELECT * FROM ingredients";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String columnValue = resultSet.getString("ingredients").toLowerCase();

                    Pattern pattern = Pattern.compile("\\b" + query + "\\b", Pattern.CASE_INSENSITIVE);

                    if (pattern.matcher(columnValue).find()) {
                        System.out.println();
                        System.out.println("Match found in row: " + resultSet.getString("dish_id"));
                        System.out.println("Category: " + resultSet.getString("category"));
                        System.out.println("Name: " + resultSet.getString("dish_name"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchByCategory(Scanner scanner) {
        System.out.println("\nSearch inside a Category:");
        System.out.println("\t1 - Main Dishes");
        System.out.println("\t2 - Breakfast");
        System.out.println("\t3 - Desserts");
        System.out.println("\t4 - Soups");
        System.out.println("\t5 - Salads");

        // Prompt user for input
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Process user choice
            switch (choice) {
                case 1:
                    System.out.println("Performing search for Main Dishes...");
                    RecipeDataManager.printMainDishes();
                    break;
                case 2:
                    System.out.println("Performing search for Breakfast...");
                    RecipeDataManager.printBreakfastDishes();
                    break;
                case 3:
                    System.out.println("Performing search for Desserts...");
                    RecipeDataManager.printDesserts();
                    break;
                case 4:
                    System.out.println("Performing search for Soups...");
                    RecipeDataManager.printSoupDishes();
                    break;
                case 5:
                    System.out.println("Performing search for Salads...");
                    RecipeDataManager.printSalads();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please enter a number.");
            scanner.nextLine();
        }
    }

    static void addToFavorites(int recipeNumber) {
        if (!favoritesList.contains(recipeNumber)) {
            favoritesList.add(recipeNumber);
            System.out.println("Recipe successfully added to My Favourites!");
        } else {
            System.out.println("Recipe already in Favorites!");
        }
    }

    static void deleteFromFavorites(Integer recipeNumber) {
        if (favoritesList.contains(recipeNumber)) {
            favoritesList.remove(recipeNumber);
            System.out.println("Recipe removed from Favorites!");
        } else {
            System.out.println("Recipe is not in Favorites!");
        }
    }

}