package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public static  void main(String args[]){
        Deck.initialiseDeck();
        Dealer.shuffle();
        Table.opening();
    }
    TextView mainMessage = this.findViewById(R.id.mainText);
    TextView dealerHandValue = this.findViewById(R.id.dealerHandValue);
    TextView playerHandDisplay = this.findViewById(R.id.playerHandDIsplay);
    TextView dealerHandDIsplay = this.findViewById(R.id.dealerHandDisplay);
    TextView playerCash = this.findViewById(R.id.playerCash);
    TextView deck = this.findViewById(R.id.deckStatus);
    // TextView house = this.findViewById(R.id.)
    EditText betInput = this.findViewById(R.id.betInput);
    public void onClickBetting (View view){

        Player.playerBet();

    }
    public void onClickHit (View view){
        Moves.hitToPlayer();
        Table.bustCheck();
        Table.handCheck();

    }
    public void onClickStand(View view){
        Player.setStand(true);
        Table.handCheck();
    }





}
