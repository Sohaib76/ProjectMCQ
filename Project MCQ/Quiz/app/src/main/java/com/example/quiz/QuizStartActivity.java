package com.example.quiz;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class QuizStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);
    }

    public void startQuiz(View view){

        int quizCategory = 0;  // All

        switch (view.getId()){
            case R.id.chp1Btn:
                quizCategory = 1;
                break;
            /**case R.id.chp3Btn:
             quizCategory = 2;
             break;
             case R.id.chp5Btn:
             quizCategory = 3;
             break;
             case R.id.chp7Btn:
             quizCategory = 4;
             break;
             case R.id.chp9Btn:
             quizCategory = 5;
             break;
             */


        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("QUIZ_CATEGORY" , quizCategory);
        startActivity(intent);
    }

    /// Back to Home
    public void exitQuiz (View view) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }
}
