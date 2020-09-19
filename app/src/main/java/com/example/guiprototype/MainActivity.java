package com.example.guiprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
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

import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    ViewGroup.LayoutParams params;  //this will hold the layout_width and layout_height for the ImageButtons
    ViewGroup gameBoardGrid;    //this will be the GridLayout from the xml
    ImageButton[][] gamePieces = new ImageButton[10][10];

    //instance vars to know how many of each type of game piece to make
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * External Citation
         * Date:    18 September 2020
         * Problem: Using wrap_content for 10 ImageButtons in a row couldn't fit all of them on one screen width
         *
         * Sources: https://stackoverflow.com/questions/4743116/get-screen-width-and-height-in-android
         * Solution:    I used the code from this post to make the ImageButtons' width relative to the screen
         */
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.width = (Resources.getSystem().getDisplayMetrics().widthPixels) / 11;;
        params.height = params.width;   //setting height to width to make a square game piece later

        /**
         * External Citation
         * Date:    12 September 2020
         * Problem: Wanted a way to make 100 ImageButtons programatically rather than through xml
         *
         * Sources: https://stackoverflow.com/questions/3477581/android-add-a-view-to-a-specific-layout-from-code
         * Solution:    I used the code from this post, swapped their TextView for an ImageButton, and put the code in a nested for loop
         */
        gameBoardGrid = (ViewGroup) findViewById(R.id.gameBoardGrid);
        //initializing the gamePieces ImageButton 2d array
        //TODO: might need to change this to an onDraw method
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
                gamePieces[i][j].setId(Integer.parseInt(i+""+j));
            }
        }

        //randomizing red pieces' pos, then blue pieces' pos, then the pieces in the middle two rows
        randomizeGamePieces(0,5,0,10);
        randomizeGamePieces(5,10,0,10);
        randomizeGamePieces(4,6,0,10);

        //putting the gamePiece ImageButtons in the gameBoard GridLayout
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoardGrid.addView(gamePieces[i][j]);
            }
        }
    }

    //randomizes the game pieces in the region given by the parameters
    public void randomizeGamePieces(int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart < 0 || rowEnd < 0 || colStart < 0 || colEnd < 0 ||
            rowStart > 9 || rowEnd > 9 || colStart > 9 || colEnd > 9) {
            return;
        }

        ImageButton temp;
        Random rand = new Random();
        int randRow, randCol;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                //find random coord on board that is not a wall
                do {
                    randRow = rand.nextInt(rowEnd - rowStart) + rowStart;
                    randCol = rand.nextInt(colEnd - colStart) + colStart;
                } while (isCoordWall(randRow, randCol));

                //only swaps pieces if piece at (i, j) is not a wall
                if (!isCoordWall(i, j)) {
                    temp = gamePieces[i][j];
                    gamePieces[i][j] = gamePieces[randRow][randCol];
                    gamePieces[randRow][randCol] = temp;
                }
            }
        }
    }

    //returns true if coodinates given by parameters is a wall that a game piece can't be placed on, else false
    public boolean isCoordWall(int x, int y) {
        return ((x== 4 && (y == 1 || y == 2 || y == 7 || y == 8)) ||
                (x == 5 && (y == 1 || y == 2 || y == 7 || y == 8)));
    }
}