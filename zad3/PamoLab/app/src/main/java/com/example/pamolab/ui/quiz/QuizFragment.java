package com.example.pamolab.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.pamolab.*;

public class QuizFragment extends Fragment {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private String[] questions;
    private String[][] options;
    private String[] correctAnswers;
    private int currentQuestionIndex;
    private QuizViewModel quiz = new QuizViewModel();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        // Retrieve quiz questions, options, and correct answers from resources
        questions = getResources().getStringArray(R.array.quiz_questions);
        options = new String[questions.length][];
        for (int i = 0; i < questions.length; i++) {
            options[i] = getResources().getStringArray(R.array.quiz_all_options);
        }
        correctAnswers = getResources().getStringArray(R.array.quiz_answers);

        // Initialize UI components
        questionTextView = view.findViewById(R.id.questionTextView);
        optionsRadioGroup = view.findViewById(R.id.optionsRadioGroup);
        submitButton = view.findViewById(R.id.submitButton);

        // Set up submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        // Display first quiz question
        currentQuestionIndex = 0;
        displayQuestion();

        return view;
    }

    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        optionsRadioGroup.removeAllViews();
        for (String option : options[currentQuestionIndex]) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(option);
            optionsRadioGroup.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = getView().findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            String correctAnswer = correctAnswers[currentQuestionIndex];
            if (selectedAnswer.equals(correctAnswer)) {
                quiz.incrementScore();
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                // Show quiz result
                String resultMessage = getString(R.string.quiz_result, quiz.getScore(), questions.length);
                Toast.makeText(getContext(), resultMessage, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
