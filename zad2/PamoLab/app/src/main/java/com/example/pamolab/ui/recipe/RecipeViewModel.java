package com.example.pamolab.ui.recipe;

import androidx.lifecycle.ViewModel;

import com.example.pamolab.model.Meal;

public class RecipeViewModel extends ViewModel {
    private Meal meal;

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getMealName() {
        return meal.getName();
    }

    public String getIngredientsString() {
        StringBuilder sb = new StringBuilder();
        for (String ingredient : meal.getIngredients()) {
            sb.append(ingredient).append("\n");
        }
        return sb.toString();
    }

    public String getStepsString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (String step : meal.getSteps()) {
            sb.append(i++).append(". ").append(step).append("\n");
        }
        return sb.toString();
    }
}
