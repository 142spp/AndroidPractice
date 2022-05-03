package com.example.week6_4

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TrueActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_true)

        val img = findViewById<ImageView>(R.id.true_image)
        val te1 = findViewById<TextView>(R.id.te_1)
        val te2 = findViewById<TextView>(R.id.te_2)
        val te3 = findViewById<TextView>(R.id.te_3)
        val te4 = findViewById<TextView>(R.id.te_4)
        val te5 = findViewById<TextView>(R.id.te_5)

        val intent = getIntent()
        if(intent.hasExtra("name")) {
            te1.setText(intent.getStringExtra("name").toString())
        }
        if(intent.hasExtra("age")) {
            te2.setText(intent.getStringExtra("age").toString())
        }
        if(intent.hasExtra("phone")) {
            te3.setText(intent.getStringExtra("phone").toString())
        }
        if(intent.hasExtra("address")) {
            te4.setText(intent.getStringExtra("address").toString())
        }
        if(intent.hasExtra("etc")){
            te5.setText(intent.getStringExtra("etc").toString())
        }
        if(intent.hasExtra("image")) {
            img.setImageBitmap(intent.getParcelableExtra("image"))
        }

        Toast.makeText(this,"완료되었습니다.",Toast.LENGTH_SHORT).show()
    }
}