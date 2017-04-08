package com.example.android.investing101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.investing101.R;

import static android.R.id.empty;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    /**
     * this will keep track of your score /
     */

    int score = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when the check button is clicked

     */
    public void submit (View View) {
        /**
         * here we create the checkbox objectsfor the right anwers.This will make everything simpler but will alow cheating
         */
        CheckBox question1 = (CheckBox) findViewById(R.id.liquidation) ;
        CheckBox question2 = (CheckBox) findViewById(R.id.pe) ;
        CheckBox question3 = (CheckBox) findViewById(R.id.dcf);
        CheckBox question4 = (CheckBox) findViewById(R.id.debttoequity) ;
        CheckBox question5 = (CheckBox) findViewById(R.id.roic) ;
        CheckBox question6 = (CheckBox) findViewById(R.id.vanguard) ;
        /**
         * here we create the editTxt objet and we assigned it to the Edittext in xml
         */
        EditText yourName = (EditText) findViewById(R.id.name) ;
        /**
         * now we assign the boolean varaibles to the object, and their value is the result of the method ischeked applied to tehe objet. Trueif cklicked, flase if is not
         */
        boolean liquidationValue = question1.isChecked();
        boolean priceEarnings = question2.isChecked() ;
        boolean dCashFlow = question3.isChecked() ;
        boolean debtToEquity = question4.isChecked();
        boolean rOic = question5.isChecked() ;
        boolean vanguardFund = question6.isChecked();
        Log.v("Main activity", "question" + liquidationValue) ;
        Log.v("Main activity", "question" + priceEarnings) ;
        Log.v("Main activity", "" + dCashFlow) ;
        Log.v("Main activity", "" + rOic) ;
        Log.v("Main activity", "" + vanguardFund) ;
        Log.v("Main activity", "" + debtToEquity) ;
        /**
         * here we create the variable for the name entered and we turn it to a string
         */
        String quizzer = yourName.getText().toString();
        /** here we call the method final score
         *
         */
        if (liquidationValue) {score += 1;}
        if (priceEarnings) {score += 1;}
        if (dCashFlow) {score += 1;}
        if (debtToEquity) {score += 1;}
        if (rOic) {score += 1;}
        if (vanguardFund) {score += 1;}


        /** here we call the method display
         *
         */
        String message = results(quizzer);
        message += "\n You scored " + score + " out of 6!";
        displayMessage(message);
        displayImage(View);

    }
    public void reset (View View) {
        score = 0 ;
        setContentView(R.layout.activity_main);
    }

    /**
     /** declare the method display, which is called when the button is clicked
     *display( score);

     private void display(int number) {
     TextView quantityTextView = (TextView) findViewById(R.id.price);
     quantityTextView.setText("" + number);
     }
     */
    private void displayMessage(String message) {
        TextView scoreMessage = (TextView) findViewById(R.id.scoreMessage);
        scoreMessage.setText(message);

    }
    private void displayImage (View view){ if (score == 6) {
        ImageView resultsAre = (ImageView) findViewById (R.id.image);
        resultsAre.setImageResource(R.drawable.up);} else
    {
        ImageView resultsAre = (ImageView) findViewById (R.id.image);
        resultsAre.setImageResource(R.drawable.poor);}
    }
    private String results (String quizzer){
        String finalScore = "\n Hey " + quizzer + "You are done!" ;

        return  finalScore;
    }
}


