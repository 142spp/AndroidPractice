package com.example.week4_4

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnadd : Button; lateinit var btnsub : Button
    lateinit var btnmul : Button; lateinit var btndiv : Button
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String
    var result : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"

        edit1 = findViewById<EditText>(R.id.num1)
        edit2 = findViewById<EditText>(R.id.num2)

        btnadd = findViewById<Button>(R.id.btnadd)
        btnsub = findViewById<Button>(R.id.btnsub)
        btnmul = findViewById<Button>(R.id.btnmul)
        btndiv = findViewById<Button>(R.id.btndiv)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnadd.setOnTouchListener{ view, motionEvent ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
            } catch(e: Exception){
                textResult.text = "값을 입력해 주세요"
            }
            false
        }
        btnsub.setOnTouchListener{ view, motionEvent ->
            try{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            } catch(e: Exception){
                textResult.text = "값을 입력해 주세요"
            }
            false
        }
        btnmul.setOnTouchListener{ view, motionEvent ->
            try{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            } catch(e: Exception){
                textResult.text = "값을 입력해 주세요"
            }
            false
        }
        btndiv.setOnTouchListener{ view, motionEvent ->
            try{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            } catch(e: Exception){
                textResult.text = "값을 입력해 주세요"
            }
            false
        }
    }
}