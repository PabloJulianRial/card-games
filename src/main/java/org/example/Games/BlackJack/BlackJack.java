package org.example.Games.BlackJack;

import org.example.CardDeck.Card;
import org.example.CardDeck.Deck;
import org.example.UserInteractions.ListOfCommands;

import java.util.ArrayList;

public class BlackJack {
    int computerWon = 0;
    int userWon = 0;
    Deck cardDeck;
    ListOfCommands userInput;
    ArrayList<Card> userHand = new ArrayList<>();
    ArrayList<Card> computerHand = new ArrayList<>();
    int userStick = 0;
    int stopPlaying = 1;

    public void play(){
        cardDeck = new Deck();
        System.out.println("Welcome To The Wonderful World Of Java BlackJack");
        int playerScore;
        int computerScore;
        //
        for (Card card : cardDeck.inDeck) {
            if ((card.getSymbol().equals("J")) || (card.getSymbol().equals("Q")) || (card.getSymbol().equals("K")) ) {
                card.setValue(10);
            }
            else if (card.getSymbol().equals("A")) {
                card.setValue(11);
            }
        }

        userInput = new ListOfCommands();
        while (stopPlaying != 2) {
            start();
            playerScore = playerHand();
            if (playerScore != -1) {
                computerScore = computerHand();
                if (computerScore >= playerScore) {
                    System.out.println("COMPUTER GOT A BETTER SCORE COMPUTER WINS");
                    computerWon ++;
                }
                else {
                    System.out.println("AGAINST THE ODDS YOU BEAT THE HOUSE, IT MUST BE YOUR LUCKY NIGHT");
                    userWon++;
                }
            }
            else {
                // gambling may need to be added here
                System.out.println("YOU WENT BUST YOU BLOODY FOOL!");
                System.out.println("THE COMPUTER WINS THIS HAND MATEY");
                computerWon ++;
            }
            System.out.println("WOULD YOU LIKE TO PLAY ANOTHER ROUND? 1 for Yes 2 for No");
            stopPlaying = userInput.optionSelect();
            if (stopPlaying == 1) {
                cardDeck = new Deck();
                start();
            }
        }
    }

    private void start() {
        //cardDeck.printDeck();
        cardDeck.shuffle();
        userHand.add(cardDeck.dealCard());
        userHand.add(cardDeck.dealCard());
        computerHand.add(cardDeck.dealCard());
        computerHand.add(cardDeck.dealCard());
    }

    // return true if player sticks return false if player out
    private int playerHand() {
        int handValue = 0;

        for (Card card : userHand) {
            handValue += card.getValue();
        }

        for (Card card : userHand) {
            System.out.print(card.getSymbol());
            System.out.print(card.getSuit()  + " ");
        }
        while((handValue <= 21) && (userStick != 2)) {
            System.out.println();
            System.out.println("would you like to stick or twist 1/2");
            // read user input
            if(userInput.optionSelect() == 1) {
                userHand.add(cardDeck.dealCard());

                for (Card card : userHand) {
                    System.out.print(card.getSymbol());
                    System.out.print(card.getSuit());
                    System.out.println();

                    handValue += card.getValue();

                }
            }
            else {
                // player sticks below 21
                return handValue;
            }
        }
        // player is over 21
        System.out.println("reached");
        return -1;

    }

    // How does this end ?
    private int computerHand() {
        // Print User Hand Symbols
        int handValue = 0;
        while((handValue <= 21) & (userStick != 2)) {
            handValue = 0;
            for (Card card : computerHand) {
                handValue += card.getValue();
                System.out.print(card.getSymbol());
                System.out.print(card.getSuit() + " ");
            }
            System.out.println();
            if (computerDecision(handValue)) {
                computerHand.add(cardDeck.dealCard());
            } else {
                userStick = 2;
                return handValue;
            }
        }
        System.out.println("LUCKY YOU THE COMPUTER WENT BUST!");
        return -1;
    }

    private boolean computerDecision(int value)  {
        return value < 17;
    }

}