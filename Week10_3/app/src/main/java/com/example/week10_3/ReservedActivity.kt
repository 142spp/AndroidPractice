package com.example.week10_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable
import kotlinx.android.synthetic.main.activity_reserved.*
import kotlinx.android.synthetic.main.activity_reserved.posterImageView

data class ReservedMovie(
    val _id :Int?,
    val name:String?,
    val poster_image:String?,
    val director: String?,
    val synopsis: String?,
    val reserved_time: String?
): Serializable

class ReservedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserved)

        processIntent(intent)
        btnclose.setOnClickListener{
            finish()
        }
    }
    fun processIntent(intent: Intent?){
        val movies = intent?.getSerializableExtra("movies") as ArrayList<ReservedMovie>?
        val movie = movies?.get(0)
        if(movie!=null){
            posterImageView.setImageURI(Uri.parse(movie.poster_image))
            r_input1.setText(movie.name)
            r_input2.setText(movie.director)
            r_input3.setText(movie.synopsis)
            r_input4.setText(movie.reserved_time)
        }
    }

}
