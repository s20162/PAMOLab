package com.example.pamolab.model;

public class Meal {
    private String name;
    private String[] ingredients;
    private String[] steps;

    public Meal(String name, String[] ingredients, String[] instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = instructions;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getSteps() {
        return steps;
    }
}
