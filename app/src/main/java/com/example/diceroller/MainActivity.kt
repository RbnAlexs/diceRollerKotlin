package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    //iniciando variables tardiamente con lateinit (sólo con clases que no acepten null, como ImageView)
    lateinit var diceImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter:Int = 1
        var rollButton:Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            Toast.makeText(this, "Estas en el click numero: "+ counter.toString(), Toast.LENGTH_SHORT).show()
            rollDice()
            counter++
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        //val resultText: TextView = findViewById(R.id.result_text)
        //resultText.text = "Dice Rolled!"
        var randomInt = Random().nextInt(6)+1
        //resultText.text = randomInt.toString()
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}
