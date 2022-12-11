package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThreeGridOfflineMultiplayer extends AppCompatActivity {

    TextView playerOneName, playertwoName;
    LinearLayout playerOneLayout, playerTwoLayout;
    ImageView slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_grid_offline_multiplayer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final TextView playerOneName = findViewById(R.id.playeronename);
        final TextView playertwoName = findViewById(R.id.playertwoname);

        final LinearLayout playerOneLayout = findViewById(R.id.playeronelayout);
        final LinearLayout playerTwoLayout = findViewById(R.id.playertwolayout);

        final ImageView slot1 = findViewById(R.id.slot1);
        final ImageView slot2 = findViewById(R.id.slot2);
        final ImageView slot3 = findViewById(R.id.slot3);
        final ImageView slot4 = findViewById(R.id.slot4);
        final ImageView slot5 = findViewById(R.id.slot5);
        final ImageView slot6 = findViewById(R.id.slot6);
        final ImageView slot7 = findViewById(R.id.slot7);
        final ImageView slot8 = findViewById(R.id.slot8);
        final ImageView slot9 = findViewById(R.id.slot9);


    }
}