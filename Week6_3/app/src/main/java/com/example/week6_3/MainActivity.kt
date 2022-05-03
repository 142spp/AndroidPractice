package com.example.week6_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        val et1 = findViewById<EditText>(R.id.et_1)
        val et2 = findViewById<EditText>(R.id.et_2)
        val et3 = findViewById<EditText>(R.id.et_3)
        val et4 = findViewById<EditText>(R.id.et_4)
        val et5 = findViewById<EditText>(R.id.et_5)

        btn.setOnClickListener{
            val intent = Intent(this,SubActivity::class.java)
            if(et1.text.isNotEmpty())
                intent.putExtra("name",et1.text.toString())
            if(et2.text.isNotEmpty())
                intent.putExtra("age",et2.text.toString())
            if(et3.text.isNotEmpty())
                intent.putExtra("phone",et3.text.toString())
            if(et4.text.isNotEmpty())
                intent.putExtra("address",et4.text.toString())
            if(et5.text.isNotEmpty())
                intent.putExtra("etc",et5.text.toString())
            startActivity(intent)
            et1.text.clear()
            et2.text.clear()
            et3.text.clear()
            et4.text.clear()
            et5.text.clear()
        }
    }
}