package com.example.basicquizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvResult: TextView  = findViewById(R.id.tv_result)
        val tvScore : TextView = findViewById(R.id.tv_score)
        val finishBtn: Button = findViewById(R.id.finishBtn)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions =  intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = "You scored ${correctAnswers} out of ${totalQuestions}"

        finishBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}