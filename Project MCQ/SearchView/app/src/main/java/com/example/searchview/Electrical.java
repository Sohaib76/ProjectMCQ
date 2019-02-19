package com.example.searchview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Electrical extends AppCompatActivity {

    ImageView imageView;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);

        ImageView imageView = (ImageView) findViewById(R.id.imageViewid);
        imageView.setAlpha((float) 50.0);




    }


}
