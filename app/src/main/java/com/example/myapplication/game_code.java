package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class game_code extends AppCompatActivity {

    private String username;
    private int points;
    private static double pointsMultiplier;
    private static int randomNumber;
    private static int lives;
    private static int guessed;
    final static private int lowerLimit = 0;
    private static int upperLimit;
    private ArrayList<guessTheNumber> topLeaderboard;




    public static int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public int getUpperLimit(){
        return upperLimit;
    }
    public static void startEasyDifficulty(){
        randomNumber = getRandomNumber(0, 10);
        lives = 10;
        guessed = 0;
        upperLimit = 10;
        pointsMultiplier = 1;
    }

    public static void  startMediumDifficulty(){
        randomNumber = getRandomNumber(0,30);
        lives = 5;
        guessed = 0;
        upperLimit = 30;
        pointsMultiplier = 2.5;
    }

    public static void startHardDifficulty(){
        randomNumber = getRandomNumber(0, 100);
        lives = 3;
        guessed = 0;
        upperLimit = 100;
        pointsMultiplier = 5;
    }

    public int getChosenNumber(){
        return randomNumber;
    }

    public String checkGuess(int guess){
        if(guess == randomNumber){
            guessed++;
            points+= guessed*pointsMultiplier;
            return "Your guess is RIGHT!!!";
        }
        else{
            lives--;
            return "WRONG! The number is " + higherOrLower(guess);
        }
    }

    public String higherOrLower(int guess){
        if(getChosenNumber() > guess){
            return  "Higher";
        }
        else{
            return "Lower";
        }
    }


    //code for the game displays
    String guess;
    int guessInt;
    EditText guessInput;
    Button guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_code_screen);

        TextView gameDescriptionMessage = (TextView) findViewById(R.id.description);
        gameDescriptionMessage.setText("The number is between 0 and " + getUpperLimit());

        guessInput = (EditText) findViewById(R.id.guessInput);
        guessButton = (Button) findViewById(R.id.guessButton);

        TextView afterGuessMessage = (TextView) findViewById(R.id.HigherLower);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess = guessInput.getText().toString();
                guessInt = Integer.parseInt(guess);
                afterGuessMessage.setText(checkGuess(guessInt));
            }
        });


    }

}