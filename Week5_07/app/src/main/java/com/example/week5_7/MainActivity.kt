package com.example.week5_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    lateinit var btn1 : Button ; lateinit var btn2 : Button;
    lateinit var btn3 : Button ; lateinit var btn4 : Button;
    lateinit var btn5 : Button ; lateinit var btn6 : Button;
    lateinit var btn7 : Button ; lateinit var btn8 : Button;
    lateinit var btn9 : Button ; lateinit var btn0 : Button;
    lateinit var btnst : Button; lateinit var btnsh : Button;
    lateinit var edit : EditText; lateinit var btnsub : ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "전화기"
        btn1 = findViewById<Button>(R.id.button1)
        btn2 = findViewById<Button>(R.id.button2)
        btn3 = findViewById<Button>(R.id.button3)
        btn4 = findViewById<Button>(R.id.button4)
        btn5 = findViewById<Button>(R.id.button5)
        btn6 = findViewById<Button>(R.id.button6)
        btn7 = findViewById<Button>(R.id.button7)
        btn8 = findViewById<Button>(R.id.button8)
        btn9 = findViewById<Button>(R.id.button9)
        btnst = findViewById<Button>(R.id.buttonstar)
        btnsh = findViewById<Button>(R.id.buttonsharp)
        btn0 = findViewById<Button>(R.id.button0)
        btnsub = findViewById<ImageButton>(R.id.buttonsub)

        edit = findViewById<EditText>(R.id.editphone)

        fun add_num( num : String){
            try {
                var str = edit.text.toString()
                if (str.length == 3 || (str.length - 3) % 5 == 0) {
                    str += "-"
                }
                edit.setText(str + num)
            } catch(e :Exception){

            }
        }
        fun sub_num(){
            try {
                var str = edit.text.toString()
                if (str.get(str.length - 2).equals('-')) str = str.substring(0, str.length - 1)
                edit.setText(str.substring(0, str.length - 1))
            }catch (e:Exception){
                edit.setText("")
            }
        }
        btn1.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("1")
            false
        }
        btn2.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("2")
            false
        }
        btn3.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("3")
            false
        }
        btn4.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("4")
            false
        }
        btn5.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("5")
            false
        }
        btn6.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("6")
            false
        }
        btn7.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("7")
            false
        }
        btn8.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("8")
            false
        }
        btn9.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("9")
            false
        }
        btn0.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
                add_num("0")
            false
        }
        btnst.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("*")
            false
        }
        btnsh.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            add_num("#")
            false
        }
        btnsub.setOnTouchListener{view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN)
            sub_num()
            false
        }
    }
}