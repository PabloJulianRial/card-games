package org.example.Games;

import org.example.CardDeck.Card;
import org.example.CardDeck.Deck;

import java.util.Arrays;
import java.util.Scanner;

public class Poker {
    private final int ante = 50;
    String RED = "\u001B[31m";
    String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";
    String RESET = "\u001B[0m";
    private boolean isGameFinished = false;
    private int bank = 200;
    private int bet = 50;
    private Card[] playerHand = new Card[3];
    private Card[] computerHand = new Card[3];
    private int playerScore;
    private int computerScore;
    private Deck deck;
    private boolean isPlayerThreeOfOKind = false;
    private boolean isPlayerStraightFlush = false;
    private boolean isPlayerFlush = false;
    private boolean isPlayerStraight = false;
    private boolean isPlayerPairs = false;
    private boolean isPlayerKing = false;
    private boolean isPlayerAce = false;
    private boolean isPlayerQueen = false;
    private boolean isComputerThreeOfOKind = false;
    private boolean isComputerStraightFlush = false;
    private boolean isComputerFlush = false;
    private boolean isComputerStraight = false;
    private boolean isComputerPairs = false;
    private boolean isComputerKing = false;
    private boolean isComputerAce = false;
    private boolean isComputerQueen = false;
    private boolean computerWins = false;
    private boolean playerWins = false;


    public Poker() {
        this.deck = new Deck();
    }

