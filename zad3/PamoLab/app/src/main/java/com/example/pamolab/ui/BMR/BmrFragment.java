package com.example.pamolab.ui.BMR;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pamolab.R;

import java.text.DecimalFormat;

public class BmrFragment extends Fragment {

    private BmrViewModel bmrViewModel;
    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private TextView resultTextView;
    private Button calculateButton;
    private RadioGroup radioGroupGender;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bmrViewModel =
                new ViewModelProvider(this).get(BmrViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bmr, container, false);

        weightEditText = root.findViewById(R.id.edit_text_weight);
        heightEditText = root.findViewById(R.id.edit_text_height);
        ageEditText = root.findViewById(R.id.edit_text_age);
        calculateButton = root.findViewById(R.id.button_calculate_bmr);
        resultTextView = root.findViewById(R.id.text_bmr_result);
        radioGroupGender = root.findViewById(R.id.radio_group_gender);

        calculateButton.setOnClickListener(view -> {
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString());
            int age = Integer.parseInt(ageEditText.getText().toString());
            double bmr;

            int selectedId = radioGroupGender.getCheckedRadioButtonId();
            if (selectedId == R.id.radio_button_male) {
                // Benedict-Harris formula for male
                bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
            } else {
                // Benedict-Harris formula for female
                bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
            }

            DecimalFormat df = new DecimalFormat("#.##");
            String formattedResult = df.format(bmr);

            resultTextView.setText("Your BMR is: " + formattedResult);
        });

        return root;
    }
}
