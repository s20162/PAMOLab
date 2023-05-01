package com.example.pamolab.ui.quiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    // Get current score
    var score = 0
        private set

    fun incrementScore() {
        score++
    }
}