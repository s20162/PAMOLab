package com.example.pamolab.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.pamolab.R

class QuizFragment : Fragment() {
    private var questionTextView: TextView? = null
    private var optionsRadioGroup: RadioGroup? = null
    private var submitButton: Button? = null
    private var questions: Array<String>
    private var options: Array<Array<String>>
    private var correctAnswers: Array<String>
    private var currentQuestionIndex = 0
    private val quiz = QuizViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        // Retrieve quiz questions, options, and correct answers from resources
        questions = resources.getStringArray(R.array.quiz_questions)
        options = arrayOfNulls(questions.size)
        for (i in questions.indices) {
            options[i] = resources.getStringArray(R.array.quiz_all_options)
        }
        correctAnswers = resources.getStringArray(R.array.quiz_answers)

        // Initialize UI components
        questionTextView = view.findViewById(R.id.questionTextView)
        optionsRadioGroup = view.findViewById(R.id.optionsRadioGroup)
        submitButton = view.findViewById(R.id.submitButton)

        // Set up submit button click listener
        submitButton.setOnClickListener(View.OnClickListener { checkAnswer() })

        // Display first quiz question
        currentQuestionIndex = 0
        displayQuestion()
        return view
    }

    private fun displayQuestion() {
        questionTextView!!.text = questions[currentQuestionIndex]
        optionsRadioGroup!!.removeAllViews()
        for (option in options[currentQuestionIndex]) {
            val radioButton = RadioButton(context)
            radioButton.text = option
            optionsRadioGroup!!.addView(radioButton)
        }
    }

    private fun checkAnswer() {
        val selectedRadioButtonId = optionsRadioGroup!!.checkedRadioButtonId
        if (selectedRadioButtonId != -1) {
            val selectedRadioButton = view!!.findViewById<RadioButton>(selectedRadioButtonId)
            val selectedAnswer = selectedRadioButton.text.toString()
            val correctAnswer = correctAnswers[currentQuestionIndex]
            if (selectedAnswer == correctAnswer) {
                quiz.incrementScore()
            }
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
            } else {
                // Show quiz result
                val resultMessage = getString(R.string.quiz_result, quiz.score, questions.size)
                Toast.makeText(context, resultMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}