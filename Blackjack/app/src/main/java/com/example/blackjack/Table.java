package com.example.blackjack;

public class Table {
      static MainActivity main = new MainActivity();
    private   boolean game = true;



    public static void opening(){
        Dealer.dealToPlayer();
        main.playerHandDisplay.setText(Player.getHand());
        main.mainMessage.setText("Enter bet amount and tap place bet");
        Dealer.dealToDealer();
    }
    public static void handCheck(){
        //player busts
        if(Player.isBust() == true){
            Dealer.win();
            softReset();
        }
        //dealer busts
        if(Dealer.isBust() == true){
            Player.playerWin();
        }
        //Player has stronger hand
        if(Player.getHandValue() > Dealer.getHandValue()){
            Player.playerWin();
            softReset();
        }else if(Player.getHandValue() < Dealer.getHandValue()){
            Dealer.win();
            softReset();
        }
    }
    public static void softReset(){
        Dealer.setHand("");
        Dealer.setHandValue(0);
        Dealer.setBust(false);
        Dealer.setStand(false);

        Player.setHand("");
        Player.setHandValue(0);
        Player.setBust(false);
        Player.setStand(false);


    }
    public   void hardReset(){
        softReset();
        Dealer.setCardsInDeck(52);
        Dealer.setCardsUsed(51);
    }
    public static void bustCheck(){
        if(Player.getHandValue()>21 || Player.isBust() == true){
            Dealer.win();
        }
        if(Dealer.isBust() == true){
            Player.playerWin();
        }
    }
}
