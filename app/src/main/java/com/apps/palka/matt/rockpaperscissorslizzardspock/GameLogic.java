package com.apps.palka.matt.rockpaperscissorslizzardspock;

import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by matt on 31.12.2017.
 */

public class GameLogic {

    /**
     * 1 = rock
     * 2 = paper
     * 3 = scissors
     * 4 = lizard
     * 5 = spock
     */
    private int mPlayerChoice;
    private int mOpponentChoice;

    private int mRock1 = R.drawable.ic_stone;
    private int mPaper2 = R.drawable.ic_paper;
    private int mScissors3 = R.drawable.ic_scissors;
    private int mLizard4 = R.drawable.ic_lizard;
    private int mSpock5 = R.drawable.ic_spock;

    private int mPlayerStat = 0;
    private int mOpponentStat = 0;

    public int getPlayerStat() {
        return mPlayerStat;
    }



    public int getOpponentStat() {
        return mOpponentStat;
    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int computerChoice() {
        int result = ThreadLocalRandom.current().nextInt(1, 6);

        switch (result) {
            case 1:
                mOpponentChoice = mRock1;
                break;
            case 2:
                mOpponentChoice = mPaper2;
                break;
            case 3:
                mOpponentChoice = mScissors3;
                break;
            case 4:
                mOpponentChoice = mLizard4;
                break;
            default:
                mOpponentChoice = mSpock5;
                break;
        }
        return result;
    }

    public void setPlayerOneChoice(int choice) {
        switch (choice) {
            case 1:
                mPlayerChoice = 1;
                break;
            case 2:
                mPlayerChoice = 2;
                break;
            case 3:
                mPlayerChoice = 3;
                break;
            case 4:
                mPlayerChoice = 4;
                break;
            case 5:
                mPlayerChoice = 5;
                break;
        }
    }

    public int getPlayerChoice() {
        return mPlayerChoice;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public int getOpponentChoice() {
        computerChoice();
        return mOpponentChoice;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void gameResult(OnePlayerGameActivity gameActivity) {
        TextView result = (TextView) gameActivity.findViewById(R.id.game_result_textView);
        final ImageButton choseRockButton = (ImageButton) gameActivity.findViewById(R.id.rock_button_player);
        final ImageButton chosePaperButton = (ImageButton) gameActivity.findViewById(R.id.paper_button_player);
        final ImageButton choseScissorsButton = (ImageButton) gameActivity.findViewById(R.id.scissors_button_player);
        final ImageButton choseLizardButton = (ImageButton) gameActivity.findViewById(R.id.lizard_button_player);
        final ImageButton choseSpockButton = (ImageButton) gameActivity.findViewById(R.id.spock_button_player);
        Button playAgain = (Button) gameActivity.findViewById(R.id.play_again_button);


        getPlayerChoice();

        /**
         * Turning off play buttons in order to wait for new turn
         */
        choseLizardButton.setEnabled(false);
        chosePaperButton.setEnabled(false);
        choseRockButton.setEnabled(false);
        choseScissorsButton.setEnabled(false);
        choseSpockButton.setEnabled(false);

        //shows playAgain button
        playAgain.setVisibility(View.VISIBLE);

        int computer = computerChoice();

        if (mPlayerChoice == computer) {
            result.setText(R.string.draw);
        } else if (mPlayerChoice == 1) { //ROCK
            switch (computer) {
                case 1: //ROCK

                    break;
                case 2:  //PAPER
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 3: //SCISSORS
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 4: //LIZARD
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 5: //SPOCK
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
            }
        } else if (mPlayerChoice == 2) { //PAPER
            switch (computer) {
                case 1: //ROCK
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 2: //PAPER
                    break;
                case 3: //SCISSORS
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 4: //LIZARD
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 5: //SPOCK
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
            }

        } else if (mPlayerChoice == 3) { //SCISSORS
            switch (computer) {
                case 1: //ROCK
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 2: //PAPER
                    mPlayerStat++;

                    result.setText(R.string.you_won);
                    break;
                case 3: //SCISSORS

                    break;
                case 4: //LIZARD
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 5: //SPOCK
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
            }

        } else if (mPlayerChoice == 4) { //LIZARD
            switch (computer) {
                case 1: //ROCK
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 2: //PAPER
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 3: //SCISSORS
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 4: //LIZARD

                    break;
                case 5: //SPOCK
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
            }

        } else { //SPOCK
            switch (computer) {
                case 1: //ROCK
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 2: //PAPER
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 3: //SCISSORS
                    mPlayerStat++;
                    result.setText(R.string.you_won);
                    break;
                case 4: //LIZARD
                    mOpponentStat++;
                    result.setText(R.string.you_lost);
                    break;
                case 5: //SPOCK

                    break;
            }

        }
    }

}
