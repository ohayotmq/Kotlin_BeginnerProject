package com.example.homework4

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }
    /**
     * Hàm roll xúc sắc và hiển thị kết quả ra màn hình
     */
    private fun rollDice() {
        // Tạo một object Dice với 6 phần tử hay 6 mặt
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update màn hình khi roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        val toast = Toast.makeText(this, "Dice Rick Rolled!", Toast.LENGTH_SHORT)
        toast.show()
    }
}
// Hàm random xúc sắc
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}