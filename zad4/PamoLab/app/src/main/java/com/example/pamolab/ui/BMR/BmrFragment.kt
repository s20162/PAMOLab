package com.example.pamolab.ui.BMR

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pamolab.R
import java.text.DecimalFormat

class BmrFragment : Fragment() {
    private var bmrViewModel: BmrViewModel? = null
    private var weightEditText: EditText? = null
    private var heightEditText: EditText? = null
    private var ageEditText: EditText? = null
    private var resultTextView: TextView? = null
    private var calculateButton: Button? = null
    private var radioGroupGender: RadioGroup? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bmrViewModel = ViewModelProvider(this).get(BmrViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bmr, container, false)
        weightEditText = root.findViewById(R.id.edit_text_weight)
        heightEditText = root.findViewById(R.id.edit_text_height)
        ageEditText = root.findViewById(R.id.edit_text_age)
        calculateButton = root.findViewById(R.id.button_calculate_bmr)
        resultTextView = root.findViewById(R.id.text_bmr_result)
        radioGroupGender = root.findViewById(R.id.radio_group_gender)
        calculateButton.setOnClickListener(View.OnClickListener { view: View? ->
            val weight = weightEditText.getText().toString().toDouble()
            val height = heightEditText.getText().toString().toDouble()
            val age = ageEditText.getText().toString().toInt()
            val bmr: Double
            val selectedId = radioGroupGender.getCheckedRadioButtonId()
            bmr = if (selectedId == R.id.radio_button_male) {
                // Benedict-Harris formula for male
                88.362 + 13.397 * weight + 4.799 * height - 5.677 * age
            } else {
                // Benedict-Harris formula for female
                447.593 + 9.247 * weight + 3.098 * height - 4.330 * age
            }
            val df = DecimalFormat("#.##")
            val formattedResult = df.format(bmr)
            resultTextView.setText("Your BMR is: $formattedResult")
        })
        return root
    }
}