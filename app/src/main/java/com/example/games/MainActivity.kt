package com.example.games

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.ClipData.Item
import android.widget.TextView
import android.widget.Toast
import java.nio.file.Files.size
import java.util.Random;



class MainActivity : AppCompatActivity() {

    var player = 1
    var solito = false
    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    var buttons = ArrayList<Int>()
    var sp1 = 0
    var sp2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttons.add(R.id.button)
        buttons.add(R.id.button2)
        buttons.add(R.id.button3)
        buttons.add(R.id.button4)
        buttons.add(R.id.button5)
        buttons.add(R.id.button6)
        buttons.add(R.id.button7)
        buttons.add(R.id.button8)
        buttons.add(R.id.button9)

    }

    fun select(view: View) {
        val selectedButton = view as Button
        var buttonCode = 0
        when (selectedButton.id){
            R.id.button -> buttonCode = 1
            R.id.button2 -> buttonCode = 2
            R.id.button3 -> buttonCode = 3
            R.id.button4 -> buttonCode = 4
            R.id.button5 -> buttonCode = 5
            R.id.button6 -> buttonCode = 6
            R.id.button7 -> buttonCode = 7
            R.id.button8 -> buttonCode = 8
            R.id.button9 -> buttonCode = 9
        }
        gameOn(buttonCode, selectedButton)
        win()
    }

    fun selectAuto(){
        var canBe = false
        var index = 0
        var item = 0
        var buttonCode = 0
        while(!canBe){
            index = (Random()).nextInt(buttons.size)
            item = buttons.get(index)
            when (item){
                R.id.button -> buttonCode = 1
                R.id.button2 -> buttonCode = 2
                R.id.button3 -> buttonCode = 3
                R.id.button4 -> buttonCode = 4
                R.id.button5 -> buttonCode = 5
                R.id.button6 -> buttonCode = 6
                R.id.button7 -> buttonCode = 7
                R.id.button8 -> buttonCode = 8
                R.id.button9 -> buttonCode = 9
            }
            canBe = !p1.contains(buttonCode) && !p2.contains(buttonCode)
        }
        select(findViewById<Button>(item))

    }

    fun gameOn(buttonCode: Int, selectedButton : Button){
        if(player == 1){
            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.color.blue)
            p1.add(buttonCode)
            player = 2
        }else{
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.color.green)
            p2.add(buttonCode)
            player = 1
        }
        selectedButton.isEnabled = false
        if(solito && player == 2){
            selectAuto()
        }
    }

    fun win(){
        var win = 0
        for (i in 1..3){
            if (p1.contains(i) && p1.contains(i+3) && p1.contains(i+6)){
                win = 1
            }
            else if (p2.contains(i) && p2.contains(i+3) && p2.contains(i+6)){
                win = 2
            }
        }
        for (i in 1..9 step 3){
            if (p1.contains(i) && p1.contains(i+1) && p1.contains(i+2)){
                win = 1
            }
            else if (p2.contains(i) && p2.contains(i+1) && p2.contains(i+2)){
                win = 2
            }
        }
        if (p1.contains(1) && p1.contains(5) && p1.contains(9)){
            win = 1
        }
        else if (p2.contains(3) && p2.contains(5) && p2.contains(7)){
            win = 2
        }

        if(win != 0){
            for (button in buttons){
                findViewById<Button>(button).isEnabled = false
            }
            val scorep1 = findViewById(R.id.scoreP1) as TextView
            val scorep2 = findViewById(R.id.scoreP2) as TextView
            Toast.makeText(this, "GANO EL JUGADOR $win", Toast.LENGTH_LONG).show()
            if(win ==1){
                sp1++
            }else{
                sp2++
            }
            scorep1.text = ""+sp1
            scorep2.text = ""+sp2
        }
    }

    fun clean(view : View){
        p1.clear()
        p2.clear()
        for (button in buttons){
            findViewById<Button>(button).setBackgroundResource(R.color.white)
            findViewById<Button>(button).text = ""
            findViewById<Button>(button).isEnabled = true
        }
        player = 1
        solito = false
    }

    fun cleanSolo(view : View){
        p1.clear()
        p2.clear()
        for (button in buttons){
            findViewById<Button>(button).setBackgroundResource(R.color.white)
            findViewById<Button>(button).text = ""
            findViewById<Button>(button).isEnabled = true
        }
        player = 1
        solito = true
    }
}
