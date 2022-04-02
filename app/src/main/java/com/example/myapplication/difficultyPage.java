package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class difficultyPage extends AppCompatActivity {
    private Button easyB;
    private Button normalB;
    private Button hardB;
    private Button loginB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_page);
        loginB = (Button) findViewById(R.id.LoginButton);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
        normalB = (Button) findViewById(R.id.NormalButton);
        normalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNormalPage();
            }
        });
        easyB = (Button) findViewById(R.id.EasyButton);
        easyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEasyPage();
            }
        });
       hardB = (Button) findViewById(R.id.HardButton);
        hardB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                openHardPage();
            }
       });
    }

    public void showRules(View v){
        RelativeLayout popup;
        popup = (RelativeLayout) findViewById(R.id.rulesPopup);
        if (popup.getVisibility() == View.GONE) {
            popup.setVisibility(View.VISIBLE);
        }
    }

    public void hideRules(View v){
        RelativeLayout popup;
        popup = (RelativeLayout) findViewById(R.id.rulesPopup);
        if (popup.getVisibility() == View.VISIBLE) {
            popup.setVisibility(View.GONE);
        }
    }

    public void openEasyPage(){
        game_code easyGame = new game_code();
        easyGame.startEasyDifficulty();
        Intent intent = new Intent(this, game_code.class);
        startActivity(intent);
    }
    public void openNormalPage(){
        game_code normalGame = new game_code();
        normalGame.startMediumDifficulty();
        Intent intent = new Intent(this, game_code.class);
        startActivity(intent);
    }
    public void openHardPage(){
        game_code hardGame = new game_code();
        hardGame.startHardDifficulty();
        Intent intent = new Intent(this, game_code.class);
        startActivity(intent);
    }
    public void openLoginPage(){
        Intent intent = new Intent(this, loginPage.class);
        startActivity(intent);
    }
}