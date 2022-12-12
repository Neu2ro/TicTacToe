package com.example.tictactoe;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class WinDialog extends Dialog {

    private final String message;
    private final ThreeGridOfflineMultiplayer threeGridOfflineMultiplayer;

    public WinDialog(@NonNull Context context, String message, ThreeGridOfflineMultiplayer threeGridOfflineMultiplayer) {
        super(context);
        this.message = message;
        this.threeGridOfflineMultiplayer = threeGridOfflineMultiplayer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_dialog);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final TextView messagetxt = findViewById(R.id.messagetextbox);
        final Button startagain = findViewById(R.id.startagainbutton);

        messagetxt.setText(message);

        startagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeGridOfflineMultiplayer.restartMatch();
                dismiss();
            }
        });

    }
}