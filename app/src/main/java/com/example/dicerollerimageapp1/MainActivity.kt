package com.example.dicerollerimageapp1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { RollDice() }
    }
    private fun RollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val drawableResource = when(diceRoll){
            1->(R.drawable.dice_1)
            2->(R.drawable.dice_2)
            3->(R.drawable.dice_3)
            4->(R.drawable.dice_4)
            5->(R.drawable.dice_5)
            else -> {R.drawable.dice_6}
        }
        imageView.setImageResource(drawableResource)
        imageView.contentDescription = diceRoll.toString()
    }

    private class Dice(val numSide: Int){
        fun roll(): Int{
            return (1..numSide).random()
        }
    }
}