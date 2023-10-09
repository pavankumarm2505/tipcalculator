package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var textView: TextView

    fun calculateResultAndAnother(userNumber: Float, progress: Int): Pair<Float, Float> {
        val result = (userNumber * progress) / 100f
        val another = userNumber + result
        return Pair(result, another)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextNumberSigned)



        val textView4 = findViewById<TextView>(R.id.textView4)
        val textView5 = findViewById<TextView>(R.id.textView5)


        seekBar = findViewById(R.id.seekBar)
        textView = findViewById(R.id.textView1)


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val userInput = editText.text.toString()
                val userNumber = userInput.toFloatOrNull()

                if (userNumber != null) {
                    val (result, another) = calculateResultAndAnother(userNumber, progress)


                    // Update the TextView with the progress
                    textView.text = "$progress%"
                    textView4.text = String.format("%.2f", result)
                    textView5.text = String.format("%.2f", another)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not used in this example, but you could add functionality here if needed.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not used in this example, but you could add functionality here if needed.
            }
        })
    }

}