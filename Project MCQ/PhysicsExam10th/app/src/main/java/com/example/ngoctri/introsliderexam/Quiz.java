package com.example.ngoctri.introsliderexam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {

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
            {"The character by which loud and faint sound can be distinguished is called:", "Loudness ", "Intensity ", "Quality " , "Pitch "},
            {"The speed of sound in the air at one atmospheric pressure at room temperature is:", "343 ms-1 ", "346 ms-1 ", "349 ms-1 " , "339 ms-1 "},
            {"The symbol of atomic mass number is:", "A ", "X ", "N " , "Z "},
            {"Wave equation is defined as: ", "V = fλ ", "V = 2fλ ", "f = V λ " , "f = Tλ "},
            {"The device which is used to convert sound waves into electrical signal is called: ", "Microphone ", "Ear piece ", "Transmission channel " , "Receiver "},
            {"Sound waves are an example of: ", "Longitudinal waves ", "All of these ", "Electromagnetic waves " , "Transverse waves "},
            {"Which device is used to increases / decreases A.C Voltage? ", "Transformer ", "Electric motor ", "A.C Generator " , "Solenoid "},
            {"The phenomenon in which radiations convert the matter into positive and negative ions is called:", "Ionization ", "Excitation ", "Radio activity " , "Electrolysis "},
            {"To hear echo, the distance between the observer and the obstacle is 17m then how much distance will the sound travel? ", "34m ", "17m ", "54m " , "60m "},
            {"The symbol of AND operation is: ", ". ", "- ", "+ " , "* "},
            {"Which radiations are free of effect of electric and magnetic field? ", "Gamma ", "Beta ", "Alpha " , "Alpha and beta "},
            {"During S.H.M acceleration of the body is maximum at:", "Extreme positions ", "Mean position ", "Between mean & Extereme " , "None of these "},
            {"If a wave moves in a slinky spring with frequency of 4Hz and wave length of 0.4m, the speed of the wave will be: ", "1.6 ms-1 ", "1.4 ms-1 ", "1.2 ms-1 " , "1.0 ms-1 "},
            {"The difference between the loudness of faintest audible sound and loudness of another sound is called: ", "Quality of sound ", "Pitch of sound ", "Sound level " , "Intensity of sound "},
            {"Which waves of the following has highest frequency? ", "Light wave ", "Micro waves ", "Radio waves " , "Sound wave "},
            {"A.C generator works on the principle of: ", "Electromagnetic induction ", "Law of gravitation ", "Third law of motion " , "Electrostatic induction "},
            {"The symbol of alpha particles is: ", "42He ", "4AHe ", "0-1B " , "00Y "},
            {"The S.I unit of electric potential is: ", "Volt ", "Coulomb ", "Joule " , "Watt "},
            {"The formula of time period of simple pendulum is: ", "T = 2π √L/g ", "T = 2π (L/g) ", "T = 2π√1/g " , "T = 1/2π √L/g "},
            {"Which instrument measures the potential difference: ", "Voltmeter ", "Barometer ", "Galvanometer " , "Ammeter "},
            {"If the intensity of faintest audible sound is Io and of another sound is I then sound level will be: ", "K log I/Io ", "K log Io/I2 ", "Log Io/I 2K " , "K log Io/I "},
            {"Electronic message is called: ", "E-mail ", "Browser ", "Computer " , "Internet "},
            {"Two switches attached in series work on which operation? ", "AND operation ", "OR operation ", "NOT operation " , "NOR operation "},
            {"Pitch of sound depends upon: ", "Frequency ", "Amplitude ", "Intensity " , "Time period "},
            {"The coil of a transformer which is connected to A.C is called: ", "Primary coil ", "Secondary coil ", "Field coil " , "Armature coil "},
            {"Mathematical formula of spring constant is: ", "F/x ", "X/F ", "F/t " , "F/m "},
            {"The device which converts digital quantities into analog quantities is called: ", "DAC ", "ACD ", "CAD " , "ADC "},
            {"A group of instructions or a program which guides hardware to do work is called: ", "Software ", "Memory ", "Micro processor " , "Hardware "},
            {"Unlike charges always: ", "Attract each other ", "Sometimes repel and attract each other ", "Both A and B " , "Repel each other "},
            {"The true ratio of a transformer is 10. It means: ", "Ns = 10NP ", "Ns = Np/10 ", "Vs = 10Vp " , "VS= Vp/10 "},
            {"Electric motor converts electrical energy into: ", "Mechanical energy ", "Heat energy ", "Solar energy " , "Chemical energy "},
            {"High pitch means: ", "High frequency ", "High wavelength ", "High time period " , "High energy "},
            {"Radiations present in atmosphere due to the presence of different radioactive elements are: ", "Background radiations ", "Cosmic radiations ", "secondary radiations " , "Electromagnetic radiations "},
            {"Transformer works on _______ supply. ", "A.C ", "D.C", "Battery " , "Both A and B "},
            {"Who are you", "A Human", "An elf", "A demon" , "A monkey"},
            {"Electric field lines of force were first introduced by: ", "Farady ", "Fleming ", "Coulomb " , "Ampere "},
            {"After how much time the echo must be heard? ", "0.1 s ", "0.10 s ", "0.20 s " , "0.50 s "},
            {"Mathematical formula of sound level (in bel) is: ", "S.L = Log I/Io (bel) ", "S.L = K log I/Io (bel) ", "S.L = 10 log Io/I (bel) " , "S.L = K log I/Io (bel) "},
            {"In 1950, physicists observed that in cathode ray tube a special type of rays produced from cathode, these rays were called: ", "Cathode rays ", "X-rays ", "Alpha rays " , "Gamma rays "},
            {"In electric motor, the brushes are made of: ", "Graphite ", "Iron ", "Wood " , "Lead "},
            {"It is used in satellite communication: ", "Micro waves ", "Light waves ", "Electrical waves " , "Radio waves "},
            {"The S.I unit of electric power is: ", "Watt ", "Volt ", "Ampere " , "Joule "},
            {"In mathematical form of Ohm's law, \"R\" is: ", "Resistance ", "Specific resistance ", "Resistor " , "Resistivity "},
            {"In a convex mirror the size of the image: ", "Depends upon the position of the object ", "Is equal to the size of the object", "Is greater than the size of the object", "Is smaller than the size of the object "},
            {"The S.I unit of electric current is: ", "Ampere ", "Coulomb ", "Watt " , "Volt "},
            {"If a charged body is brought near a negatively charged electroscope and the leaves of electroscope diverge, then the body is: ", "Negatively charged ", "Neutral ", "None of these " , "Positively charged "},
            {"The number of neutrons in the nucleus of tritium is: ", "2 ", "1 ", "3 " , "4 "},
            {"A conductor of electric current is: ", "Copper ", "Plastic ", "Rubber " , "Wood "},
            {"Those quantities whose values change gradually or stay constant are called:", "Analog quantities ", "Log quantities ", "Digital quantities " , "Physical quantities "},
            {"When the object is placed beyond 2F of a convex lens, the image formed will be: ", "Real, inverted and of the same size as the object ", "Real, inverted and larger in size than the object ", "Virtual, erect and larger in size than the object " , "Real, inverted and smaller than the object "},
            {"The parts of computer which can be seen and touched are called: ", "Hardware ", "Software ", "Modem " , "CPU "},
            {"Which statement of the following is false for primary memory? ", "It is built on laser technology ", "It gets lost when computer switches off ", "This is a random access memory " , "The base of primary memory is electronics "},
            {"The SI unit of electric field intensity is: ", "NC-1 ", "Ns ", "Nm-1 " , "NC-2 "},
            {"Electric current in conductors is due to the flow of: ", "Free electrons ", "Positive charge ", "Negative ions " , "Positive ions "},
            {"Field around a charge in which that charge exerts a force on a point charge brought in that field is called: ", "Magnetic field ", "Neutral zone ", "Point charge " , "Electric field "},
            {"After refraction from a convex lens, rays of light parallel to the principal axis converge at a point, this point of convex lens is called: ", "Principal focus ", "Pole ", "Focal length " , "Optical center "},
            {"Magnetic effect of electric current was first discovered by: ", "Ampere ", "Volta ", "Lenz " , "Faraday "},
            {"Mathematical formula of electromotive force (e.m.f) is: ", "E = W/Q ", "E = Q/W ", "E = WQ " , "E = W2Q "},
            {"The distance between two consecutive compressions or rarefactions in longitudinal waves is called", "Wavelength ", "Amplitude ", "Half wavelength " , "1/4 wavelength "},
            {"Boolean expression for AND operation is: ", "X = A . B ", "X = A + B ", "X = A̅ " , "X = A̅B̅ "},
            {"A transformer has 100 turns in its primary and 500 turns in secondary coil. If 6 volts D.C is applied across its primary, the voltage induced across its secondary coil will be: ", "0 volt ", "30 volts ", "45 volts " , "60 volts "},
            {"The product of frequency (f) and wavelengthλ is equal to: ", "Wave speed ", "Wave energy / frequency ", "Amplitude " , "Time period "},
            {"An object is placed 6 cm away in front of a concave mirror that has 10 cm focal length. Determine the location of the image: ", "-15 cm ", "-20 cm ", "-10 cm " , "-5 cm "},
            {"Short form of information Technology is: ", "IT ", "ITS ", "CBIS " , "IS "},
            {"The S.I unit of intensity of sound is: ", "Wm-2 ", "Wm-1 ", "Wm2 " , "Wm "},
            {"Which wire has lowest resistance? ", "Very thin wire ", "Thin wire ", "All " , "Thick wire "},
            {"Snell's law is stated as: ", "sin i / sin r = n2/n1 ", "sin r / sin i = n2/n1 ", "sin r / sin i = 2n2/n1 " , "Sin i / sin r = n1/n2 "},
            {"Changing magnetic field in a closed circuit can induce: ", "Electric current ", "Force ", "Both A and B " , "e.m.f "},
            {"In computer terminology, proceed data is called: ", "Information ", "Digital data ", "Program " , "Software "},
            {"If Current flowing through switch then the output is expressed as: ", "1 ", "-1 ", "2 " , "0 "},
            {"The emission of electron from the surface of hot metal is called: ", "Thermionic emission ", "Convection ", "Conduction " , "Ionization "},
            {"The S.I unit of potential difference is: ", "Volt ", "Coulomb ", "Ampere " , "Watt "},
            {"The base of computer operation are: ", "0, 1 ", "0, 2 ", "1, 10 " , "1,2 "},
            {"What is the voltage across a 6Ω resister when 3A current passes through it? ", "18V ", "36V ", "9V " , "2V "},
            {"Optical fibers work on the principle of: ", "Total internal reflection ", "Diffraction ", "Reflection " , "Refraction "},
            {"Which particles are nucleons? ", "Protons and neutrons ", "Electrons and neutrons ", "Electrons and positrons " , "Electrons and protons "},
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
        setContentView(R.layout.activity_quiz);

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
            rightAnswerCount--;

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
                    Intent intent = new Intent(getApplicationContext(), QuizEnd.class);
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
