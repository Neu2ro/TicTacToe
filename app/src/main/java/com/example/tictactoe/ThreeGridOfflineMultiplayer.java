package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThreeGridOfflineMultiplayer extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();
    private int [] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectBoxes = 1;
    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playertwoName;
    private ImageView slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_grid_offline_multiplayer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        playerOneName = findViewById(R.id.playeronename);
        playertwoName = findViewById(R.id.playertwoname);

        playerOneLayout = findViewById(R.id.playeronelayout);
        playerTwoLayout = findViewById(R.id.playertwolayout);

        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        slot4 = findViewById(R.id.slot4);
        slot5 = findViewById(R.id.slot5);
        slot6 = findViewById(R.id.slot6);
        slot7 = findViewById(R.id.slot7);
        slot8 = findViewById(R.id.slot8);
        slot9 = findViewById(R.id.slot9);

        combinationList.add(new int[] {0, 1, 2});
        combinationList.add(new int[] {3, 4, 5});
        combinationList.add(new int[] {6, 7, 8});
        combinationList.add(new int[] {0, 3, 6});
        combinationList.add(new int[] {1, 4, 7});
        combinationList.add(new int[] {2, 5, 8});
        combinationList.add(new int[] {2, 4, 6});
        combinationList.add(new int[] {0, 4, 8});

        final String getPlayerOneName = getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playertwoName.setText(getPlayerTwoName);

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){
                    performAction((ImageView)view, 0);
                }
            }
        });

        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    performAction((ImageView)view, 1);
                }
            }
        });

        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    performAction((ImageView)view, 2);
                }
            }
        });

        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                    performAction((ImageView)view, 3);
                }
            }
        });

        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    performAction((ImageView)view, 4);
                }
            }
        });

        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    performAction((ImageView)view, 5);
                }
            }
        });

        slot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView)view, 6);
                }
            }
        });

        slot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    performAction((ImageView)view, 7);
                }
            }
        });

        slot9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    performAction((ImageView)view, 8);
                }
            }
        });
    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;

        if(playerTurn == 1){
            imageView.setImageResource(R.drawable.cross);

            if(checkPlayerWin()){
                WinDialog winDialog = new WinDialog(ThreeGridOfflineMultiplayer.this, playerOneName.getText().toString() + " has won the match", ThreeGridOfflineMultiplayer.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(totalSelectBoxes == 9) {
                WinDialog winDialog = new WinDialog(ThreeGridOfflineMultiplayer.this, "It is a draw", ThreeGridOfflineMultiplayer.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }

            else {
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.circle);

            if(checkPlayerWin()) {
                WinDialog winDialog = new WinDialog(ThreeGridOfflineMultiplayer.this, playertwoName.getText().toString() + " has won the match", ThreeGridOfflineMultiplayer.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }

            else if(totalSelectBoxes == 9) {
                WinDialog winDialog = new WinDialog(ThreeGridOfflineMultiplayer.this, "It is a draw", ThreeGridOfflineMultiplayer.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }

            else {
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1) {
            playerOneLayout.setBackgroundResource(R.drawable.custom_current_player);
            playerTwoLayout.setBackgroundResource(R.drawable.custom_add_player);
        }
        else {
            playerTwoLayout.setBackgroundResource(R.drawable.custom_current_player);
            playerOneLayout.setBackgroundResource(R.drawable.custom_add_player);
        }
    }

    private boolean checkPlayerWin(){
        boolean response = false;

        for(int i = 0; i < combinationList.size(); i++){

            final int [] combination = combinationList.get(i);

            if(boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }

        return response;
    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;

        if(boxPositions[boxPosition] == 0) {
            response = true;
        }

        return response;
    }

    public void restartMatch(){
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn = 1;
        totalSelectBoxes = 1;

        slot1.setImageResource(R.drawable.custom_player_space);
        slot2.setImageResource(R.drawable.custom_player_space);
        slot3.setImageResource(R.drawable.custom_player_space);
        slot4.setImageResource(R.drawable.custom_player_space);
        slot5.setImageResource(R.drawable.custom_player_space);
        slot6.setImageResource(R.drawable.custom_player_space);
        slot7.setImageResource(R.drawable.custom_player_space);
        slot8.setImageResource(R.drawable.custom_player_space);
        slot9.setImageResource(R.drawable.custom_player_space);
    }

}