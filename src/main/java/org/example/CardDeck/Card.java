package org.example.CardDeck;

//A class used to Model a playing card.
//It should have the following:
//String suit: Unicode characters for heart, club, diamond, and spade.
//String symbol: (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A)
//int value: (2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
//Encapsulation should be used to hide the data
//toString method for class description


public class Card {



    private final String symbol;
    private final String suit;
    private final int value;
    //MAYBE
    private boolean isDealt = false;

    public Card(String symbol, String suit, int value) {
        this.symbol = symbol;
        this.suit = suit;
        this.value = value;
    }

    //int value: (2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    //method that will return the value of each symbol, different for each game
    public int[] getValues() {
        return new int[0];
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCard() {
        return symbol + suit;
    }

    public String getSuit() { return suit; }

    public int getValue() {return value;}

    // MAYBE
    public void Deal() {
        isDealt = true;
    }

    public String toString() {
        return null;
    }
}
