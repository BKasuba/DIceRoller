package com.example.blackjack;

public class Player {
    private static int handValue = 0;
    private static int cash = 5000;
    private static int bet = 0;
    private static boolean bust = false;
    private static boolean stand = false;
    private static String hand = "";
      static MainActivity main = new MainActivity();

    public   void playerChoice(){

        main.mainMessage.setText("Press the button to hit or stand");

    }
    public static void playerBet(){
       // main.mainMessage.setText("Place your bet.");
        String x = main.betInput.getText().toString();
        if (x == ""){
            main.mainMessage.setText("Place your bet.");
        }else{
            Player.setBet(Integer.valueOf(x));
        }

    }
    public static void playerWin(){
        main.mainMessage.setText("You've won, congrats");
        Player.setCash(Player.getCash() + Player.getBet());
        main.playerCash.setText(Player.getCash());
    }

    public static int getHandValue() {
        return handValue;
    }

    public static void setHandValue(int handValue) {
        Player.handValue = handValue;
    }

    public static int getCash() {
        return cash;
    }

    public static void setCash(int cash) {
        Player.cash = cash;
    }

    public static int getBet() {
        return bet;
    }

    public static void setBet(int bet) {
        Player.bet = bet;
    }

    public static boolean isBust() {
        return bust;
    }

    public static void setBust(boolean bust) {
        Player.bust = bust;
    }

    public   boolean isStand() {
        return stand;
    }

    public static void setStand(boolean stand) {
        Player.stand = stand;
    }

    public static String getHand() {
        return hand;
    }

    public static void setHand(String hand) {
        Player.hand = hand;
    }
}
