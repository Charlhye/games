package com.example.memorama

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.games.MainActivity
import com.example.games.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun selectGame(view: View){
        if(view.id == R.id.tic){
            val ticIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("name", "Tic Tac Toe")
            }
            startActivity(ticIntent)
        }else{
            val ticIntent = Intent(this, MemoramaActivity::class.java).apply {
                putExtra("name", "Memorama")
            }
            startActivity(ticIntent)
        }
    }
}
