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
    ArrayList<Card> userHand = new ArrayList<Card>();
    ArrayList<Card> computerHand = new ArrayList<Card>();
    int userStick = 0;
    int stopPlaying = 1;

    public void play(){
        cardDeck = new Deck();
        userInput = new ListOfCommands();
        while (stopPlaying != 2) {
            Start();
            if (playerHand()) {
                computerHand();
            }
            else {
                computerWon ++;
            }
            stopPlaying = userInput.optionSelect();
            endGame();
        }
    }

    private void Start() {
        //cardDeck.printDeck();
        cardDeck.shuffle();
        userHand.add(cardDeck.dealCard());
        userHand.add(cardDeck.dealCard());
        computerHand.add(cardDeck.dealCard());
        computerHand.add(cardDeck.dealCard());
    }

    // return true if player sticks return false if player out
    private boolean playerHand() {
        int handValue = 0;

        for (Card card : userHand) {
            handValue += card.getValue();
        }

        for (Card card : userHand) {
            System.out.print(card.getSymbol());
            System.out.print(card.getSuit());
            System.out.println();
        }
        while((handValue <= 21) && (userStick != 2)) {
            System.out.println("hand value" + handValue);
            System.out.println("would you like to stick or twist 1/2");
            // read user input
            if(userInput.optionSelect() == 1) {
                userHand.add(cardDeck.dealCard());
                for (Card card : userHand) {
                    System.out.print(card.getSymbol());
                    System.out.print(card.getSuit());
                    System.out.println();
                }
                for (Card card : userHand) {
                    handValue += card.getValue();
                }
            }
            else {
                // player sticks below 21
                return true;
            }
        }
        // player is over 21
        return false;

    }

    // How does this end ?
    private void computerHand() {
        // Print User Hand Symbols
        int handValue = 0;
        while((handValue <= 21) & (userStick != 2)) {
            for (Card card : userHand) {
                handValue += card.getValue();
            }
            if (computerDecision(handValue)) {
                userHand.add(cardDeck.dealCard());
            } else {
                userStick = 2;
            }
        }
    }

    private boolean computerDecision(int value)  {
            return value >= 17;
        }

    public void endGame() {
            int userScore = 0;
            int computerScore = 0;

        for (Card card : userHand) {
            userScore += card.getValue();
        }

        for (Card card : computerHand) {
            computerScore += card.getValue();
        }

        if (computerScore >= userScore) {
            computerWon ++;
        }
        else {
            userWon++;
        }


            // compare the values of the two hands
            // add points to the winning hand
            //
    }


//            Computer.add(DealCards())
//            Computer.add(DealCards())
//

//UserInterface.blackJackCommands()
//    Userinterface - receive input

}
