package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaration of constants
    private static int SPLASH_SCREEN_TIME = 4000;

    //Declaration of entities
    Animation animL, animR;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hooking up the animations
        animL = AnimationUtils.loadAnimation(this, R.anim.from_left);
        animR = AnimationUtils.loadAnimation(this, R.anim.from_right);

        //Hooking up the text fields
        text1 = findViewById(R.id.textfiled1);
        text2 = findViewById(R.id.textfiled2);

        //Setting the animations for the text fields
        text1.setAnimation(animL);
        text2.setAnimation(animR);

        //Splash screen code
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_TIME);
    }
}