package com.example.blackjack;

import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Dealer {
      static MainActivity main = new MainActivity();
    private static String hand = "";
    private static int handValue = 0;
    private static boolean bust = false;
    private static boolean stand = false;
    private static int houseTotal = 10000;

    private static String card = "";
    private static int cardValue = 0;
    private static int cardsInDeck = 52;
    private static int cardsUsed = 51;

    public static void drawCard(){

        //0 is value 1 is the suit
        setCard(Deck.deck[getCardsUsed()][0] + " of " + Deck.deck[getCardsUsed()][1]);
        cardValue = deriveValue(Deck.deck[getCardsUsed()][0]);
        setCardsInDeck(getCardsInDeck() - 1);
        main.deck.setText(getCardsInDeck());
        setCardsUsed(getCardsUsed() - 1);
        if(getCardsUsed() == 0){
            Dealer.shuffle();
        }

    }
    public static int deriveValue(String x){
        if(x.equals("king") || x.equals("Queen") || x.equals("Jack")){
            x = "10";
        }else if(x.equals("Ace")){
            x = "11";
        }
        return Integer.valueOf(x);
    }

    public static void shuffle(){
        int suitShuffle;
        int valueShuffle;
        String temp = "";
        Random shuffleCard = new Random();

        for(int i = 0; i < Deck.deck.length; i++){
            suitShuffle = shuffleCard.nextInt(51) + 1;
            temp = Deck.deck[suitShuffle][0];
            Deck.deck[suitShuffle][0] = Deck.deck[i][0];
            Deck.deck[i][0] = temp;
        }
        for(int i = 0; i < Deck.deck.length; i++){
            valueShuffle = shuffleCard.nextInt(51) + 1;
            temp = Deck.deck[valueShuffle][1];
            Deck.deck[valueShuffle][0] = Deck.deck[i][1];
            Deck.deck[i][1] = temp;
        }
        setCardsInDeck(52);
        setCardsUsed(51);
    }

    public static void dealToPlayer(){
        Dealer.drawCard();
        Player.setHand(getCard());
        Player.setHandValue(getCardValue());
        //second card being dealt
        Dealer.drawCard();
        Player.setHand(Player.getHand() + ", " + getCard());
        Player.setHandValue(Player.getHandValue() + getCardValue());

    }

    public static void dealToDealer(){
        Dealer.drawCard();
        Dealer.setHand(getCard());
        Dealer.setHandValue(getCardValue());

        Dealer.drawCard();
        Dealer.setHand(Dealer.getHand() + ", " + getCard());
        Dealer.setHandValue(Dealer.getHandValue() + getCardValue());
    }

    public   void dealerChoice(){
        while(Dealer.getHandValue() < 17){
        Moves.hitToDealer();
        if(Dealer.getHandValue() > 21){
            Dealer.setBust(true);
        }

        }
        Dealer.setStand(true);
    }
    public static void win(){
        if(Player.isBust() == true){
            main.dealerHandDIsplay.setText(Dealer.getHand());

            main.mainMessage.setText("You've bust!");
        }else{
            main.mainMessage.setText("You had the weaker hand");
        }
        Player.setCash(Player.getCash() - Player.getBet());
        Dealer.setHouseTotal(Dealer.getHouseTotal() + Player.getBet());
    }


    public static String getHand() {
        return hand;
    }

    public static void setHand(String hand) {
        Dealer.hand = hand;
    }

    public static int getHandValue() {
        return handValue;
    }

    public static void setHandValue(int handValue) {
        Dealer.handValue = handValue;
    }

    public static boolean isBust() {
        return bust;
    }

    public static void setBust(boolean bust) {
        Dealer.bust = bust;
    }

    public   boolean isStand() {
        return stand;
    }

    public static void setStand(boolean stand) {
        Dealer.stand = stand;
    }

    public static int getHouseTotal() {
        return houseTotal;
    }

    public static void setHouseTotal(int houseTotal) {
        Dealer.houseTotal = houseTotal;
    }

    public static String getCard() {
        return card;
    }

    public static void setCard(String card) {
        Dealer.card = card;
    }

    public static int getCardValue() {
        return cardValue;
    }

    public   void setCardValue(int cardValue) {
        Dealer.cardValue = cardValue;
    }

    public static int getCardsInDeck() {
        return cardsInDeck;
    }

    public static void setCardsInDeck(int cardsInDeck) {
        Dealer.cardsInDeck = cardsInDeck;
    }

    public static int getCardsUsed() {
        return cardsUsed;
    }

    public static void setCardsUsed(int cardsUsed) {
        Dealer.cardsUsed = cardsUsed;
    }


}
