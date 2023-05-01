package com.example.pamolab.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pamolab.R
import com.example.pamolab.databinding.FragmentRecipeBinding
import com.example.pamolab.model.Meal

class RecipeFragment : Fragment() {
    private var binding: FragmentRecipeBinding? = null
    private var viewModel: RecipeViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(RecipeViewModel::class.java)

        // Read the meal details from the strings.xml file
        val mealArray = resources.getStringArray(R.array.meal)
        val selectedMeal = mealArray[0] // Select the first meal in the array
        var ingredientsArray: Array<String?>? = null
        var stepsArray: Array<String?>? = null
        if (selectedMeal == mealArray[0]) {
            ingredientsArray = resources.getStringArray(R.array.meal_ing_avocado_toast)
            stepsArray = resources.getStringArray(R.array.meal_steps_avocado_toast)
        } else if (selectedMeal == mealArray[1]) {
            ingredientsArray = resources.getStringArray(R.array.meal_ing_vegetable_stir_fry)
            stepsArray = resources.getStringArray(R.array.meal_steps_vegetable_stir_fry)
        }

        // Create a new Meal object with the read details
        val meal = Meal(selectedMeal, ingredientsArray, stepsArray)
        viewModel!!.setMeal(meal)
        binding!!.textName.text = viewModel.getMealName()
        binding!!.textIngredients.text = viewModel.getIngredientsString()
        binding!!.textSteps.text = viewModel.getStepsString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}