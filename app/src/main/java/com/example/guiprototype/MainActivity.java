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

        int rbombs = 6, bbombs = 6;
        int rmarshal = 1, bmarshal = 1;
        int rgeneral = 1, bgeneral = 1;
        int rcolonel = 2, bcolonel = 2;
        int rmajor = 3, bmajor = 3;
        int rcaptain = 4, bcaptain = 4;
        int rlieutenant = 4, blieutenant = 4;
        int rsergeant = 4, bsergeant = 4;
        int rminer = 5, bminer = 5;
        int rscout = 8, bscout = 8;
        int rspy = 1, bspy = 1;
        int rflag = 1, bflag = 1;
        int emptySpace = 20;

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
                if (rbombs > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.redb);
                    rbombs--;
                } else if (rmarshal > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red10);
                    rmarshal--;
                } else if (rgeneral > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red9);
                    rgeneral--;
                } else if (rcolonel > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red8);
                    rcolonel--;
                } else if (rmajor> 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red7);
                    rmajor--;
                } else if (rcaptain > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red6);
                    rcaptain--;
                } else if (rlieutenant > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red5);
                    rlieutenant--;
                } else if (rsergeant > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red4);
                    rsergeant--;
                } else if (rminer> 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red3);
                    rminer--;
                } else if (rscout > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red2);
                    rscout--;
                } else if (rspy > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.red1);
                    rspy--;
                } else if (rflag > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.redf);
                    rflag--;
                } else if (emptySpace > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.empty_space);
                    emptySpace--;
                } else if (bbombs > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blueb);
                    bbombs--;
                } else if (bmarshal > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue10);
                    bmarshal--;
                } else if (bgeneral > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue9);
                    bgeneral--;
                } else if (bcolonel > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue8);
                    bcolonel--;
                } else if (bmajor> 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue7);
                    bmajor--;
                } else if (bcaptain > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue6);
                    bcaptain--;
                } else if (blieutenant > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue5);
                    blieutenant--;
                } else if (bsergeant > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue4);
                    bsergeant--;
                } else if (bminer> 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue3);
                    bminer--;
                } else if (bscout > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue2);
                    bscout--;
                } else if (bspy > 0) {
                    gamePieces[i][j].setImageResource(R.drawable.blue1);
                    bspy--;
                } else {
                    gamePieces[i][j].setImageResource(R.drawable.bluef);
                    bflag--;
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

        /*
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
         */
    }

    public void setGamePiecesSizeDP(int layoutSizeDP) {
        //I think this code hard-codes the ImageButtons in dp
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, layoutSizeDP, getResources().getDisplayMetrics());
        params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, layoutSizeDP, getResources().getDisplayMetrics());
    }
}