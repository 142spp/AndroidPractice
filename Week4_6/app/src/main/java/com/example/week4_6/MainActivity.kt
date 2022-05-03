package com.example.week4_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn1 : Button;
    lateinit var btn2 : Button;
    lateinit var btn3 : Button;
    lateinit var btn4 : Button;
    lateinit var btn5 : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        btn3 = findViewById<Button>(R.id.btn3)
        btn4 = findViewById<Button>(R.id.btn4)
        btn5 = findViewById<Button>(R.id.btn5)

        btn1.visibility = View.VISIBLE
        btn2.visibility = View.INVISIBLE
        btn3.visibility = View.INVISIBLE
        btn4.visibility = View.INVISIBLE
        btn5.visibility = View.INVISIBLE

        btn1.setOnTouchListener { view, motionEvert ->
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.VISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.INVISIBLE
            false
        }
        btn2.setOnTouchListener { view, motionEvert ->
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.VISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.INVISIBLE
            false
        }
        btn3.setOnTouchListener { view, motionEvert ->
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.VISIBLE
            btn5.visibility = View.INVISIBLE
            false
        }
        btn4.setOnTouchListener { view, motionEvert ->
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.VISIBLE
            false
        }
        btn5.setOnTouchListener { view, motionEvert ->
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.INVISIBLE
            false
        }

    }
}