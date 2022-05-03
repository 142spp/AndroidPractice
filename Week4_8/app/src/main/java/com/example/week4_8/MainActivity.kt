package com.example.week4_8

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnadd : Button; lateinit var btnsub : Button
    lateinit var btnmul : Button; lateinit var btndiv : Button
    lateinit var btnrem : Button; lateinit var btnchn : Button
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String
    var result : Int? = null
    var cnt  : Int= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "${cnt} 회 계산기"

        edit1 = findViewById<EditText>(R.id.num1)
        edit2 = findViewById<EditText>(R.id.num2)

        btnadd = findViewById<Button>(R.id.btnadd)
        btnsub = findViewById<Button>(R.id.btnsub)
        btnmul = findViewById<Button>(R.id.btnmul)
        btndiv = findViewById<Button>(R.id.btndiv)
        btnrem = findViewById<Button>(R.id.btnrem)
        btnchn = findViewById<Button>(R.id.btnchn)
        textResult = findViewById<TextView>(R.id.TextResult)

        fun change_edit1(){
            try{
                if(result == null) throw Exception()
                edit1.setText(result.toString())
                edit2.setText("")
            } catch (e : Exception){
                textResult.text = "오류"
            }
        }

        fun get_result(operation : (Int,Int)->Int) {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = operation(Integer.parseInt(num1) , Integer.parseInt(num2))
                textResult.text = "계산 결과 : " + result.toString()
                change_edit1()
                title="${++cnt} 회 계산기"
            } catch(e: Exception){
                result = null
                textResult.text = "값을 입력해 주세요"
            }
        }

        btnadd.setOnTouchListener{ view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> get_result{a,b -> a+b}
            }
            false
        }
        btnsub.setOnTouchListener{ view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> get_result{a,b -> a-b}
            }
            false
        }
        btnmul.setOnTouchListener{ view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> get_result{a,b -> a*b}
            }
            false
        }
        btndiv.setOnTouchListener{ view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> get_result{a,b -> a/b}
            }
            false
        }
        btnrem.setOnTouchListener{ view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> get_result{a,b -> a%b}
            }
            false
        }
        btnchn.setOnTouchListener{ view, motionEvent ->
            when(motionEvent.action) {
                MotionEvent.ACTION_DOWN ->
                    try {
                        if (edit1.text.toString().isEmpty() or edit2.text.toString()
                            .isEmpty()) throw Exception()
                    var t_str = edit1.text.toString()
                    edit1.setText(edit2.text.toString())
                    edit2.setText(t_str)
                } catch (e: Exception) {
                    textResult.text = "값을 입력해주세요"
                }
            }
            false
        }
    }
}