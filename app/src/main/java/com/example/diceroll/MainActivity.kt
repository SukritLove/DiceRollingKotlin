package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.rollDice)
        val resultText: TextView = findViewById(R.id.diceNumber1)
        val resultText2: TextView = findViewById(R.id.diceNumber2)

        rollBtn.setOnClickListener {
            val toast = Toast.makeText(this, "Rolling the Dice!!!", Toast.LENGTH_SHORT)
            toast.show()

            rollDice(resultText)
            rollDice(resultText2)
        }


    }

    private fun rollDice(result : TextView) {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        result.text = diceRoll.toString()
    }

    class Dice(private var numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}