    public void playPoker() {
        Scanner input = new Scanner(System.in);
        while (!isGameFinished) {
            deck.shuffle();
            playerHand[0] = deck.inDeck.get(0);
            playerHand[1] = deck.inDeck.get(1);
            playerHand[2] = deck.inDeck.get(2);
            computerHand[0] = deck.inDeck.get(3);
            computerHand[1] = deck.inDeck.get(4);
            computerHand[2] = deck.inDeck.get(5);

            System.out.println("Player's Hand: ");
            for (Card card : playerHand) {
                System.out.print("|" + card.getCard() + "|  ");
            }
            System.out.println();
            System.out.println("Computer's Hand: ");
            for (Card card : computerHand) {
                System.out.print("|" + card.getCard() + "|  ");
            }
            System.out.println();

            ////------------------check for three of a kind---------------------///////////
            if (computerHand[0].getValue() == computerHand[1].getValue() && computerHand[0].getValue() == playerHand[2].getValue()) {
                isComputerThreeOfOKind = true;
                System.out.println(RED + "Computer has Three of a kind " + RESET);
            }
            if (playerHand[0].getValue() == playerHand[1].getValue() && playerHand[0].getValue() == playerHand[2].getValue()) {
                isPlayerThreeOfOKind = true;
                System.out.println(RED + "Player has Three of a kind" + RESET);
            }

            ////------------------check for flush---------------------///////////
            if (computerHand[0].getSuit().equals(computerHand[1].getSuit()) && computerHand[1].getSuit().equals(computerHand[2].getSuit())) {
                isComputerFlush = true;
                System.out.println(YELLOW + "Computer has Flush" + RESET);
                for (Card card : computerHand) {
                    System.out.print(card.getSuit() + " ");
                }
                System.out.println();
            }
            if (playerHand[0].getSuit().equals(playerHand[1].getSuit()) && playerHand[1].getSuit().equals(playerHand[2].getSuit())) {
                isPlayerFlush = true;
                System.out.println(YELLOW + "Player has Flush" + RESET);
                for (Card card : playerHand) {
                    System.out.print(card.getSuit() + " ");
                }
                System.out.println();
            }

            ////------------------check for straight---------------------///////////
            Arrays.sort(computerHand);
            Arrays.sort(playerHand);

            if ((computerHand[1].getValue() - computerHand[0].getValue() == 1) && (computerHand[2].getValue() - computerHand[1].getValue() == 1)) {
                isComputerStraight = true;
                System.out.println(BLUE + "Computer has  a Straight " + RESET);
            }
            if ((playerHand[1].getValue() - playerHand[0].getValue() == 1) && (playerHand[2].getValue() - playerHand[1].getValue() == 1)) {
                isPlayerStraight = true;
                System.out.println(BLUE + "Player has a Straight " + RESET);
            }

            ////------------------check for straight flush---------------------///////////
            if (isComputerFlush && isComputerStraight) {
                isComputerStraightFlush = true;
            }
            if (isPlayerFlush && isPlayerStraight) {
                isPlayerStraightFlush = true;
            }
            ////------------------check for pairs ---------------------///////////
            if (computerHand[0].getValue() == computerHand[1].getValue() || computerHand[0].getValue() == playerHand[2].getValue() || computerHand[1].getValue() == playerHand[2].getValue()) {
                isComputerPairs = true;
                System.out.println(RED + "Computer has a pair " + RESET);
            }
            if (playerHand[0].getValue() == playerHand[1].getValue() || playerHand[0].getValue() == playerHand[2].getValue() || playerHand[1].getValue() == playerHand[2].getValue()) {
                isPlayerPairs = true;
                System.out.println(RED + "Player has a pair" + RESET);
            }
            ////------------------check for ace ---------------------///////////
            if (computerHand[0].getSymbol().equals("A") || computerHand[1].getSymbol().equals("A") || computerHand[2].getSymbol().equals("A")) {
                isComputerAce = true;
                System.out.println(RED + "Computer has an ACE " + RESET);
            }
            if (playerHand[0].getSymbol().equals("A") || playerHand[1].getSymbol().equals("A") || playerHand[2].getSymbol().equals("A")) {
                isPlayerAce = true;
                System.out.println(RED + "Player has an ACE" + RESET);
            }
            ////------------------check for King ---------------------///////////
            if (computerHand[0].getSymbol().equals("K") || computerHand[1].getSymbol().equals("K") || computerHand[2].getSymbol().equals("K")) {
                isComputerKing = true;
                System.out.println(RED + "Computer has a King " + RESET);
            }
            if (playerHand[0].getSymbol().equals("K") || playerHand[1].getSymbol().equals("K") || playerHand[2].getSymbol().equals("K")) {
                isPlayerKing = true;
                System.out.println(RED + "Player has a King" + RESET);
            }
            ////------------------check for Queen ---------------------///////////
            if (computerHand[0].getSymbol().equals("Q") || computerHand[1].getSymbol().equals("Q") || computerHand[2].getSymbol().equals("Q")) {
                isComputerQueen = true;
                System.out.println(RED + "Computer has a Queen " + RESET);
            }
            if (playerHand[0].getSymbol().equals("Q") || playerHand[1].getSymbol().equals("Q") || playerHand[2].getSymbol().equals("Q")) {
                isPlayerQueen = true;
                System.out.println(RED + "Player has a Queen" + RESET);
            }
            if (isComputerStraightFlush && !isPlayerStraightFlush) {
                computerWins = true;
            }
            if (isPlayerStraightFlush && !isComputerStraightFlush) {
                playerWins = true;
            }
            if (isComputerThreeOfOKind && !isPlayerThreeOfOKind) {
                computerWins = true;
            }
            if (isPlayerThreeOfOKind && !isComputerThreeOfOKind) {
                playerWins = true;
            }
            if (isComputerStraight && !isPlayerStraight) {
                computerWins = true;
            }
            if (!isComputerStraight && isPlayerStraight) {
                playerWins = true;
            }
            if (isComputerFlush && !isPlayerFlush) {
                computerWins = true;
            }
            if (!isComputerFlush && isPlayerFlush) {
                playerWins = true;
            }
            if (isComputerPairs && !isPlayerPairs) {
                computerWins = true;
            }
            if (!isComputerPairs && isPlayerPairs) {
                playerWins = true;
            }
            if (playerWins) {
                System.out.println("Player wins");
            }
            if (computerWins) {
                System.out.println("Computer wins");
            }
            System.out.println("You have: £" + bank + " in the bank");
            System.out.println("Ante: " + ante + "         Bet:" + bet);
            System.out.println("Enter your bet or enter 0 to fold");

            int newBet = input.nextInt();
            bet += newBet;
            System.out.println("Ante: " + ante + "         Bet:" + bet);

            for (Card card : computerHand) {
                System.out.println(card.getCard());
            }

            isGameFinished = true;
        }
    }
}
