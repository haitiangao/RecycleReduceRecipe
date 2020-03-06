package com.example.recyclereducerecipe.model;

public class Recipe {

    private String recipeName;
    private ArrayList<String> recipeIngredients;

    public Recipe(String recipeName, ArrayList<String> recipeIngredients) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}
