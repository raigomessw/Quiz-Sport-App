package com.example.quiz_sport_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener { //onCli till funkar this

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: MutableList<Question>? = null
    private var mSelectedOptionPosition: Int = 0 //Para vericar a pergunta
    private var mCorrectAnswers :Int= 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName= intent.getStringExtra(Constants.USER_NAME)//Activ det activit USER NAME

        val tv_option_One = findViewById<TextView>(R.id.tv_option_One)
        val tv_option_Two = findViewById<TextView>(R.id.tv_option_Two)
        val tv_option_Three = findViewById<TextView>(R.id.tv_option_Three)
        val tv_option_Four = findViewById<TextView>(R.id.tv_option_Four)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tv_option_One.setOnClickListener(this)
        tv_option_Two.setOnClickListener(this)
        tv_option_Three.setOnClickListener(this)
        tv_option_Four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun setQuestion() {

        val progressBar = findViewById<ProgressBar>(R.id.progressBar) //Usado para encontrar o id do progress
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val tv_option_One = findViewById<TextView>(R.id.tv_option_One)
        val tv_option_Two = findViewById<TextView>(R.id.tv_option_Two)
        val tv_option_Three = findViewById<TextView>(R.id.tv_option_Three)
        val tv_option_Four = findViewById<TextView>(R.id.tv_option_Four)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        //Fösta fråga
        val question = mQuestionsList!![mCurrentPosition - 1] //Till byta fråga

        defaultOptionsView()//Köra default color på Button

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text= "!!FINISH!!"
        }else{
            btn_submit.text= "!SUBMIT!"
        }

        progressBar.progress = mCurrentPosition //Mostra o Progresso
        tv_progress.text =
            "$mCurrentPosition" + "/" + progressBar.max //faz com que adiante no progresso

        tv_question.text = question!!.question
        //Mostra a pergunta
        iv_image.setImageResource(question.image) //Visa bilden

        tv_option_One.text = question.optionOne
        tv_option_Two.text = question.optionTwo
        tv_option_Three.text = question.optionThree
        tv_option_Four.text = question.optionFour

    }

    private fun defaultOptionsView() { // Lämna opnition till default
        val options = ArrayList<TextView>()

        val tv_option_One = findViewById<TextView>(R.id.tv_option_One)
        val tv_option_Two = findViewById<TextView>(R.id.tv_option_Two)
        val tv_option_three = findViewById<TextView>(R.id.tv_option_Three)
        val tv_option_Four = findViewById<TextView>(R.id.tv_option_Four)
        options.add(0, tv_option_One)
        options.add(1, tv_option_Two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_Four)

        for (option in options) { //Byta borda text till deffault color
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

        }
    }

    override fun onClick(v: View?) { //Fun till alla option on selected
        val tv_option_One = findViewById<TextView>(R.id.tv_option_One)
        val tv_option_Two = findViewById<TextView>(R.id.tv_option_Two)
        val tv_option_Three = findViewById<TextView>(R.id.tv_option_Three)
        val tv_option_Four = findViewById<TextView>(R.id.tv_option_Four)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        when (v?.id) {
            R.id.tv_option_One -> {
                selectedOptionView(tv_option_One, 1)
            }
            R.id.tv_option_Two -> {
                selectedOptionView(tv_option_Two, 2)
            }
            R.id.tv_option_Three -> {
                selectedOptionView(tv_option_Three, 3)
            }
            R.id.tv_option_Four -> {
                selectedOptionView(tv_option_Four, 4)
            }
            R.id.btn_submit -> { //Position defaul är 0
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++ //Byta position av  fråga

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> { //Gör att byta till nästa fråga
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)// Gör att man höpa över sen till avluting program
                            intent.putExtra(Constants.USER_NAME, mUserName)//Sätt ny info
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)//"!!" Funka till forcera Uppackning
                            startActivity(intent)
                            finish()
                        }

                    }
                }else{ //Kolla vilken answer a rätt och sen byta color
                    val question= mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text= "FINISH"
                    }else{
                        btn_submit.text="Go to next question!"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int) {
        val tv_option_One = findViewById<TextView>(R.id.tv_option_One)
        val tv_option_Two = findViewById<TextView>(R.id.tv_option_Two)
        val tv_option_Three = findViewById<TextView>(R.id.tv_option_Three)
        val tv_option_Four = findViewById<TextView>(R.id.tv_option_Four)
        when (answer) {
            1 -> {
                tv_option_One.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_Two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_Three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_Four.background = ContextCompat.getDrawable(this, drawableView)
            }

        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

    }

}