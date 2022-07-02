package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private var userName: EditText? = null
    private var userHeight: EditText? = null
    private var userWeight: EditText? = null
    private var userAge: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            buttonGenerateClick(it)
        }
    }

    private fun buttonGenerateClick(view: View) {
        val textView: TextView = findViewById(R.id.textViewResult)
        textView.text = generateData().toString()
    }

    private fun generateData(): String {
        userName = findViewById(R.id.userName)
        userHeight = findViewById(R.id.userHeight)
        userWeight = findViewById(R.id.userWeight)
        userAge = findViewById(R.id.userAge)

        var height = userHeight?.text.toString().toInt()
        var weight = userWeight?.text.toString().toInt()
        var age = userAge?.text.toString().toInt()
        var name = userName?.text.toString()
        if (height in 0..250 && weight in 0..250 && age in 0..150) {
            var caloriesDCI = weight * 2 + height * 3 + age
            return "Суточная норма калорий для " + name + " Ответ: " + caloriesDCI
        } else {
            return " Данные введены некорректно "
        }
    }
}
