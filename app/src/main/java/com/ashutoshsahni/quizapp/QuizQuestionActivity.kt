package com.ashutoshsahni.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar : ProgressBar? = null
    private var tvProgressBar : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

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
        ivImage = findViewById(R.id.iv_image)

        optionOne = findViewById(R.id.tv_optionOne)
        optionTwo = findViewById(R.id.tv_optionTwo)
        optionThree = findViewById(R.id.tv_optionThree)
        optionFour = findViewById(R.id.tv_optionFour)


        val questionList = Constants.getQuestion()
        Log.i("Size of question list is : ", "${questionList.size}")

        for(i in questionList) {
            Log.e("Questions: ", i.question)
        }

        var currentPosition = 1
        val question : Question = questionList[currentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgressBar?.text = "$currentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}