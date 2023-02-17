package com.ashutoshsahni.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = findViewById<TextView>(R.id.tv_username)
        val scoreText = findViewById<TextView>(R.id.tv_score_text)
        val btnFinish = findViewById<Button>(R.id.btnFinish)

        username.text = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_QUESTIONS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        scoreText.text = "You scored $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}