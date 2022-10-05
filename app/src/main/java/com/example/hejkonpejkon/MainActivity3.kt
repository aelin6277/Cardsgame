package com.example.hejkonpejkon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    lateinit var buttonEndGame: Button
    lateinit var buttonNewGame: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        buttonEndGame = findViewById<Button>(R.id.buttonEndGame) //initierar en variabel
        buttonNewGame = findViewById(R.id.buttonNewGame)

        buttonEndGame.setOnClickListener() {
            handleButton()
        }
        buttonNewGame.setOnClickListener() {
            handleNewGameButton()
        }

    }

    fun handleButton() {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }

    fun handleNewGameButton (){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

}