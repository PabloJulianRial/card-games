package org.example.Games;

import org.example.CardDeck.Card;
import org.example.CardDeck.Dealer;
import org.example.CardDeck.Deck;
import org.example.UserInteractions.FileRead;
import org.example.UserInteractions.UserPlayer;

import java.util.Arrays;
import java.util.Scanner;

public class Poker {

    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    public final Deck deck;
    private final Dealer dealer;
    private final UserPlayer user;
    private final Card[] playerHand = new Card[3];
    private final Card[] computerHand = new Card[3];
    private final FileRead instructions = new FileRead("src/main/java/org/example/Assets/PokerRules");
    private final FileRead leaderBoard = new FileRead("src/main/java/org/example/Assets/PokerScores.txt");
    private boolean isGameFinished = false;
    private int bank = 200;
    private int bet = 0;
    private int ante = 0;
    private int pot = 0;

    public Poker() {
        this.deck = new Deck();
        this.dealer = new Dealer(deck);
        this.user = new UserPlayer();
    }

    public void playPoker() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name:");
        String player = input.nextLine();
        System.out.println(YELLOW + "Welcome " + player + ", let's play some poker. Here is £200 to get you started. Good luck!" + RESET);
        while (!isGameFinished) {

            dealer.dealHands(playerHand, computerHand);

            Arrays.sort(computerHand);
            Arrays.sort(playerHand);
            System.out.println(player + " has: £" + bank + " in the bank \uD83D\uDCB0");
            System.out.println();
            System.out.println(GREEN + "Place ante to see your cards" + RESET);
            ante = user.getBet(bank);
            System.out.println("Ante: £" + ante);
            System.out.println();
            System.out.println(CYAN + player + "'s Hand: " + RESET);
            dealer.printHand(playerHand, player);

            System.out.println(GREEN + "Enter your bet to see computer's cards or 0 to fold" + RESET);
            bet = user.getBet(bank);
            System.out.println("Bet: £" + bet);
            if (bet == 0) {
                System.out.println(RED + player + " has folded and lost the ante: " + ante + RESET);
                System.out.println();

                System.out.println(player + " has: £" + bank + "in the bank");
                bet = input.nextInt();
                System.out.println("Bet: £" + bet);
            } else if (bet < 0) {
                System.out.println("Invalid bet, bet must be positive integer");
                bet = input.nextInt();
                System.out.println("Bet: £" + bet);
            } else if (bet > bank) {
                System.out.println("you don't have that much money to bet. You've only got " + bank + "to bet");
            } else {
                System.out.println();
                System.out.println(PURPLE + "Computer's Hand: " + RESET);
                System.out.println();
                dealer.printHand(computerHand, "Computer");
                System.out.println();
                System.out.println(CYAN + player + "'s Hand: " + RESET);
                System.out.println();
                dealer.printHand(playerHand, player);
                System.out.println();
                dealer.checkHands(playerHand, computerHand);
                dealer.determineWinner(playerHand, computerHand, player);
                pot = bet + ante;
                if (dealer.computerWins) {
                    System.out.println(RED + "Computer wins" + RESET);
                    bank -= pot;
                    System.out.println("Player looses: £" + pot);
                } else if (dealer.playerWins) {
                    bank += pot;
                    System.out.println(GREEN + player + " wins" + RESET);
                    System.out.println(player + " gets £ " + pot + " added to the bank");
                } else {
                    System.out.println("It's a tie. Bet and ante stay in the table.");
                }
                System.out.println();
                System.out.println(player + " has " + bank + " in the bank");
                System.out.println("Play another round: (enter 'y' for yes or any other letter for no)");
                String playAgain = String.valueOf(Character.toUpperCase(input.next().charAt(0)));
                dealer.resetBooleans();
                if (!playAgain.equals("Y")) {
                    leaderBoard.writeScore(player, bank);
                    isGameFinished = true;
                }
            }
        }
    }
}