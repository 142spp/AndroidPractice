package com.example.week4_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var img : ImageView
    lateinit var btnl : Button; lateinit var btnr : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById<ImageView>(R.id.img)
        btnl = findViewById<Button>(R.id.btnleft)
        btnr = findViewById<Button>(R.id.btnright)

        var current : Int = 0
        btnl.setOnTouchListener{view, motionEvent ->
            when(--current){
                -1 -> current =11
                0-> img.setImageResource(R.drawable.a)
                1-> img.setImageResource(R.drawable.b)
                2-> img.setImageResource(R.drawable.c)
                3-> img.setImageResource(R.drawable.d)
                4-> img.setImageResource(R.drawable.e)
                5-> img.setImageResource(R.drawable.f)
                6-> img.setImageResource(R.drawable.g)
                7-> img.setImageResource(R.drawable.h)
                8-> img.setImageResource(R.drawable.i)
                9-> img.setImageResource(R.drawable.j)
                10-> img.setImageResource(R.drawable.k)
            }
            false
        }
        btnr.setOnTouchListener{view, motionEvent ->
            when(++current){
                0-> img.setImageResource(R.drawable.a)
                1-> img.setImageResource(R.drawable.b)
                2-> img.setImageResource(R.drawable.c)
                3-> img.setImageResource(R.drawable.d)
                4-> img.setImageResource(R.drawable.e)
                5-> img.setImageResource(R.drawable.f)
                6-> img.setImageResource(R.drawable.g)
                7-> img.setImageResource(R.drawable.h)
                8-> img.setImageResource(R.drawable.i)
                9-> img.setImageResource(R.drawable.j)
                10-> img.setImageResource(R.drawable.k)
                11-> current =-1
            }
            false
        }
    }
}