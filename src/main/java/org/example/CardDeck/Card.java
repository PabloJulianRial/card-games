package org.example.CardDeck;

public class Card implements Comparable<Card> {

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

    public String getSymbol() {
        return symbol;
    }

    public String getCard() {
        return symbol + suit;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    // MAYBE
    public void Deal() {
        isDealt = true;
    }

    public String toString() {
        return null;
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(otherCard.value, this.value);
    }
}
