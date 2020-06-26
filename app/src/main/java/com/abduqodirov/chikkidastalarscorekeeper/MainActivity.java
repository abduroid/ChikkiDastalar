package com.abduqodirov.chikkidastalarscorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int player1Length = 0;
    private int player2Length = 0;

    private int player1Hits = 1;
    private int player2Hits = 1;

    private TextView player1ScoreLengthText;
    private TextView player2ScoreLengthText;

    private TextView player1HitsText;
    private TextView player2HitsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1ScoreLengthText = findViewById(R.id.player1lengthScoreText);
        player2ScoreLengthText = findViewById(R.id.player2LengthScoreText);

        player1HitsText = findViewById(R.id.player1NumberOfHitsText);
        player2HitsText = findViewById(R.id.player2NumberOfHitsText);

        Button player1LengthBtn = findViewById(R.id.player1lengthIncrementorBtn);
        Button player2LengthBtn = findViewById(R.id.player2LengthIncrementorBtn);

        Button player1HitsBtn = findViewById(R.id.player1HitsCountIncrementorBtn);
        Button player2HitsBtn = findViewById(R.id.player2HitsCountIncrementorBtn);

        Button resetButton = findViewById(R.id.resetBtn);

        player1LengthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementPlayer1Length();
            }
        });

        player2LengthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementPlayer2Length();
            }
        });

        player1HitsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementPlayer1Hits();
            }
        });

        player2HitsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementPlayer2Hits();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScores();
            }
        });

    }

    private void incrementPlayer1Length() {
        changePlayer1Length(player1Length + player1Hits);
    }

    private void incrementPlayer2Length() {
        changePlayer2Length(player2Length + player2Hits);
    }

    private void incrementPlayer1Hits() {
        changePlayer1Hits(player1Hits + 1, false);
    }

    private void incrementPlayer2Hits() {
        changePlayer2Hits(player2Hits + 1, false);
    }

    private void resetScores() {
        player1Length = 0;
        player2Length = 0;
        player1Hits = 1;
        player2Hits = 1;

        changePlayer1Length(0);
        changePlayer2Length(0);
        changePlayer1Hits(1, true);
        changePlayer2Hits(1, true);
    }


    private void changePlayer1Length(int length) {
        player1Length = length;
        player1ScoreLengthText.setText(String.valueOf(length));
        player1HitsText.setText(String.valueOf(player1Hits));
    }

    private void changePlayer2Length(int length) {
        player2Length = length;
        player2ScoreLengthText.setText(String.valueOf(length));
        player2HitsText.setText(String.valueOf(player2Hits));
    }

    private void changePlayer1Hits(int hits, boolean isReset) {
        player1Hits = hits;
        if (isReset) {
            player1HitsText.setText("");
        } else {
            player1HitsText.setText(String.valueOf(hits));
        }
    }

    private void changePlayer2Hits(int hits, boolean isReset) {
        player2Hits = hits;
        if (isReset) {
            player2HitsText.setText("");
        } else {
            player2HitsText.setText(String.valueOf(hits));
        }
    }
}
