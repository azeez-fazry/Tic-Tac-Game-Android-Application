package com.example.tictactoygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view:View){

        var buSelect:Button = view as Button
        var cellId = 0
        when(buSelect.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
//        Toast.makeText(this, "ID: "+cellId, Toast.LENGTH_LONG).show()
        PlayGame(cellId,buSelect)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun PlayGame(cellId:Int, buSelect:Button){

        if(activePlayer==1){
            buSelect.text="X"
            buSelect.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            activePlayer = 2
            AutoPlay()
        }else{
            buSelect.text="0"
            buSelect.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 1
        }
        buSelect.isEnabled = false
        FindWiner()
    }

    fun FindWiner(){

        var winer = -1

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer = 2
        }

        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer = 2
        }

        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer = 2
        }

        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer = 2
        }

        if(winer != -1){
            if(winer == 1){
                Toast.makeText(this, "Winer is Player 1", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Winer is Player 2", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun AutoPlay(){
        var emptyCell = ArrayList<Int>()
        for(cellId in 0..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCell.add(cellId)
            }
        }
        val r = Random()
        val randomIndex = r.nextInt(emptyCell.size - 0) + 0
        val cellId = emptyCell[randomIndex]

        var buSelect:Button?
        when(cellId){
            1-> buSelect = bu1
            2-> buSelect = bu2
            3-> buSelect = bu3
            4-> buSelect = bu4
            5-> buSelect = bu5
            6-> buSelect = bu6
            7-> buSelect = bu7
            8-> buSelect = bu8
            9-> buSelect = bu9
            else-> buSelect = bu1
        }
        PlayGame(cellId,buSelect)
    }
}
