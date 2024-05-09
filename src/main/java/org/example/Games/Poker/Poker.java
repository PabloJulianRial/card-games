package org.example.Games.Poker;

import org.example.CardDeck.Card;
import org.example.CardDeck.Deck;
import org.example.UserInteractions.FileRead;
import org.example.UserInteractions.UserPlayer;

import java.util.Arrays;
import java.util.Scanner;

public class Poker {

    public final Deck deck;
    private final Dealer dealer;
    private final UserPlayer user;
    private final Card[] playerHand = new Card[3];
    private final Card[] computerHand = new Card[3];
    private final FileRead leaderBoard = new FileRead("src/main/java/org/example/Assets/PokerScores.txt");
    private int bank = 200;

    public Poker() {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.user = new UserPlayer();
    }

    public void playPoker() {
        boolean isGameFinished = false;
        System.out.println();
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name:");
        String player = input.nextLine();
        System.out.println(Color.YELLOW + "Welcome " + player + ", let's play some poker. Here is £200 to get you started. Good luck!" + Color.RESET);
        while (!isGameFinished) {
            dealer.dealHands(playerHand, computerHand);
            Arrays.sort(computerHand);
            Arrays.sort(playerHand);
            System.out.println(player + " has: £" + bank + " in the bank \uD83D\uDCB0");
            System.out.println();
            System.out.println(Color.GREEN + "Place ante to see your cards" + Color.RESET);
            int ante = user.getBet(bank);
            System.out.println("Ante: £" + ante);
            System.out.println();
            System.out.println(Color.CYAN + player + "'s Hand: " + Color.RESET);
            dealer.printHand(playerHand, player);

            System.out.println(Color.GREEN + "Enter your bet to see computer's cards or 0 to fold" + Color.RESET);
            int bet = user.getBet(bank);
            System.out.println("Bet: £" + bet);
            if (bet == 0) {
                System.out.println(Color.RED + player + " has folded and lost the ante: " + ante + Color.RESET);
                System.out.println();
                bank -= ante;
                System.out.println(player + " has: £" + bank + " in the bank");
                System.out.println("Play another round: (enter 'y' for yes or any other letter for no)");
                String playAgain = String.valueOf(Character.toUpperCase(input.next().charAt(0)));
                Dealer.newState.resetBooleans();
                if (!playAgain.equals("Y")) {
                    leaderBoard.writeScore(player, bank);
                    isGameFinished = true;
                }
            } else if (bet < 0) {
                System.out.println("Invalid bet, bet must be positive integer");
                bet = input.nextInt();
                System.out.println("Bet: £" + bet);
            } else if (bet > bank) {
                System.out.println("you don't have that much money to bet. You've only got " + bank + "to bet");
            } else {
                System.out.println();
                System.out.println(Color.PURPLE + "Computer's Hand: " + Color.RESET);
                dealer.printHand(computerHand, "Computer");
                System.out.println();
                System.out.println(Color.CYAN + player + "'s Hand: " + Color.RESET);
                dealer.printHand(playerHand, player);
                System.out.println();
                dealer.checkHands(playerHand, computerHand);
                if (dealer.hasLessThanQueenHigh(computerHand)) {
                    System.out.println("Computer has less than Queen high. Dealing cards again...");
                    continue;
                }
                dealer.determineWinner(playerHand, computerHand, player);
                int pot = bet + ante;
                if (Dealer.newState.computerWins) {
                    System.out.println(Color.RED + "Computer wins" + Color.RESET);
                    bank -= pot;
                    System.out.println("Player looses: £" + pot);
                } else if (Dealer.newState.playerWins) {
                    bank += pot;
                    System.out.println(Color.GREEN + player + " wins" + Color.RESET);
                    System.out.println(player + " gets £ " + pot + " added to the bank");
                } else {
                    System.out.println("It's a tie. Bet and ante stay in the table.");
                }
                System.out.println();
                System.out.println(player + " has " + bank + " in the bank");

                System.out.println("Play another round: (enter 'y' for yes or any other letter for no)");
                String playAgain = String.valueOf(Character.toUpperCase(input.next().charAt(0)));
                Dealer.newState.resetBooleans();
                if (bank <= 0) {
                    System.out.println(Color.RED + "Not so fast cowboy, you've lost all your money, go home." + Color.RESET);
                    isGameFinished = true;
                    break;
                }
                if (!playAgain.equals("Y")) {
                    leaderBoard.writeScore(player, bank);
                    isGameFinished = true;
                }
            }
        }
    }

}