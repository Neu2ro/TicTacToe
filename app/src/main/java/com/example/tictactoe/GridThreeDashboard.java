package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class GridThreeDashboard extends AppCompatActivity {

    ImageButton threetodash;
    Button offlinemulti3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_three_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        threetodash = findViewById(R.id.threetodash);
        offlinemulti3 = findViewById(R.id.offlinemulti3);

        threetodash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GridThreeDashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });

        offlinemulti3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GridThreeDashboard.this, ThreeOfflineMultiplayer.class);
                startActivity(intent);
            }
        });
    }
}
