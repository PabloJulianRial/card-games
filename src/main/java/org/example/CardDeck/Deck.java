package org.example.CardDeck;

import java.util.ArrayList;
import java.util.Collections;

//
public class Deck {

    public ArrayList<Card> inDeck = new ArrayList<>();

    // Constructor
    public Deck() {

        // suits array from enum values
        final String[] suits = new String[Suits.values().length];
        for (int i = 0; i < Suits.values().length; i++) {
            suits[i] = Suits.values()[i].getSuit();
        }
        // symbols array from enum values
        final String[] symbols = new String[Symbols.values().length];
        for (int h = 0; h < Symbols.values().length; h++) {
            symbols[h] = Symbols.values()[h].getSymbol();
        }
        //cards array
        for (String suit : suits) {
            for (int j = 0; j < symbols.length; j++) {
                inDeck.add(new Card(symbols[j], suit, j + 2));
            }
        }
    }


    public void printDeck() {
        for (Card card : inDeck) {
            System.out.print(card.getCard());
        }
    }

    public void shuffle() {
        Collections.shuffle(inDeck);
    }

    public Card dealCard() {
        Card newcard = inDeck.get(0);
        inDeck.remove(0);
        return newcard;
    }

    public void printHand(Card[] hand, String playerName) {
        for (Card card : hand) {
            System.out.print("|" + card.getCard() + "|  ");
        }
        System.out.println();
    }
}
