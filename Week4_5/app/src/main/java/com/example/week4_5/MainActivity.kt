package com.example.week4_5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var back : LinearLayout
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        back=findViewById<LinearLayout>(R.id.back)
        btn=findViewById<Button>(R.id.btn)
        var color : Int = 0
        btn.setOnTouchListener{ view, motionEvent ->
            when(color){
                0 -> back.setBackgroundColor(Color.parseColor("#FF0000"))
                1 -> back.setBackgroundColor(Color.parseColor("#00FF00"))
                2 -> {back.setBackgroundColor(Color.parseColor("#0000FF")); color = -1}
            }
            color ++
            false
        }
    }
}