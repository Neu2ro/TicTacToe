package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NineGridOfflineMultiplayer extends AppCompatActivity {

    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playerTwoName;

    private GridLayout parentGridLayout;

    private GridLayout childGridLayout0;

    private Button btnGrid000, btnGrid001, btnGrid002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_grid_offline_multiplayer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        playerOneName = findViewById(R.id.playeronename);
        playerTwoName = findViewById(R.id.playertwoname);

        playerOneLayout = findViewById(R.id.playeronelayout);
        playerTwoLayout = findViewById(R.id.playertwolayout);

        // Parent Grid layout
        parentGridLayout = findViewById(R.id.parentGridLayout);

        // Child Grid layout
        childGridLayout0 = findViewById(R.id.childGridLayout0);

        // Grid layout Buttons
        btnGrid000 = findViewById(R.id.btnGrid000);
        btnGrid001 = findViewById(R.id.btnGrid001);
        btnGrid002 = findViewById(R.id.btnGrid002);

        final String getPlayerOneName = getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        btnGrid000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid000.setText("X");
            }
        });

        btnGrid001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid001.setText("Y");
            }
        });

        btnGrid002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid002.setText("Z");
            }
        });
    }
}
