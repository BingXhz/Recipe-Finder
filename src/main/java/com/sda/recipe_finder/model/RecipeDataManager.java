//package com.sda.recipe_finder.model;
//import java.util.ArrayList;
//
//public class RecipeDataManager {
//        // Fields
//        private ArrayList<String> recipeList = new ArrayList<>();
//
//        // Constructor
//        public RecipeDataManager() {
//            // Default items in the list
//            recipeList.add("Vodka");
//            recipeList.add("Beer");
//            recipeList.add("Water");
//        }
//
//        // Methods
//
//        public void addGroceryItem(String item) {
//
//            if (checkIfValid(item)) {
//                recipeList.add(item);
//            } else {
//                System.out.println("Item is not valid");
//            }
//        }
//
//        public void printGroceryList() {
//            System.out.println("You have: " + recipeList.size() + " items in grocery list");
//            for (int i = 0; i < recipeList.size(); i++) {
//                System.out.println((i + 1) + ". " + recipeList.get(i));
//            }
//
//        }
//
//        public void removeGroceryItem(String item) {
//            int position = findItem(item);
//            if (position >= 0) {
//                recipeList.remove(position);
//                System.out.println(item + " deleted");
//            } else {
//                System.out.println("Item is not in the list");
//            }
//
//
//        }
//
//        public void modifyGroceryItem(int position, String newItem) {
//            if (checkIfValid(newItem)) {
//                if (position >= 0 && position < recipeList.size()) {
//                    recipeList.set(position, newItem);
//                    System.out.println("Grocery item " + recipeList.get(position) + " was modified");
//                } else {
//                    System.out.println("Item number is invalid");
//                }
//            } else {
//                System.out.println("Item name is not valid");
//            }
//        }
//
//        public void deleteAllItems() {
//            recipeList.clear();
//            System.out.println("The list has been cleared");
//        }
//
//        public boolean searchItem(String searchItem) {
//            if (findItem(searchItem) >= 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//}
