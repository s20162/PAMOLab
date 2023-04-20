package com.example.pamolab.ui.quiz;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    private int score;

    public QuizViewModel() {

        score = 0;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        // Get current score
        return score;
    }
}
