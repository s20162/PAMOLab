package com.example.pamolab.ui.BMI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pamolab.databinding.FragmentBmiBinding

class BmiFragment : Fragment() {
    private var bmiViewModel: BmiViewModel? = null
    private var binding: FragmentBmiBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bmiViewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)
        binding = FragmentBmiBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textViewResult
        val weightEditText = binding!!.editTextWeight
        val heightEditText = binding!!.editTextHeight
        val calculateButton = binding!!.buttonCalculate
        calculateButton.setOnClickListener { v: View? ->
            val weight = weightEditText.text.toString().toInt()
            val height = heightEditText.text.toString().toInt()

            // calculate BMI here
            val bmi = calculateBMI(weight, height)
            val result = String.format("Your BMI is %.1f", bmi)
            textView.text = result

            // store weight and height in view model
            bmiViewModel!!.setWeight(weight)
            bmiViewModel!!.setHeight(height)
        }
        return root
    }

    private fun calculateBMI(weight: Int, height: Int): Double {
        val heightMeters = height / 100.0
        return weight / (heightMeters * heightMeters)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}