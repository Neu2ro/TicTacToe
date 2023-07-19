package com.example.tictactoe;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NineGridOfflineMultiplayer extends AppCompatActivity {

    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playertwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_grid_offline_multiplayer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        playerOneName = findViewById(R.id.playeronename);
        playertwoName = findViewById(R.id.playertwoname);

        playerOneLayout = findViewById(R.id.playeronelayout);
        playerTwoLayout = findViewById(R.id.playertwolayout);

        final String getPlayerOneName = getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playertwoName.setText(getPlayerTwoName);
    }
}
