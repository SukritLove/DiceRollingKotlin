package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.rollDice)
        val diceBlock1: ImageView = findViewById(R.id.dice1)

        val diceBlock2: ImageView = findViewById(R.id.dice2)

        rollBtn.setOnClickListener {
            val toast = Toast.makeText(this, "Rolling the Dice!!!", Toast.LENGTH_SHORT)
            toast.show()

            rollDice(diceBlock1)
            rollDice(diceBlock2)

        }


    }


    private fun rollDice(result: ImageView) {
        val dice = Dice(6)

        val diceRoll = dice.roll()
        val drResult = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        result.setImageResource(drResult)
        result.contentDescription = diceRoll.toString()

        // Condition 1 : Separate variable with Logic
        /*val diceRoll = dice.roll()
        when(diceRoll){
            1 -> result.setImageResource(R.drawable.dice_1)
            2 -> result.setImageResource(R.drawable.dice_2)
            3 -> result.setImageResource(R.drawable.dice_3)
            4 -> result.setImageResource(R.drawable.dice_4)
            5 -> result.setImageResource(R.drawable.dice_5)
            6 -> result.setImageResource(R.drawable.dice_6)
        }*/

        // Condition 2 : Inline
        /*when (dice.roll()) {
            1 -> result.setImageResource(R.drawable.dice_1)
            2 -> result.setImageResource(R.drawable.dice_2)
            3 -> result.setImageResource(R.drawable.dice_3)
            4 -> result.setImageResource(R.drawable.dice_4)
            5 -> result.setImageResource(R.drawable.dice_5)
            6 -> result.setImageResource(R.drawable.dice_6)
        }*/


    }

    class Dice(private var numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

}