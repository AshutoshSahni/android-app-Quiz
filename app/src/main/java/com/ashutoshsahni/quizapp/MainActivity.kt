package com.ashutoshsahni.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName : EditText = findViewById(R.id.et_name)
        val btnStart : Button = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            if (etName.text.isEmpty())
                Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show()
                else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}