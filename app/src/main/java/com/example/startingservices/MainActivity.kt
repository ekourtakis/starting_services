package com.example.startingservices

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.numberET)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            Log.d("Button", "clicked")
            startService(Intent(this, TimerService::class.java))
        }
    }


}

