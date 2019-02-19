package com.example.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView question_count_label;
    TextView question_label;
    Button answer_btn1;
    Button answer_btn2;
    Button answer_btn3;
    Button answer_btn4;

    String rightAnswer;
    int rightAnswerCount = 0;
    int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Question", "RightAnswer", "Choice1", "Choice2", "Choice3"}
            {"If the mass of a spring mass system is doubled, its time period becomes:",
                    "√2 T ", "T/2 ", "√T/2 " , "T/√2 "},
            {"When a body moves to and fro about a point its motion is called:", "Vibratory motion ",
                    "Rotatory motion ", "Linear motion " , "Random motion "},
            {"The product of frequency (f) and wavelengthλ is equal to:", "Wave speed ", "Wave energy / frequency ", "Amplitude " ,
                    "Time period "},
            {"If the length of a simple pendulum is halved its time period will become:", "T = T/√2 ", "√2T ",
                    "T/2 " , "2T "},
            {"If a wave moves in a slinky spring with frequency of 4Hz and wave length of 0.4m, the speed of the wave will be:", "1.6 ms-1 ", "1.4 ms-1 ", "1.2 ms-1 " ,
                    "1.0 ms-1 "},

            {"The difference between the loudness of faintest audible sound and loudness of another sound is called:", "Quality of sound ",
                    "Pitch of sound ", "Sound level " , "Intensity of sound "},
            {"After how much time the echo must be heard?",
                    "0.1 s ", "0.10 s ", "0.20 s " , "0.50 s "},
            {"The distance between two consecutive compressions or rarefactions in longitudinal waves is called:", "Wavelength ", "Half wavelength ", "1/4 wavelength " , "Amplitude "},
            {"The character by which lound and faint sound can be distinguished is called:", "Loudness ", "Intensity ", "Quality " , "Pitch "},
            {"The speed of sound in the air at one atmospheric pressure at room temperature is:", "343 ms-1 ", "346 ms-1 ", "349 ms-1 " , "339 ms-1 "},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"", "", "", "" , ""},
            {"Mathematical formula of capacitance of a capacitor is: ", "C = Q/V ", "C = Q/V " , "C = V/Q " , "C = V2/Q "},
            {"Which one is a safety device? ", "Circuit Breaker and Fuse", "Circuit breaker " , "Fuse " , "Switch " },
            {"Which device is used to store charge: ", "Capacitor ", "Dielectric " , "Fuse " , "Resister " },
            {"The example of magnetic disk is:", "Floppy disk ", "Video cassette " , "Audio cassette " , "Compact disk " },
            {"Boolean expression for AND operation is: ", "X = A . B ", "X = A + B " , "X = A̅ " , "X = A̅B̅ " },
            {"Number of poles in a magnet is: ", "Two ", "Unlimited " , "Three " , "One " },
            {"The focal length is related to radius of curvature by the formula: ", "f = R/2 ", "f = 4R " , "f = 2R " , "R = f/2 " },
            {"For the emission of electrons from the tungsten filament the values of current and voltage are taken as:", "0.3A and 6V ", "0.4A and 8V " , "0.2 A and 4V " , "0.1 A and 2V " },
            {"If we double the distance between two charges, what will be the change in the force between them? ", "One fourth ", "Four times " , "Double " , "Half " },
            {"Which statement of the following is false for primary memory? ", "It is built on laser technology ", "It gets lost when computer switches off " , "This is a random access memory " , "The base of primary memory is electronics " },
            {"The true ratio of a transformer is 10. It means: ", "Ns = 10NP ", "VS= Vp/10 " , "Ns = Np/10 " , "Vs = 10Vp " },
            {"Which wire has lowest resistance? ", "Very thin wire ", "Thin wire " , "Thick wire " , "All " },
            {"If focal length of a lens is 1m, then its power will be: ", "1 D ", "0.5 D " , "1.5 D " , "1 D " },
            {"The principal focus of a concave mirror is:", "Real ", "Imaginary " , "Dual aspect " , "Virtual " },
            {"Which memory consists of integrated circuits? ", "Primary memory ", "Audio cassette ", "Video cassette ", "Compact cassette "},
            {"During S.H.M acceleration of the body is maximum at:", "Extreme positions ", "Between mean & Extereme ",
                    "Mean position " , "None of these "},


    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_count_label = (TextView)findViewById(R.id.question_count_label_id);
        question_label = (TextView)findViewById(R.id.question_label_id);
        answer_btn1 = (Button)findViewById(R.id.answer_btn1_id);
        answer_btn2 = (Button)findViewById(R.id.answer_btn2_id);
        answer_btn3 = (Button)findViewById(R.id.answer_btn3_id);
        answer_btn4 = (Button)findViewById(R.id.answer_btn4_id);

        // receive quizCategory from startActivity
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);

        Log.v("CATEGORY_TAG", quizCategory + "");




    // create quiz array from quiz data

        for (int i=0; i < quizData.length; i++){
            // prepare array

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);  // question
            tmpArray.add(quizData[i][1]);  // rightAnswer
            tmpArray.add(quizData[i][2]);  // choice 1
            tmpArray.add(quizData[i][3]);  // choice 2
            tmpArray.add(quizData[i][4]);  // choice 3

            // add tmpArray to quizArray
            quizArray.add(tmpArray);


        }

        showNextQuiz();



    }

    public void showNextQuiz(){
        // Update quiz question_count_label

        question_count_label.setText("Q" + quizCount);

        // Generate random questions between 0 to 14 (quizArray size = 15)
        Random random = new Random();
        int randomNumber = random.nextInt(quizArray.size());

        // Pick one quiz set
        ArrayList<String> quiz = quizArray.get(randomNumber);

        // set question and right answer
        //Array format:  // {"Question", "RightAnswer", "Choice1", "Choice2", "Choice3"}
        question_label.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Question from quiz list and Shuffle choice"
        quiz.remove(0);
        Collections.shuffle(quiz);

        // set choices
        answer_btn1.setText(quiz.get(0));
        answer_btn2.setText(quiz.get(1));
        answer_btn3.setText(quiz.get(2));
        answer_btn4.setText(quiz.get(3));

        // Remove this quiz from quizArray
        quizArray.remove(randomNumber);        // ????????????????????????

    }

    public void checkAnswer (View view){

        // Get pushed Button
        Button answer_btn = (Button) findViewById(view.getId());
        String button_text = answer_btn.getText().toString();

        String alertTitle;

        if (button_text.equals(rightAnswer)) {
            // Correct
            alertTitle = "Correct!";
            rightAnswerCount++;
        } else {
            // Wrong
            alertTitle = "Wrong, Try again!";

        }

    // Create alert Dialog
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle(alertTitle);
        alertBuilder.setMessage("Answer : " + rightAnswer);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount==QUIZ_COUNT ){
                    // Show Result
                    Intent intent = new Intent(getApplicationContext(), QuizResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT" , rightAnswerCount);
                    startActivity(intent);

                }else{
                    quizCount++;
                    showNextQuiz();

                }
            }
        });

        alertBuilder.setCancelable(false);
        alertBuilder.show();

    }

}
