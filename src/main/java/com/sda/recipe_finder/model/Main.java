package com.sda.recipe_finder.model;

import com.sun.jdi.connect.spi.Connection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //////////////////////////////////////////
        //////////// !MAIN MENU LOOP! ////////////
        //////////////////////////////////////////

        boolean quit = false;
        while (!quit) {
            // Display main menu options
            printHomePage();
            System.out.println("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Process user choice
                switch (choice) {
                    case 1:
                        allRecipes(scanner);
                        break;
                    case 2:
                        searchRecipes(scanner);
                        break;
                    case 3:
                        searchRecipesByIngredients();
                        break;
                    case 4:
                        favouritesList();
                        break;
                    case 0:
                        quit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid! Enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /////////////////////////////////////////////////////////
    //////////// !METHODS FOR DIFFERENT OPTIONS! ////////////
    /////////////////////////////////////////////////////////

    // Method to print Home Page
    public static void printHomePage() {
        System.out.println("\n--- Recipe Finder v0.1 ---");
        System.out.println("\t 1 - All Recipes");
        System.out.println("\t 2 - Search Recipes");
        System.out.println("\t 3 - Search Recipes By Ingredients");
        System.out.println("\t 4 - My Favourite Recipes");
        System.out.println("\t 0 - Quit The Application");
    }

    // Method to show all Recipes
    public static void allRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
            System.out.println("\n--- All Recipes ---");
            RecipeDB.printAllDishes();
        while (!returnToMainMenu) {


            System.out.println("\n--- All Recipes ---");
            System.out.println("\t 1 - Select a Recipe");
            System.out.println("-- Category / Filters --");
            System.out.println("\t 2 - Show Only Main Dishes");
            System.out.println("\t 3 - Show Only Breakfast");
            System.out.println("\t 4 - Show Only Soups");
            System.out.println("\t 5 - Show Only Salads");
            System.out.println("\t 6 - Show Only Desserts");
            System.out.println("------------------------");
            System.out.println("\t 0 - Go Home");

            // Prompt user for input
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Process user choice
                switch (choice) {
                    case 1:
                        selectRecipes(scanner);
                    case 2:
                        RecipeDB.printMainDishes();
                        break;
                    case 3:
                        RecipeDB.printBreakfastDishes();
                        break;
                    case 4:
                        RecipeDB.printSoupDishes();
                        break;
                    case 5:
                        RecipeDB.printSalads();
                        break;
                    case 6:
                        RecipeDB.printDesserts();
                        break;
                    case 0:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid! Enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }


    public static void selectRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {

            // Prompt user to select a recipe by number
            System.out.print("\nEnter the number of a Recipe to view it's details (enter 0 to go back): ");
            try {
                int recipeNumber = scanner.nextInt();
                scanner.nextLine();

                // Check if the user wants to go back
                if (recipeNumber == 0) {
                    returnToMainMenu = true;
                } else {
                    // Fetch and Display details of the selected recipe
                    RecipeDB.printRecipeDetails(recipeNumber);
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    // Method to perform Searching Recipes
    public static void searchRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            System.out.println("\nSearch:");
            System.out.println("\t 1 - Manually");
            System.out.println("\t 2 - From Category");
            System.out.println("\t 0 - Go Home");

            // Prompt user for input
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Process user choice
                switch (choice) {
                    case 1:
                        // Call a method to perform search Manually
                        RecipeDB.searchManually();
                        break;
                    case 2:
                        // Call a method to perform search By Category
                        searchByCategory(scanner);
                        break;
                    case 0:
                        // Return to the main menu
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    // Method to perform Search By Category
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
            scanner.nextLine(); // Consume newline character

            // Process user choice
            switch (choice) {
                case 1:
                    System.out.println("Performing search for Main Dishes...");
                    RecipeDB.printMainDishes();
                    break;
                case 2:
                    System.out.println("Performing search for Breakfast...");
                    RecipeDB.printBreakfastDishes();
                    break;
                case 3:
                    System.out.println("Performing search for Desserts...");
                    RecipeDB.printDesserts();
                    break;
                case 4:
                    System.out.println("Performing search for Soups...");
                    RecipeDB.printSoupDishes();
                    break;
                case 5:
                    System.out.println("Performing search for Salads...");
                    RecipeDB.printSalads();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please enter a number.");
            scanner.nextLine();
        }
    }

    // Do you want to add this Recipe to My Favourites?
    public static void searchRecipesByIngredients() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t 6 - To delete all item in the list");
        System.out.println("\t 7 - To quit the application");
    }

    public static void favouritesList() {
        System.out.println("\nPress");
        System.out.println("\t 1 - Print My Favourites");
        System.out.println("\t 2 - Add a Recipe to My Favourites");
        System.out.println("\t 3 - Search a Recipe from My Favourites");
        System.out.println("\t 4 - Delete a Recipe from My Favourites");
        System.out.println("\t 0 - Go Back");
    }


}