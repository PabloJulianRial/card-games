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
        cardDeck = new Deck();
        cardDeck.shuffle();
        for (Card card : cardDeck.inDeck) {
            if ((card.getSymbol().equals("J")) || (card.getSymbol().equals("Q")) || (card.getSymbol().equals("K")) ) {
                card.setValue(10);
            }
            else if (card.getSymbol().equals("A")) {
                card.setValue(11);
            }
        }
        userStick = 1;
        userHand.removeAll(userHand);
        computerHand.removeAll(computerHand);
        userHand.add(cardDeck.dealCard());
        userHand.add(cardDeck.dealCard());
        computerHand.add(cardDeck.dealCard());
        computerHand.add(cardDeck.dealCard());
    }

    private int playerHand() {
        int handValue = 0;
        int lowAceHandValue = 0;
        for (Card card : userHand) {
            handValue += card.getValue();
            if (card.getSymbol().equals("A")) {
                lowAceHandValue = handVAlue
            }
        }

        for (Card card : userHand) {
            System.out.print(card.getSymbol());
            System.out.print(card.getSuit()  + " ");
        }
        while((handValue <= 21) && (userStick != 2)) {
            //System.out.println("value of hand start " + handValue);
            System.out.println();
            System.out.println("would you like to twist or stick 1/2");
            // read user input
            if (userInput.optionSelect() == 1) {
                userHand.add(cardDeck.dealCard());
                handValue = 0;
                for (Card card : userHand) {
                    System.out.print(card.getSymbol());
                    System.out.print(card.getSuit());
                    //System.out.print(card.getValue());
                    handValue += card.getValue();
                }
                System.out.println();
               // System.out.println("value of hand " + handValue);
            } else {
                return handValue;
            }
        }
        return -1;

    }
    private int computerHand() {
        int handValue = 0;
        while((handValue <= 21) & (userStick != 2)) {
            handValue = 0;
            for (Card card : computerHand) {
                handValue += card.getValue();
                System.out.print(card.getSymbol());
                System.out.print(card.getSuit() + " ");
                //System.out.println("handValue" + handValue);
            }
            System.out.println();
            if (computerDecision(handValue)) {
                computerHand.add(cardDeck.dealCard());
                int lastIndex = computerHand.size() - 1;
                handValue += computerHand.get(lastIndex).getValue();
            } else {
                userStick = 2;
                return handValue;
            }
        }
        for (Card card : computerHand) {
            System.out.print(card.getSymbol());
            System.out.print(card.getSuit() + " ");
           // System.out.println("handValue" + handValue);
        }
        //System.out.println("handValue" + handValue);
        System.out.println();
        System.out.println("LUCKY YOU THE COMPUTER WENT BUST!");
        return -1;
    }

    private boolean computerDecision(int value)  {
        return value < 17;
    }

}