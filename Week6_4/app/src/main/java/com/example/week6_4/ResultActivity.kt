package com.example.week6_4

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnc = findViewById<Button>(R.id.sub_com)
        val btns = findViewById<Button>(R.id.sub_sub)
        val img = findViewById<ImageView>(R.id.image)
        val tv1 = findViewById<TextView>(R.id.sub_1)
        val tv2 = findViewById<TextView>(R.id.sub_2)
        val tv3 = findViewById<TextView>(R.id.sub_3)
        val tv4 = findViewById<TextView>(R.id.sub_4)

        val intent = getIntent()
        val trueintent = Intent(this,TrueActivity::class.java)
        trueintent.putExtras(intent)

        if(intent.hasExtra("name") and intent.hasExtra("age")) {
            tv1.setText(
                "이름:" + intent.getStringExtra("name").toString() + " , 나이:" + intent.getStringExtra("age")
            )
        }
        if(intent.hasExtra("phone")) {
            tv2.setText(intent.getStringExtra("phone").toString())
        }
        if(intent.hasExtra("address")) {
            tv3.setText(intent.getStringExtra("address").toString())
        }
        if(intent.hasExtra("etc")) {
            tv4.setText(intent.getStringExtra("etc").toString())
        }
        if(intent.hasExtra("image")) {
            img.setImageBitmap(intent.getParcelableExtra("image"))
        }
        btnc.setOnClickListener{
            setResult(100,intent)
            startActivity(trueintent)
            finish()
        }
        btns.setOnClickListener{
            setResult(0,intent)
            finish()
        }
    }
}