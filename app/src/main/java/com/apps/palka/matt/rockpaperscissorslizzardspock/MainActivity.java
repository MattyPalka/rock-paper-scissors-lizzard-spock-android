package com.apps.palka.matt.rockpaperscissorslizzardspock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get a reference to the one player button on the main view
        TextView onePlayerGameButton = (TextView) findViewById(R.id.one_player_game);
        //get a reference to the two players button on the main view
        TextView twoPlayersGameButton = (TextView) findViewById(R.id.two_players_game);
        //get a reference to the game rules button on the main view
        TextView gameRulesButton = (TextView) findViewById(R.id.game_rules);

        onePlayerGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OnePlayerGameActivity.class);
                startActivity(intent);
            }
        });

        twoPlayersGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), TwoPlayersActivity.class);
                startActivity(intent);
            }
        });

        gameRulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RulesActivity.class);
                startActivity(intent);
            }
        });

    }
}
