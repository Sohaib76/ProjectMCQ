package com.example.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager myViewPager;
    private LinearLayout myLinearLayout;

    // For Dots
    private TextView[] myDots;

    private SliderAdapter sliderAdapter;

  // boolean appStartedFirstTime = false;

    // For Button
    private Button myNextButton;
    private Button myBackButton;

    private int myCurrentPage;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager= (ViewPager) findViewById(R.id.slideViewPager);
        myLinearLayout=(LinearLayout) findViewById(R.id.dotsLayout);




        sliderAdapter = new SliderAdapter(this );

        myViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        myViewPager.addOnPageChangeListener(viewListener);

        // For Buttons
        myNextButton=(Button) findViewById(R.id.nextBtn);
        myBackButton=(Button) findViewById(R.id.prevBtn);

        //ON Click listener
        myNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewPager.setCurrentItem(myCurrentPage + 1);

            }
        });

        myBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewPager.setCurrentItem(myCurrentPage - 1);
            }
        });




    }

    // for dots
    public void addDotsIndicator(int position) {
        // calculate how many pages, then add dots

        myDots = new TextView[3];

        myLinearLayout.removeAllViews();

        for(int i=0; i< myDots.length; i++){

            myDots[i] = new TextView(this);
            myDots[i].setText(Html.fromHtml("&#8901"));
            myDots[i].setTextSize(35);
            myDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));


            myLinearLayout.addView(myDots[i]);



        }
        if(myDots.length > 0) {
            myDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            myCurrentPage= i;

            if(i ==0){
                myNextButton.setEnabled(true);
                myBackButton.setEnabled(false);
                myBackButton.setVisibility(View.INVISIBLE);

                myNextButton.setText("Next");
                myBackButton.setText("");

            }

            else if (i==myDots.length + 1){
                myNextButton.setEnabled(true);
                myBackButton.setEnabled(true);
                myBackButton.setVisibility(View.VISIBLE);

                myNextButton.setText("Launch");
                myBackButton.setText("Back");



            }

            else {
                myNextButton.setEnabled(true);
                myBackButton.setEnabled(true);
                myBackButton.setVisibility(View.VISIBLE);
                myNextButton.setVisibility(View.VISIBLE);

                myNextButton.setText("Next");
                myBackButton.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}

