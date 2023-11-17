package com.example.converter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var convertButton: Button
    private lateinit var conversionTypeRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        resultTextView = findViewById(R.id.resultTextView)
        convertButton = findViewById(R.id.convertButton)
        conversionTypeRadioGroup = findViewById(R.id.conversionTypeRadioGroup)

        convertButton.setOnClickListener {
            convertValue()
        }
    }

    private fun convertValue() {
        val inputValueStr = inputEditText.text.toString().trim()

        if (inputValueStr.isEmpty()) {
            resultTextView.text = "Пожалуйста, введите значение"
            return
        }

        val inputValue = inputValueStr.toDouble()

        val selectedRadioButtonId = conversionTypeRadioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)

        when (selectedRadioButton?.id) {
            R.id.celsiusToFahrenheitRadioButton -> {
                val result = convertCelsiusToFahrenheit(inputValue)
                resultTextView.text = getString(R.string.result_format, result)
            }
            R.id.metersToKilometersRadioButton -> {
                val result = convertMetersToKilometers(inputValue)
                resultTextView.text = getString(R.string.result_format, result)
            }
            else -> {
                resultTextView.text = "Пожалуйста, выберите тип конвертации"
            }
        }
    }

    private fun convertCelsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }

    private fun convertMetersToKilometers(meters: Double): Double {
        return meters / 1000
    }
}
