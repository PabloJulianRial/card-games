package org.example.CardDeck;

import java.util.ArrayList;
import java.util.Collections;

//
public class Deck {


    ArrayList<Card> inDeck = new ArrayList<>();

    //MAYBE
    ArrayList<Card> inPlay = new ArrayList<>();

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
            System.out.println(card.getCard());
        }

    }

    public void shuffle() {
        Collections.shuffle(inDeck);
    }

    public Card dealCard() {

        //MAYBE
        inDeck.get(0).Deal();

        //MAYBE
        inPlay.add(inDeck.get(0));
        inDeck.remove(0);

        return inDeck.get(0);
    }

//    public void sortDeck() {
//            Number Order .comapreTo function as in Zoology
//                    .if number equal compare by suit
//    }


//    // OVERLOADED METHOD
//    public void sortDeck(Comparator<T> comparator) {
//    //        Sort by value(in game value eg. Queen of spades being 26)
//    }


//    public void resetDeck() {
//    //        All Cards returned to InDeck.
//    }


}
