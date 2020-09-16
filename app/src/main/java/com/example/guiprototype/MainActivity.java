package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    ImageButton[][] gamePieces = new ImageButton[10][10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * External Citation, will finish citation later if keeping this code
         * Sources: https://stackoverflow.com/questions/3477581/android-add-a-view-to-a-specific-layout-from-code
         *          https://stackoverflow.com/questions/5255184/android-and-setting-width-and-height-programmatically-in-dp-units
         */
        ViewGroup gameBoardGrid = (ViewGroup) findViewById(R.id.gameBoardGrid);
        setGamePiecesSizeDP(75);
        //populating game board GridLayout with game piece ImageButtons
        //might need to change this to an onDraw method, but for now it's fine
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gamePieces[i][j] = new ImageButton(this);
                if (i < 5) {
                    gamePieces[i][j].setImageResource(R.drawable.red10);
                } else {
                    gamePieces[i][j].setImageResource(R.drawable.blue6);
                }
                gamePieces[i][j].setLayoutParams(params);
                gamePieces[i][j].setScaleType(ImageView.ScaleType.FIT_XY);
                //using setOnClickListener right now only to test if buttons are unique and clickable, this will be unique class later
                gamePieces[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageButton test = (ImageButton) view;
                        Log.i("button", "Clicked on " + test.getId());
                    }
                });
                gamePieces[i][j].setId(Integer.parseInt(i+""+j));
                gameBoardGrid.addView(gamePieces[i][j]);
            }
        }

        setGamePiecesSizeDP(65);
        //making player's graveyard to view on gui
        ViewGroup playerGY = (ViewGroup) findViewById(R.id.playerGY);
        for (int k = 1; k < 13; k++) {
            ImageButton playerPiece = new ImageButton(this);
            playerPiece.setLayoutParams(params);
            playerPiece.setImageResource(R.drawable.blue6);
            playerPiece.setScaleType(ImageView.ScaleType.FIT_XY);
            playerGY.addView(playerPiece);
        }

        //making opp's graveyard to view on gui
        ViewGroup oppGY = (ViewGroup) findViewById(R.id.oppGY);
        for (int l = 1; l < 13; l++) {
            ImageButton oppPiece = new ImageButton(this);
            oppPiece.setLayoutParams(params);
            oppPiece.setImageResource(R.drawable.red10);
            oppPiece.setScaleType(ImageView.ScaleType.FIT_XY);
            oppGY.addView(oppPiece);
        }
    }

    public void setGamePiecesSizeDP(int layoutSizeDP) {
        //I think this code hard-codes the ImageButtons in dp
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, layoutSizeDP, getResources().getDisplayMetrics());
        params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, layoutSizeDP, getResources().getDisplayMetrics());
    }
}