package com.example.splashscreen;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Splash_screen extends AppCompatActivity {



    private GifImageView myGifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

// Immersive full screen
        View decorView = getWindow().getDecorView();

        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE

                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);







        myGifImageView = (GifImageView) findViewById(R.id.gifImageView);

        try{
                InputStream inputStream = getAssets().open("qwe.gif");
                byte[] bytes = IOUtils.toByteArray(inputStream);
                myGifImageView.setBytes(bytes);
                myGifImageView.startAnimation();
                }
        catch (IOException ex)
        {

        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Splash_screen.this.startActivity(new Intent(Splash_screen.this,MainActivity.class));
                Splash_screen.this.finish();
            }
        }, 5000);


    }
}
