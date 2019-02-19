package com.example.ngoctri.introsliderexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    CardView mcqCard,quizCard,aboutCard,reminderCard,shareCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Defining Cards objects

        mcqCard=  findViewById(R.id.MCQId);
        quizCard= findViewById(R.id.quizId);
        aboutCard= findViewById(R.id.aboutId);
        reminderCard= findViewById(R.id.reminderId);
        shareCard= findViewById(R.id.shareId);
        // adding click listener to cards/buttons

        mcqCard.setOnClickListener(this);
        quizCard.setOnClickListener(this);
        aboutCard.setOnClickListener( this);
        reminderCard.setOnClickListener( this);
        shareCard.setOnClickListener(this) ;


    }

    // public void onDisplay(View view) {
    // for toast
    //Toast toast= Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT);
    // toast.setGravity(Gravity.BOTTOM, 0, 0);
    //toast.show();
    // }






    @Override
    public void onClick(View view) {





        // for Toast of quiz
        Toast toast= Toast.makeText(HomeActivity.this, "Coming Soon", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);


        // for Toast of calender
        Toast toast2= Toast.makeText(HomeActivity.this, "Practice 15 min a day", Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.BOTTOM, 0, 0);
        //  toast.show();


        // for sharing to whatsapp
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is the best App for learning"+"\n"+ "https://KHF_Tutors.com");
        sharingIntent.setPackage("com.whatsapp");

        // Opening Calender
        Intent calendarIntent = new Intent(getPackageManager().getLaunchIntentForPackage("com.google.android.calendar"));




        Intent i;

        switch (view.getId()){
            case R.id.MCQId : i = new Intent(this,MCQ.class); startActivity(i);break;
            case R.id.quizId: i = new Intent (this,QuizStart.class); startActivity(i); break;
            //toast.show();break;
            case R.id.shareId: startActivity(sharingIntent);break;
            case R.id.reminderId: startActivity(calendarIntent); break;
            case R.id.aboutId: i = new Intent (this,About.class); startActivity(i); break;
            default:break;
        }



    }


}
