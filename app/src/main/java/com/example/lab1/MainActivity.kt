package com.example.lab1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var etQuestion: EditText
    private lateinit var rgDifficulty: RadioGroup
    private lateinit var rgType: RadioGroup
    private lateinit var btnOk: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etQuestion = findViewById(R.id.etQuestion)
        rgDifficulty = findViewById(R.id.rgDifficulty)
        rgType = findViewById(R.id.rgType)
        btnOk = findViewById(R.id.btnOk)
        tvResult = findViewById(R.id.tvResult)

        btnOk.setOnClickListener {
            val question = etQuestion.text.toString().trim()
            val selectedDifficultyId = rgDifficulty.checkedRadioButtonId
            val selectedTypeId = rgType.checkedRadioButtonId

            when {
                question.isEmpty() -> showAlert("Please enter a question.")
                selectedDifficultyId == -1 -> showAlert("Please select a difficulty level.")
                selectedTypeId == -1 -> showAlert("Please select a type.")
                else -> {
                    val difficulty = findViewById<RadioButton>(selectedDifficultyId).text
                    val type = findViewById<RadioButton>(selectedTypeId).text

                    val result = "Question: $question\nDifficulty: $difficulty\nType: $type"
                    tvResult.text = result
                }
            }
        }
    }

    private fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Attention")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
