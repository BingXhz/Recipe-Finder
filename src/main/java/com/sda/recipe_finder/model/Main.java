package com.sda.recipe_finder.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // A List to store Favorite Recipes
    public static List<Integer> favoritesList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            RecipeDataManager.printHomePage();
            System.out.println("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        allRecipes(scanner);
                        break;
                    case 2:
                        searchRecipes(scanner);
                        break;
                    case 3:
                        searchRecipesByIngredients(scanner);
                        break;
                    case 4:
                        favouritesList(scanner);
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
    }

    /////////////////////
    // Custom Methods //
    /////////////////////
    public static void allRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            System.out.println("\n----- All Recipes -----");
            RecipeDataManager.printAllDishes();

            System.out.println("\n----- All Recipes -----");
            System.out.println("\t 1 - Select a Recipe");
            System.out.println("-- Category / Filters --");
            System.out.println("\t 2 - Show Only Main Dishes");
            System.out.println("\t 3 - Show Only Breakfast");
            System.out.println("\t 4 - Show Only Soups");
            System.out.println("\t 5 - Show Only Salads");
            System.out.println("\t 6 - Show Only Desserts");
            System.out.println("------------------------");
            System.out.println("\t 0 - Go Home");

            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        RecipeDB.selectFromAllRecipes(scanner);
                        break;
                    case 2:
                        RecipeDataManager.printMainDishes();
                        break;
                    case 3:
                        RecipeDataManager.printBreakfastDishes();
                        break;
                    case 4:
                        RecipeDataManager.printSoupDishes();
                        break;
                    case 5:
                        RecipeDataManager.printSalads();
                        break;
                    case 6:
                        RecipeDataManager.printDesserts();
                        break;
                    case 0:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid! Enter a number from The Menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static void searchRecipes(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            System.out.println("\nSearch:");
            System.out.println("\t 1 - Manually");
            System.out.println("\t 2 - From Category");
            System.out.println("\t 0 - Go Home");

            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        RecipeDB.searchManually();
                        break;
                    case 2:
                        RecipeDB.searchByCategory(scanner);
                        break;
                    case 0:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter the ID from The Menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static void searchRecipesByIngredients(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            System.out.println("\n--- Search Recipes By Ingredients ---");
            System.out.println("\t 1 - List All Ingredients");
            System.out.println("\t 2 - Search by Ingredient");
            System.out.println("\t 0 - Go Home");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        RecipeDataManager.printAllIngredients();
                        break;
                    case 2:
                        RecipeDB.searchByIngredient();
                        break;
                    case 0:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void favouritesList(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            System.out.println("\n--- My Favourites ---");
            System.out.println("");
            if (favoritesList.isEmpty()) {
                System.out.println("\tNo favorite recipes yet.");
            } else {
                for (int i = 0; i < favoritesList.size(); i++) {
                    RecipeDataManager.printFavouriteRecipes(favoritesList.get(i));
                }
            }
            System.out.println("\n---------------------");
            if (!favoritesList.isEmpty()) {
                System.out.println("\t 1 - Select a Favourite Recipe");
                System.out.println("\t 2 - Delete Recipe from My Favourites");
            }
            System.out.println("\t 3 - Add Recipe to My Favourites");

            System.out.println("\t 0 - Go Back");

            System.out.print("Enter your choice: ");
            System.out.println();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (!favoritesList.isEmpty()) {
                            RecipeDB.selectRecipes(scanner);
                        } else {
                            System.out.println("No Favorite recipes yet.");
                        }
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("--- My Favourites ---");
                        System.out.println();
                        for (int i = 0; i < favoritesList.size(); i++) {
                            int recipeNumber = favoritesList.get(i);
                            RecipeDataManager.printFavouriteRecipes(recipeNumber);
                            System.out.println("Enter " + (i + 1) + " to remove from Favorites.");

                        }
                        System.out.println();
                        System.out.println("---------------------");
                        System.out.print("Use a corresponding number to Remove from Favorites (enter 0 to go back): ");
                        int choicedelete = scanner.nextInt();
                        scanner.nextLine();
                        if (choicedelete == 0) {
                            return;
                        } else if (choice >= choicedelete && choicedelete <= favoritesList.size()) {
                            RecipeDB.deleteFromFavorites(favoritesList.get(choicedelete - 1));
                        } else {
                            System.out.println("Invalid choice. Please enter the ID from The Menu.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the recipe ID: ");
                        int recipeId = scanner.nextInt();
                        scanner.nextLine();
                        RecipeDB.addToFavorites(recipeId);
                        break;
                    case 0:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter the ID from The Menu.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

}