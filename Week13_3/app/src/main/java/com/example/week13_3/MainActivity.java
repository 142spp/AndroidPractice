package com.example.week13_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button galleryButton = findViewById(R.id.galleryBtn);
        galleryButton.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,GalleryActivity.class);
            startActivity(i);
        });
    }
}