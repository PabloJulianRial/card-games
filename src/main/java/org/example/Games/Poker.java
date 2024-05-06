package org.example.Games;

import org.example.CardDeck.Card;
import org.example.CardDeck.Deck;
import org.example.UserInteractions.FileRead;

import java.util.Arrays;
import java.util.Scanner;

public class Poker {

    private static final String GREEN = "\u001B[32m";
    private final Card[] playerHand = new Card[3];
    private final Card[] computerHand = new Card[3];
    private final Deck deck;
    private final FileRead fileRead = new FileRead("src/main/java/org/example/Assets/RulesPoker");
    String RED = "\u001B[31m";
    String CYAN = "\u001B[36m";
    String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";
    String PURPLE = "\u001B[35m";
    String RESET = "\u001B[0m";
    private boolean isGameFinished = false;
    private int bank = 200;
    private String player = "Pablo";
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
    private boolean isCombination = false;
    private boolean itsATie = false;
    private String playAgain = "y";

    public Poker() {
        this.deck = new Deck();

    }

    public void playPoker() {
        System.out.println();
        Scanner input = new Scanner(System.in);
        fileRead.readAllScores();
        System.out.println("Please enter your name:");
        player = input.nextLine();
        while (!isGameFinished) {
            deck.shuffle();
            playerHand[0] = deck.inDeck.get(0);
            playerHand[1] = deck.inDeck.get(1);
            playerHand[2] = deck.inDeck.get(2);
            computerHand[0] = deck.inDeck.get(3);
            computerHand[1] = deck.inDeck.get(4);
            computerHand[2] = deck.inDeck.get(5);
            Arrays.sort(computerHand);
            Arrays.sort(playerHand);
            System.out.println(player + " has: £" + bank + " in the bank \uD83D\uDCB0");
            System.out.println();
            System.out.println(GREEN + "Place ante:" + RESET);
            int ante = input.nextInt();
            System.out.println();
            System.out.println("Ante: " + ante);
            System.out.println();
            System.out.println(CYAN + player + "'s Hand: " + RESET);
            System.out.println();
            for (Card card : playerHand) {
                System.out.print("|" + card.getCard() + "|  ");
            }
            System.out.println();
            System.out.println();
            System.out.println(GREEN + "Enter your bet or enter 0 to fold" + RESET);
            int bet = input.nextInt();
            System.out.println("Bet: " + bet);
            if (bet == 0) {
                System.out.println(RED + player + " has folded and lost the ante: " + ante + RESET);
                System.out.println();
                bank -= ante;
                System.out.println(player + " has: £" + bank + "in the bank");
                break;
            } else {
                System.out.println();
                System.out.println(PURPLE + "Computer's Hand: " + RESET);
                System.out.println();
                for (Card card : computerHand) {
                    System.out.print("|" + card.getCard() + "|  ");
                }
                if (computerHand[0].getValue() < 12) {
                    System.out.println("Computer doesn't qualify (less than Queen high)");
                    break;
                }
                System.out.println();
                ////------------------check for three of a kind---------------------///////////
                if (computerHand[0].getValue() == computerHand[1].getValue() && computerHand[0].getValue() == playerHand[2].getValue()) {
                    isComputerThreeOfOKind = true;
                    isCombination = true;
                }
                if (playerHand[0].getValue() == playerHand[1].getValue() && playerHand[0].getValue() == playerHand[2].getValue()) {
                    isPlayerThreeOfOKind = true;
                    isCombination = true;
                }
                ////------------------check for flush---------------------///////////
                if (computerHand[0].getSuit().equals(computerHand[1].getSuit()) && computerHand[1].getSuit().equals(computerHand[2].getSuit())) {
                    isComputerFlush = true;
                    isCombination = true;
                }
                if (playerHand[0].getSuit().equals(playerHand[1].getSuit()) && playerHand[1].getSuit().equals(playerHand[2].getSuit())) {
                    isPlayerFlush = true;
                    isCombination = true;
                }
                ////------------------check for straight---------------------///////////
                if ((computerHand[1].getValue() - computerHand[0].getValue() == 1) && (computerHand[2].getValue() - computerHand[1].getValue() == 1)) {
                    isComputerStraight = true;
                    isCombination = true;
                }
                if ((playerHand[1].getValue() - playerHand[0].getValue() == 1) && (playerHand[2].getValue() - playerHand[1].getValue() == 1)) {
                    isPlayerStraight = true;
                    isCombination = true;
                }
                ////------------------check for pairs ---------------------///////////
                if (computerHand[0].getValue() == computerHand[1].getValue() || computerHand[0].getValue() == computerHand[2].getValue() || computerHand[1].getValue() == playerHand[2].getValue()) {
                    isComputerPairs = true;
                    isCombination = true;
                }
                if (playerHand[0].getValue() == playerHand[1].getValue() || playerHand[0].getValue() == playerHand[2].getValue() || playerHand[1].getValue() == playerHand[2].getValue()) {
                    isPlayerPairs = true;
                    isCombination = true;
                }
                ////------------------check for ace ---------------------///////////
                if (computerHand[0].getSymbol().equals("A") || computerHand[1].getSymbol().equals("A") || computerHand[2].getSymbol().equals("A")) {
                    isComputerAce = true;
                }
                if (playerHand[0].getSymbol().equals("A") || playerHand[1].getSymbol().equals("A") || playerHand[2].getSymbol().equals("A")) {
                    isPlayerAce = true;
                }
                ////------------------check for King ---------------------///////////
                if (computerHand[0].getSymbol().equals("K") || computerHand[1].getSymbol().equals("K") || computerHand[2].getSymbol().equals("K")) {
                    isComputerKing = true;
                }
                if (playerHand[0].getSymbol().equals("K") || playerHand[1].getSymbol().equals("K") || playerHand[2].getSymbol().equals("K")) {
                    isPlayerKing = true;
                }
                ////------------------check for Queen ---------------------///////////
                if (computerHand[0].getSymbol().equals("Q") || computerHand[1].getSymbol().equals("Q") || computerHand[2].getSymbol().equals("Q")) {
                    isComputerQueen = true;
                }
                if (playerHand[0].getSymbol().equals("Q") || playerHand[1].getSymbol().equals("Q") || playerHand[2].getSymbol().equals("Q")) {
                    isPlayerQueen = true;
                }
                //---------------------check who wins-----------------------------------
                //---------------comp has straight flush------------------
                if (isComputerStraightFlush) {
                    if (!isPlayerStraightFlush) {
                        computerWins = true;
                        //-----------------------both straight flush----------------------
                    } else {
                        if (playerHand[0].getValue() > computerHand[0].getValue()) {
                            playerWins = true;
                        } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                            computerWins = true;
                        } else {
                            itsATie = true;
                        }
                    }
                }
                //--------------player has straight flush--------------------------------
                else {
                    if (isPlayerStraightFlush) {
                        playerWins = true;
                    }
                }
                //-------------------computer has 3 of a kind------------------

                if (isComputerThreeOfOKind) {
                    if (!isPlayerThreeOfOKind) {
                        computerWins = true;
                        //both 3 of a kind----------------------
                    } else {
                        if (playerHand[0].getValue() > computerHand[0].getValue()) {
                            playerWins = true;
                        } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                            computerWins = true;
                        } else {
                            itsATie = true;
                        }
                    }
                    //------------------player has 3 of a kind---------------------------
                } else {
                    if (isPlayerThreeOfOKind) {
                        playerWins = true;
                    }
                }
                //---------------comp has straight ------------------
                if (isComputerStraight) {
                    if (!isPlayerStraight) {
                        computerWins = true;
                        //-----------------------------both straight----------------------
                    } else {
                        if (playerHand[0].getValue() > computerHand[0].getValue()) {
                            playerWins = true;
                        } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                            computerWins = true;
                        } else {
                            itsATie = true;
                        }
                    }
                }
                //--------------player has straight --------------------------------
                else {
                    if (isPlayerStraight) {
                        playerWins = true;
                    }
                }
                //------------------computer has flush-----------------
                if (isComputerFlush) {
                    if (!isPlayerFlush) {
                        computerWins = true;
                        //------------------------both flush----------------------
                    } else {
                        if (playerHand[0].getValue() > computerHand[0].getValue()) {
                            playerWins = true;
                        } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                            computerWins = true;
                        } else {
                            itsATie = true;
                        }
                    }
                } else {
                    if (isPlayerFlush) {
                        playerWins = true;
                    }
                }
                //-----------------------computer pairs------------------------
                if (isComputerPairs) {
                    if (!isPlayerPairs) {
                        computerWins = true;
                        //------------------------both pairs----------------------
                    } else {
                        if (playerHand[0].getValue() > computerHand[0].getValue()) {
                            playerWins = true;
                        } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                            computerWins = true;
                        } else {
                            if (playerHand[2].getValue() > computerHand[2].getValue()) {
                                playerWins = true;
                            } else if (playerHand[2].getValue() < computerHand[2].getValue()) {
                                computerWins = true;
                            } else {
                                itsATie = true;
                            }
                        }
                    }
                } else {
                    if (isPlayerPairs) {
                        playerWins = true;
                    }
                }
                //--------------------if there are no combinations-------------------------------
                if (!isCombination) {
                    if (playerHand[0].getValue() > computerHand[0].getValue()) {
                        playerWins = true;
                    } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                        computerWins = true;
                    } else {
                        if (playerHand[1].getValue() > computerHand[1].getValue()) {
                            playerWins = true;
                        } else if (playerHand[1].getValue() < computerHand[1].getValue()) {
                            computerWins = true;
                        } else {
                            if (playerHand[2].getValue() > computerHand[2].getValue()) {
                                playerWins = true;
                            } else if (playerHand[2].getValue() < computerHand[2].getValue()) {
                                computerWins = true;
                            } else {
                                itsATie = true;
                            }
                        }
                    }
                }
                if (playerWins) {
                    bank += bet;
                    bank += ante;
                    System.out.println();
                    System.out.println(YELLOW + player + " wins!! \uD83D\uDE00" + RESET);
                    System.out.println();
                    System.out.println(player + " wins: " + (ante + bet));
                    System.out.println(player + " has: £" + bank + "in the bank \uD83D\uDCB0");
                }
                if (computerWins) {
                    bank -= bet;
                    bank -= ante;
                    System.out.println(BLUE + "Computer wins!!" + RESET);
                    System.out.println();
                    System.out.println(RED + player + " looses: " + (ante + bet) + RESET);
                    System.out.println(player + " has: £" + bank + " in the bank \uD83D\uDCB0");
                    if (bank <= 0) {
                        System.out.println(RED + "You run out of money! ☹" + RESET);
                        isGameFinished = true;
                    }
                }
                System.out.println("Play another round: (enter 'y' for yes or any other letter for no)");
                playAgain = String.valueOf(Character.toUpperCase(input.next().charAt(0)));
                if (!playAgain.equals("Y")) {
                    fileRead.writeScore(player, bank);
                    isGameFinished = true;

                } else {
                    isGameFinished = false;

                }
            }

        }
    }

}
