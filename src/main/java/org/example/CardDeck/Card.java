package org.example.CardDeck;

public class Card implements Comparable<Card> {

    private final String symbol;
    private final String suit;
    private final int value;

    public Card(String symbol, String suit, int value) {
        this.symbol = symbol;
        this.suit = suit;
        this.value = value;
    }


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

    public String toString() {
        return null;
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(otherCard.value, this.value);
    }
}
