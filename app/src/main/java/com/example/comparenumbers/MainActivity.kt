package com.example.comparenumbers

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
//    val btnleft: Button = findViewById(R.id.btnLeft)
//    val btnright: Button = findViewById(R.id.btnRight)
//    val layout: androidx.constraintlayout.widget.ConstraintLayout = findViewById(R.id.zzz)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout: androidx.constraintlayout.widget.ConstraintLayout = findViewById(R.id.zzz)
        val btnleft: Button = findViewById(R.id.btnLeft)
        val btnright: Button = findViewById(R.id.btnRight)
        btnleft.setOnClickListener(){
            checkAnswer(isleftButtonSelected = true)
            assignNumberstoButtons()
        }
        btnright.setOnClickListener(){
            checkAnswer(isleftButtonSelected = false)
            assignNumberstoButtons()
        }

    }

    private fun checkAnswer(isleftButtonSelected:Boolean) {
        val layout: androidx.constraintlayout.widget.ConstraintLayout = findViewById(R.id.zzz)
        val btnleft: Button = findViewById(R.id.btnLeft)
        val btnright: Button = findViewById(R.id.btnRight)
        val left:Int = btnleft.text.toString().toInt()
        val right:Int = btnright.text.toString().toInt()
        val ans = if(isleftButtonSelected)left>right else right>left
        if(ans){
            layout.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "correct answer", Toast.LENGTH_SHORT).show()
        }
        else{
            layout.setBackgroundColor(Color.RED)
            Toast.makeText(this, "wrong answer", Toast.LENGTH_SHORT).show()
        }
    }


    private fun assignNumberstoButtons() {
        val leftnum = Random.nextInt(0,10)
        var rightnum = leftnum
        while(rightnum==leftnum){
            rightnum = Random.nextInt(0,10)
        }
        val btnleft: Button = findViewById(R.id.btnLeft)
        val btnright: Button = findViewById(R.id.btnRight)
        btnleft.text = leftnum.toString()
        btnright.text = rightnum.toString()

    }
}