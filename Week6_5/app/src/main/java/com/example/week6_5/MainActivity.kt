package com.example.week6_5

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView


val GALLERY : Int = 1
val Text : Int = 2
lateinit var bitmap : Bitmap

var str1 : String = "";
var str2 : String = "";
var str3 : String = "";
var str4 : String = "";

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img : ImageView = findViewById<ImageView>(R.id.main_img)
        val et1 = findViewById<EditText>(R.id.name)
        val et2 = findViewById<EditText>(R.id.name_eng)
        val et3 = findViewById<EditText>(R.id.phone)
        val et4 = findViewById<EditText>(R.id.email)
        val et5 = findViewById<EditText>(R.id.address)
        val btn = findViewById<Button>(R.id.btn_main)



        img.isClickable = true
        img.setOnClickListener{
            openGallery()
        }

        btn.setOnClickListener{
            val intent = Intent(this,SubActivity::class.java)

            if(et1.text.isNotEmpty()) intent.putExtra("et1",et1.text.toString())
            if(et2.text.isNotEmpty()) intent.putExtra("et2",et2.text.toString())
            if(et3.text.isNotEmpty()) intent.putExtra("et3",et3.text.toString())
            if(et4.text.isNotEmpty()) intent.putExtra("et4",et4.text.toString())
            if(et5.text.isNotEmpty()) intent.putExtra("et5",et5.text.toString())

            if(str1.isNotEmpty()) intent.putExtra("str1",str1)
            if(str2.isNotEmpty()) intent.putExtra("str2",str2)
            if(str3.isNotEmpty()) intent.putExtra("str3",str3)
            if(str4.isNotEmpty()) intent.putExtra("str4",str4)
            startActivityForResult(intent,Text)
        }
    }

    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, GALLERY)
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap {
        return Bitmap.createScaledBitmap(
            bitmap, width, height, false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode.equals(GALLERY)) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    var ImageData: Uri? = data?.data
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                        val pt: ImageView = findViewById(R.id.main_img)
                        pt.setImageBitmap(bitmap)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        else if(requestCode.equals(Text)){
            when(resultCode){
                Activity.RESULT_OK ->{
                    try{
                        if(data!!.hasExtra("ets1"))
                            str1 = data!!.getStringExtra("ets1").toString();
                        if(data!!.hasExtra("ets2"))
                            str2 = data!!.getStringExtra("ets2").toString();
                        if(data!!.hasExtra("ets3"))
                            str3 = data!!.getStringExtra("ets3").toString();
                        if(data!!.hasExtra("ets4"))
                            str4 = data!!.getStringExtra("ets4").toString();
                    } catch (e : Exception){
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}