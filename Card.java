/**
 * File: Card.java
 * Author: Linh Phan
 * Date: 02/08/2022
 * Course: CS231 A
 * Project 1
 * 
 * Card class hold all information unique to the card
 * 
 * How to run: enter "javac Card.java" in the terminal
 *          then enter "java Card"
 */

public class Card {
    // a field that specifies the card value.
    private int value;
    
    // a constructor with the value of the card, possibly doing range checking.
    public Card(int v) {
        this.value = v;
    }
        
    // return the numeric value of the card.
    public int getValue() {
        return value;
    }

    /* return a string that represents the Card object. 
    This will override the default toString method in the Object class.
    */
    public String toString() {
        return "" + value;
    }

    public static void main (String[] args) {
        Card D = new Card(12);
        System.out.println(D.toString());
        System.out.println((D.getValue()));
    }
}
