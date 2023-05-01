package com.example.pamolab.ui.recipe

import androidx.lifecycle.ViewModel
import com.example.pamolab.model.Meal

class RecipeViewModel : ViewModel() {
    private var meal: Meal? = null
    fun setMeal(meal: Meal?) {
        this.meal = meal
    }

    val mealName: String?
        get() = meal.getName()
    val ingredientsString: String
        get() {
            val sb = StringBuilder()
            for (ingredient in meal.getIngredients()) {
                sb.append(ingredient).append("\n")
            }
            return sb.toString()
        }
    val stepsString: String
        get() {
            val sb = StringBuilder()
            var i = 1
            for (step in meal.getSteps()) {
                sb.append(i++).append(". ").append(step).append("\n")
            }
            return sb.toString()
        }
}