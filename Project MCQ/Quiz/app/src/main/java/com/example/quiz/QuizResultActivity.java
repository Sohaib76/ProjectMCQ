package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        TextView resultLabel = findViewById(R.id.resultLabel_id);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_id);

        int Score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScoreLabel", 0);
        totalScore += Score;

        resultLabel.setText(Score + " /10");
        totalScoreLabel.setText("Total Score:" + totalScore);

        // Update total score
        SharedPreferences.Editor sharedEditor = settings.edit();
        sharedEditor.putInt("totalScoreLabel", totalScore);
        sharedEditor.commit();

    }

    public void returnQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), QuizStartActivity.class);
        startActivity(intent);
    }
    public void returnHome(View view) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }


}
