package com.example.pamolab.ui.recipe;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.pamolab.databinding.FragmentRecipeBinding;
import com.example.pamolab.model.Meal;
import com.example.pamolab.*;


public class RecipeFragment extends Fragment {

    private FragmentRecipeBinding binding;
    private RecipeViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecipeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(RecipeViewModel.class);

        // Read the meal details from the strings.xml file
        String[] mealArray = getResources().getStringArray(R.array.meal);
        String selectedMeal = mealArray[0]; // Select the first meal in the array
        String[] ingredientsArray = null;
        String[] stepsArray = null;
        if (selectedMeal.equals(mealArray[0])) {
            ingredientsArray = getResources().getStringArray(R.array.meal_ing_avocado_toast);
            stepsArray = getResources().getStringArray(R.array.meal_steps_avocado_toast);
        } else if (selectedMeal.equals(mealArray[1])) {
            ingredientsArray = getResources().getStringArray(R.array.meal_ing_vegetable_stir_fry);
            stepsArray = getResources().getStringArray(R.array.meal_steps_vegetable_stir_fry);
        }

        // Create a new Meal object with the read details
        Meal meal = new Meal(selectedMeal, ingredientsArray, stepsArray);

        viewModel.setMeal(meal);

        binding.textName.setText(viewModel.getMealName());
        binding.textIngredients.setText(viewModel.getIngredientsString());
        binding.textSteps.setText(viewModel.getStepsString());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
