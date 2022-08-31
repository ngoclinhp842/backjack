/**
 * File: Blackjack.java
 * Author: Linh Phan
 * Date: 02/08/2022
 * Course: CS231 A
 * Project 1
 * 
 * Blackjack class implements a simple version of the card game. 
 * The class will need to have fields for a Deck, a Hand for the player, 
 * a Hand for the dealer, and a field for the number of cards below which 
 * the deck must be reshuffled. The main function for the Blackjack class 
 * should implement one complete game.
 * 
 * How to run: enter "javac Blackjack.java"
 *          then enter "java Blackjack"
 * 
 */


public class Blackjack {
    /* the constructor should store the reshuffleCutoff and set up a game. 
    You can avoid duplicate code by calling the reset() method.
    The class will need to have fields for a Deck, a Hand for the player, 
    a Hand for the dealer, and a field for the number of cards below which 
    the deck must be reshuffled. The main function for the Blackjack class 
    should implement one complete game.
    */
    private int cutoff;
    private Deck deckPlay;
    private Hand handPlayer;
    private Hand handDealer;
    
    public Blackjack(int reshuffleCutoff ) {
        cutoff = reshuffleCutoff;
        deckPlay = new Deck();
        handDealer = new Hand();
        handPlayer = new Hand();
        // dynamic momery lost every time shuffle() is called
        deckPlay.shuffle();
    }

    /* reset the game. 
    Both the player Hand and dealer Hand should start with no cards. 
    If the number of cards in the deck is less than the reshuffle cutoff, 
    then the method should create a fresh (complete), shuffled deck. 
    Otherwise, it should not modify the deck, just clear the player and dealer hands.
    */
    public void reset() {
        // Both the player Hand and dealer Hand should start with no cards. 
        // dynamic momery pointed by handDealer and handPlayer lost when reset() is called
        handDealer = new Hand();
        handPlayer = new Hand();

        // If the number of cards in the deck is less than the reshuffle cutoff, 
        // then the method should create a fresh (complete), shuffled deck. 
        if (deckPlay.size() < cutoff){
            deckPlay = new Deck();
            // dynamic momery lost
            deckPlay.shuffle();
        }
    }

    // deal out two cards to both players from the Deck.
    public void deal() {
        handPlayer.add(deckPlay.deal());
        handDealer.add(deckPlay.deal());
        handPlayer.add(deckPlay.deal());
        handDealer.add(deckPlay.deal());
    }

    /*
    have the player draw cards until the total value of the player's hand is equal to or above 16. 
    The method should return false if the player goes over 21 (bust).
    */
    public boolean playerTurn() {
        while (!(handPlayer.getTotalValue() >= 16)){
            Card card = deckPlay.deal();
            handPlayer.add(card);
        }

        if (handPlayer.getTotalValue() > 21){
            return false;
        }
        return true;
    }

    // have the dealer draw cards until the total of the dealer's hand is equal to or above 17. 
    // The method should return false if the dealer goes over 21.
    public boolean dealerTurn() {
        while (!(handDealer.getTotalValue() >= 17)){
            Card card = deckPlay.deal();
            handDealer.add(card);
        }   

        if (handDealer.getTotalValue() > 21){
            return false;
        }
        return true;
    }

    // assign the new cutoff value to the internal reshuffle cutoff field.
    public void setReshuffleCutoff(int numCutoff)  {
        this.cutoff = numCutoff;
    }

    // returns the current value of the reshuffle cutoff field.
    public int getReshuffleCutoff() {
        return this.cutoff;
    }

    /*
    returns a String that has represents the state of the game. 
    It may be helpful to show the player and dealer hands as well as their current total value.
    */
    public String toString(){
        String gameState = "";
        gameState += "Player's value: " + handPlayer.getTotalValue() + "\n";
        gameState += "Dealer's value: " + handDealer.getTotalValue() + "\n";
        return gameState;
    }

    /*
    play a single game of Blackjack following the procedure outlined above. 
    The game method should return a -1 if the dealer wins, 0 in case of a push (tie), and a 1 if the player wins.
    If the parameter verbose is true, then the game method should print out 
    the initial and final hands of the game and a statement about the result (dealer/push/player).
    */
    public int game(boolean verbose){
        // call the reset method at the start of each game. 
        reset();
        
        // deal out two cards to players
        deal();

        // print out the initial hands of game
        if (verbose) {System.out.println("Initial hand:\n" + toString());}
        
        // dealer turn will happen only if player do not burst
        if (playerTurn()){
            dealerTurn();
        }

        // print out the result statement 
        if (handPlayer.getTotalValue() > 21 && handDealer.getTotalValue() <= 21){
            if (verbose) {System.out.println("The dealer wins. The game state:\n" + toString());}
            return -1;
        }
        else if (handDealer.getTotalValue() > 21 && handPlayer.getTotalValue() <= 21){
            if (verbose) {System.out.println("The player wins. The game state:\n" + toString());}
            return 1;
        }
        else if (handPlayer.getTotalValue() > handDealer.getTotalValue()){
            if (verbose) {System.out.println("The player wins. The game state:\n" + toString());}
            return 1;
        }
        else if (handDealer.getTotalValue() > handPlayer.getTotalValue()){
            if (verbose) {System.out.println("The dealer wins. The game state:\n" + toString());}
            return -1;
        }
        else
        {
            if (verbose) {System.out.println("There is a tie. The game state:\n" + toString());}
            return 0;
        }
            
        
    }

    public static void main (String[] args) {
        Blackjack blackjack = new Blackjack(26);

        // TESTING
        // System.out.println("Set up game:\n" + game);

        // // deal the two cards to 2 players
        // game.reset();
        
        // System.out.println("Initial deck: " + game.deckPlay);
        // game.deal();
        // System.out.println("Deck after deal:\n" + game);

        // game.playerTurn();
        // game.dealerTurn();
        // System.out.println("Deck after play: " + game.deckPlay);
        // System.out.println("Final game state:\n" + game);

        System.out.println("The first game.");
        blackjack.game(true);
        System.out.println("The second game.");
        blackjack.game(true);
        System.out.println("The third game.");
        blackjack.game(true);


    }
}
