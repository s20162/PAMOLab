package com.example.pamolab.ui.BMI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pamolab.databinding.FragmentBmiBinding;


public class BmiFragment extends Fragment {

    private BmiViewModel bmiViewModel;
    private FragmentBmiBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        bmiViewModel = new ViewModelProvider(requireActivity()).get(BmiViewModel.class);

        binding = FragmentBmiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textViewResult;
        final EditText weightEditText = binding.editTextWeight;
        final EditText heightEditText = binding.editTextHeight;
        final Button calculateButton = binding.buttonCalculate;


        calculateButton.setOnClickListener(v -> {
            int weight = Integer.parseInt(weightEditText.getText().toString());
            int height = Integer.parseInt(heightEditText.getText().toString());

            // calculate BMI here
            double bmi = calculateBMI(weight, height);

            String result = String.format("Your BMI is %.1f", bmi);
            textView.setText(result);

            // store weight and height in view model
            bmiViewModel.setWeight(weight);
            bmiViewModel.setHeight(height);
        });

        return root;
    }

    private double calculateBMI(int weight, int height) {
        double heightMeters = height / 100.0;
        return weight / (heightMeters * heightMeters);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
