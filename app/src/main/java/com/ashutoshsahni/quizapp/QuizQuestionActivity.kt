package com.ashutoshsahni.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOption : Int = 0
    private var mCurrentPosition : Int = 1

    private var progressBar : ProgressBar? = null
    private var tvProgressBar : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null

    private var btnSubmit : Button? = null

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

        btnSubmit = findViewById(R.id.btnSubmit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestion()
        setQuestion()
    }

    private fun defaultOptionsView() {
        val optionList = ArrayList<TextView>()

        optionOne?.let { optionList.add(0, it) }
        optionTwo?.let { optionList.add(1, it) }
        optionThree?.let { optionList.add(2, it) }
        optionFour?.let {
            optionList.add(3, it)
        }

        for (option in optionList) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border_bg
            )
        }

    }

    // for selected option style
    private fun selectedOptionView(tv : TextView, selectedOption: Int) {
        defaultOptionsView()

        mSelectedOption = selectedOption
        tv.setTextColor(Color.parseColor("#363A43" ))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun setQuestion() {
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size)
            btnSubmit?.text = "FINISH"
        else
            btnSubmit?.text = "SUBMIT"
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_optionOne -> optionOne?.let {
                selectedOptionView(it, 1)
            }

            R.id.tv_optionTwo -> optionTwo?.let {
                selectedOptionView(it, 2)
            }

            R.id.tv_optionThree -> optionThree?.let {
                selectedOptionView(it, 2)
            }

            R.id.tv_optionFour -> optionFour?.let {
                selectedOptionView(it, 4)
            }

            R.id.btnSubmit -> {
                // TODO: need to work on submit button
            }
        }
    }
}