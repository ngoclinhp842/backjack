/**
 * File: Blackjack.java
 * Author: Linh Phan
 * Date: 02/08/2022
 * 
 * This class should have only a main function that executes 1000 games of Blackjack. 
 * The code should create and re-use a single Blackjack object. 
 * It should keep track of how many games the player wins, 
 * how many the dealer wins, and many are pushes. 
 * Print out the total in the end both as raw numbers and as percentages.
*/


public class Simulation {
    public static void main (String[] args){
        // create a blackjack to reuse 
        Blackjack blackjack = new Blackjack(26);
        String game_state = "";
        int playerWin = 0;
        int dealerWin = 0;
        int tie = 0;
        float percentPlayer = 0f;
        float percentDealer = 0f;
        float percentTie = 0f;

        for (int i = 0; i < 1000; i++){
            int result = blackjack.game(false);
        
            // update number of time dealer wins
            if (result == -1){
                dealerWin += 1;
            }
            // update number of time player wins
            if (result == 1){
                playerWin += 1;
            }
            // update number of tie
            if (result == 0){
                tie += 1;
            }
        }

        // calculate the percentage for each outcome
        percentPlayer = (playerWin / 1000f) * 100f;
        percentDealer = (dealerWin / 1000f) * 100f;
        percentTie = (tie / 1000f) * 100f;

        game_state += "1000 times smulations.\n";
        game_state += "The player wins " + playerWin + " times. ";
        game_state += "The dealer wins " + dealerWin + " times.\n";
        game_state += "The percentage of player winning is " + percentPlayer + ".\n";
        game_state += "The percentage of dealer winning is " + percentDealer + ".\n";
        game_state += "The percentage tie is " + percentTie + ".\n";
        System.out.println(game_state);

    }
}
