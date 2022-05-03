package com.example.week6_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val btns = findViewById<Button>(R.id.sub_btn)
        val tv1 = findViewById<TextView>(R.id.sub_1)
        val tv2 = findViewById<TextView>(R.id.sub_2)
        val tv3 = findViewById<TextView>(R.id.sub_3)
        val tv4 = findViewById<TextView>(R.id.sub_4)

        val intent = getIntent()
        if(intent.hasExtra("name") and intent.hasExtra("age"))
            tv1.setText(intent.getStringExtra("name").toString() + " , " + intent.getStringExtra("age"))

        if(intent.hasExtra("phone"))
            tv2.setText(intent.getStringExtra("phone").toString())

        if(intent.hasExtra("address"))
            tv3.setText(intent.getStringExtra("address").toString())

        if(intent.hasExtra("etc"))
            tv4.setText(intent.getStringExtra("etc").toString())

        btns.setOnClickListener{
            finish()
        }
    }
}