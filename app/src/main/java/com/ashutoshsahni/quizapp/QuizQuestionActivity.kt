package com.ashutoshsahni.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
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

    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

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
        defaultOptionsView()
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
                if(mSelectedOption == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> { setQuestion() }
                        else -> {
                            var intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_QUESTIONS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)

                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList!!.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOption)
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    else
                        mCorrectAnswers++

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size)
                        btnSubmit?.text = "FINISH"
                    else
                        btnSubmit?.text = "GO TO NEXT QUESTION"

                    mSelectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView : Int) {
        when(answer) {
            1 -> optionOne?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )

            2 -> optionTwo?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )

            3 -> optionThree?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )

            4 -> optionFour?.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
        }
    }
}