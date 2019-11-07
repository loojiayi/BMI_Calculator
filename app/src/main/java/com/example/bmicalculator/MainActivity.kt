package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCal.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }
        val weight = editTextWeight.text.toString().toFloat()

        if(editTextHeight.text.isEmpty()){
            editTextHeight.setError(getString(R.string.input_error))
            return
        }
        val height = editTextWeight.text.toString().toFloat()

        val bmi = weight / height.pow(2)

        textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)

        if(bmi < 18.5) {
            textViewStatus.text =
                String.format("%s %s", getString(R.string.status), getString(R.string.underweight))
            imageViewProfilePic.setImageResource(R.drawable.under)
        }
        else if(bmi < 18.5 && bmi > 24.9) {
            textViewStatus.text =
                String.format("%s %s", getString(R.string.status), getString(R.string.normal))
            imageViewProfilePic.setImageResource(R.drawable.normal)
        }
        else if(bmi > 25) {
            textViewStatus.text =
                String.format("%s %s", getString(R.string.status), getString(R.string.overweight))
            imageViewProfilePic.setImageResource(R.drawable.over)
        }
    }
}
