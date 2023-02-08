package com.ashutoshsahni.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionActivity : AppCompatActivity() {

    private var progressBar : ProgressBar? = null
    private var tvProgressBar : TextView? = null
    private var tvQuestion : TextView? = null
    private var tvImage : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        progressBar = findViewById(R.id.progressBar)
        tvProgressBar = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.iv_image)

        optionOne = findViewById(R.id.tv_optionOne)
        optionTwo = findViewById(R.id.tv_optionTwo)
        optionThree = findViewById(R.id.tv_optionThree)
        optionFour = findViewById(R.id.tv_optionFour)


        val questionList = Constants.getQuestion()
        Log.i("Size of question list is : ", "${questionList.size}")
    }
}