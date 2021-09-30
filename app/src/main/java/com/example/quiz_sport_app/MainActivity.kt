package com.example.quiz_sport_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN //Ta bort det menu view Up på telefon!

        var hintName = findViewById<TextInputEditText>(R.id.et_name)
        val button = findViewById<Button>(R.id.btn_start)

        //Usado para se o usuario nao colocar o nome!
        button.setOnClickListener {
            if (hintName.text.toString().isEmpty()) { //Para caso a pessoa escrever o nome nao aparecer a menssagem
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this, QuizQuestionActivity::class.java) //Muda a activity
                intent.putExtra(Constants.USER_NAME, hintName.text.toString()) //Activ username
                startActivity(intent) //Comeca a nova activity
                finish()
            }
        }


    }

}