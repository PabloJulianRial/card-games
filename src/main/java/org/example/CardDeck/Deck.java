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
        String[] suits = {"❤️", "♦️", "♣️", "♠️"};
        for (String suit : suits) {
            String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
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

    public static void main (String [] args) {
        Deck Cards = new Deck();
        Cards.shuffle();
        Cards.printDeck();

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
