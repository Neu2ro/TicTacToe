package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThreeOfflineMultiplayer extends AppCompatActivity {

    EditText pone, ptwo;
    Button gamesatart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_offline_multiplayer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pone = findViewById(R.id.playeronename);
        ptwo = findViewById(R.id.playertwoname);
        gamesatart = findViewById(R.id.statofflinemultiplayer);

        gamesatart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String getPlayerOneName = pone.getText().toString();
                final String getPlayerTwoName = ptwo.getText().toString();

                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                    Toast.makeText(ThreeOfflineMultiplayer.this, "Please Enter Player,s name", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(ThreeOfflineMultiplayer.this, ThreeGridOfflineMultiplayer.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(intent);
                }

            }
        });

    }
}