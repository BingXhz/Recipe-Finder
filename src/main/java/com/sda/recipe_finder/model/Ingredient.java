package com.sda.recipe_finder.model;

import java.util.ArrayList;

public class Ingredient {
    private Long dish_id;

    private String category;

    private String dish_name;

    private String ingredients;



    // Fields
    private ArrayList<String> groceryList = new ArrayList<>();

    public void printGroceryList() {
        System.out.println("You have: " + groceryList.size() + " items in grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }

    }
}
