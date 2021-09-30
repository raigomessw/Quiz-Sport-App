package com.example.quiz_sport_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name=findViewById<TextView>(R.id.tv_name)
        val tv_score= findViewById<TextView>(R.id.tv_score)
        val btn_finished= findViewById<Button>(R.id.btn_finished)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text= username

        val totalQuestions= intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)//Sätt value till default 0
        val correctAswer= intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_score.text= "Your Score is $correctAswer out of $totalQuestions"
        btn_finished.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))//Böjar  activit på Main
            finish()
        }

    }
}