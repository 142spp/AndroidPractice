package com.example.week6_4

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

val GALLERY = 1
lateinit var bitmap : Bitmap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val photo: ImageView = findViewById<ImageView>(R.id.main_image)
        val btn = findViewById<Button>(R.id.btn)
        val et1 = findViewById<EditText>(R.id.et_1)
        val et2 = findViewById<EditText>(R.id.et_2)
        val et3 = findViewById<EditText>(R.id.et_3)
        val et4 = findViewById<EditText>(R.id.et_4)
        val et5 = findViewById<EditText>(R.id.et_5)

        photo.isClickable = true
        photo.setOnClickListener {
            openGallery()
        }

        btn.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            if (et1.text.isNotEmpty())
                intent.putExtra("name", et1.text.toString())
            if (et2.text.isNotEmpty())
                intent.putExtra("age", et2.text.toString())
            if (et3.text.isNotEmpty())
                intent.putExtra("phone", et3.text.toString())
            if (et4.text.isNotEmpty())
                intent.putExtra("address", et4.text.toString())
            if (et5.text.isNotEmpty())
                intent.putExtra("etc", et5.text.toString())
            val resize = resizeBitmap(bitmap, 300, 300)
            intent.putExtra("image", resize)
            startActivityForResult(intent, 100)

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
                        val pt: ImageView = findViewById(R.id.main_image)
                        pt.setImageBitmap(bitmap)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        if (requestCode.equals(100)) {
            when (resultCode) {
                100 -> {
                    val et1 = findViewById<EditText>(R.id.et_1)
                    val et2 = findViewById<EditText>(R.id.et_2)
                    val et3 = findViewById<EditText>(R.id.et_3)
                    val et4 = findViewById<EditText>(R.id.et_4)
                    val et5 = findViewById<EditText>(R.id.et_5)
                    et1.text.clear()
                    et2.text.clear()
                    et3.text.clear()
                    et4.text.clear()
                    et5.text.clear()
                }
                0 -> {
                    return
                }
                else ->
                    Toast.makeText(this, "오류", Toast.LENGTH_SHORT).show()

            }
        }
    }
}

