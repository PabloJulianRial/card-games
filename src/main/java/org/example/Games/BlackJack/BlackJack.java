package org.example.Games.BlackJack;

import org.example.CardDeck.Card;
import org.example.CardDeck.Deck;
import org.example.UserInteractions.FileRead;
import org.example.UserInteractions.ListOfCommands;
import org.example.UserInteractions.UserPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private Deck cardDeck;
    private ListOfCommands userInput;
    private ArrayList<Card> userHand = new ArrayList<>();
    private ArrayList<Card> computerHand = new ArrayList<>();
    private int userStick = 0;
    private int stopPlaying = 1;
    private final FileRead leaderBoard = new FileRead("src/main/java/org/example/Assets/BlackJackScores.txt");
    private int playerBank = 200;
    private UserPlayer user;
    private int bet = 0;

    public void play(){
        cardDeck = new Deck();
        user = new UserPlayer();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome To The Wonderful World Of Java BlackJack");
        System.out.println("Please enter your name:");
        String player = input.nextLine();

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
                    playerBank = playerBank - bet;
                    System.out.println("YOU lost £" + bet + " THAT MEANS YOU HAVE £" + playerBank + " IN THE BANK");
                }
                else {
                    System.out.println("AGAINST THE ODDS YOU BEAT THE HOUSE, IT MUST BE YOUR LUCKY NIGHT");
                    playerBank = playerBank + bet;
                    System.out.println("YOU WON £" + bet + " THAT MEANS YOU HAVE £" + playerBank + " IN THE BANK");
                }
            }

            else {
                // gambling may need to be added here
                System.out.println("YOU WENT BUST YOU BLOODY FOOL!");
                System.out.println("THE COMPUTER WINS THIS HAND MATEY");
                playerBank = playerBank - bet;
                System.out.println("YOU lost £" + bet + " THAT MEANS YOU HAVE £" + playerBank + " IN THE BANK");
            }
            System.out.println("WOULD YOU LIKE TO PLAY ANOTHER ROUND? 1 for Yes 2 for No");
            stopPlaying = userInput.optionSelect();
            if (stopPlaying == 1) {
                cardDeck = new Deck();
                start();
            }
            else {
                leaderBoard.writeScore(player, playerBank);
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

        System.out.println("Dealers Hand");
        System.out.println(computerHand.get(0).getCard());

        System.out.println("You have " + playerBank + " in the bank, please enter your bet below");
        bet = user.getBet(playerBank);
        System.out.println("Bet: £" + bet);

        for (Card card : userHand) {
            System.out.print(card.getSymbol());
            System.out.print(card.getSuit()  + " ");
            handValue += card.getValue();
        }

        while((handValue <= 21) && (userStick != 2)) {
            System.out.println();
            System.out.println("would you like to twist or stick 1/2");
            if (userInput.optionSelect() == 1) {
                userHand.add(cardDeck.dealCard());
                handValue = 0;
                for (Card card : userHand) {
                    System.out.print(card.getSymbol());
                    System.out.print(card.getSuit());
                    handValue += card.getValue();
                }
                System.out.println();
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
        System.out.println("LUCKY YOU THE COMPUTER WENT BUST!");
        return -1;
    }

    private boolean computerDecision(int value)  {
        return value < 17;
    }

}