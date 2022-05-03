package com.example.week6_5

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var intent = getIntent()

        val et1 = findViewById<TextView>(R.id.sname)
        val et2 = findViewById<TextView>(R.id.sname_eng)
        val et3 = findViewById<TextView>(R.id.sphone)
        val et4 = findViewById<TextView>(R.id.semail)
        val et5 = findViewById<TextView>(R.id.saddress)

        val ets1 = findViewById<EditText>(R.id.ets_1)
        val ets2 = findViewById<EditText>(R.id.ets_2)
        val ets3 = findViewById<EditText>(R.id.ets_3)
        val ets4 = findViewById<EditText>(R.id.ets_4)
        val btn = findViewById<Button>(R.id.btn_sub)

        if(intent.hasExtra("et1"))
            et1.setText(intent.getStringExtra("et1"))
        if(intent.hasExtra("et2"))
            et2.setText(intent.getStringExtra("et2"))
        if(intent.hasExtra("et3"))
            et3.setText(intent.getStringExtra("et3"))
        if(intent.hasExtra("et4"))
            et4.setText(intent.getStringExtra("et4"))
        if(intent.hasExtra("et5"))
            et5.setText(intent.getStringExtra("et5"))

        if(intent.hasExtra("str1"))
            ets1.setText(intent.getStringExtra("str1"))
        if(intent.hasExtra("str2"))
            ets2.setText(intent.getStringExtra("str2"))
        if(intent.hasExtra("str3"))
            ets3.setText(intent.getStringExtra("str3"))
        if(intent.hasExtra("str4"))
            ets4.setText(intent.getStringExtra("str4"))

        btn.setOnClickListener{
            if(ets1.text.isNotEmpty()){
                intent.putExtra("ets1",ets1.text.toString())
            }
            if(ets2.text.isNotEmpty()){
                intent.putExtra("ets2",ets2.text.toString())
            }
            if(ets3.text.isNotEmpty()){
                intent.putExtra("ets3",ets3.text.toString())
            }
            if(ets4.text.isNotEmpty()){
                intent.putExtra("ets4",ets4.text.toString())
            }
            setResult(Activity.RESULT_OK,intent);
            finish()
        }

    }
}