package com.example.hejkonpejkon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var buttonStart : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart = findViewById<Button>(R.id.buttonStart)

        buttonStart.setOnClickListener {
            handleButtonPress()
        }
    }

    fun handleButtonPress() {
        val intent = Intent(this, MainActivity2::class.java)

        startActivity(intent)
    }
}