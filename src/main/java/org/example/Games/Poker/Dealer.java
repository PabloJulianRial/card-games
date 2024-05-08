package org.example.Games.Poker;

import org.example.CardDeck.Card;
import org.example.CardDeck.Deck;

public class Dealer {

    static HandState newState = new HandState();

    public void dealHands(Card[] playerHand, Card[] computerHand) {
        Deck deck = new Deck();
        for (int i = 0; i < playerHand.length; i++) {
            deck.shuffle();
            playerHand[i] = deck.dealCard();
            computerHand[i] = deck.dealCard();
        }
    }

    public void printHand(Card[] hand, String playerName) {
        for (Card card : hand) {
            System.out.print("|" + card.getCard() + "|  ");
        }
        System.out.println();
    }

    public void checkHands(Card[] playerHand, Card[] computerHand) {
        if (computerHand[0].getValue() == computerHand[1].getValue() && computerHand[0].getValue() == playerHand[2].getValue()) {
            newState.isComputerThreeOfOKind = true;
            newState.isCombination = true;
        }
        if (playerHand[0].getValue() == playerHand[1].getValue() && playerHand[0].getValue() == playerHand[2].getValue()) {
            newState.isPlayerThreeOfOKind = true;
            newState.isCombination = true;
        }
        if (computerHand[0].getSuit().equals(computerHand[1].getSuit()) && computerHand[1].getSuit().equals(computerHand[2].getSuit())) {
            newState.isComputerFlush = true;
            newState.isCombination = true;
        }
        if (playerHand[0].getSuit().equals(playerHand[1].getSuit()) && playerHand[1].getSuit().equals(playerHand[2].getSuit())) {
            newState.isPlayerFlush = true;
            newState.isCombination = true;
        }
        if ((computerHand[0].getValue() - computerHand[1].getValue() == 1) && (computerHand[1].getValue() - computerHand[2].getValue() == 1)) {
            newState.isComputerStraight = true;
            newState.isCombination = true;
        }
        if ((playerHand[0].getValue() - playerHand[1].getValue() == 1) && (playerHand[1].getValue() - playerHand[2].getValue() == 1)) {
            newState.isPlayerStraight = true;
            newState.isCombination = true;
        }
        if (computerHand[0].getValue() == computerHand[1].getValue() || computerHand[0].getValue() == computerHand[2].getValue() || computerHand[1].getValue() == computerHand[2].getValue()) {
            newState.isComputerPairs = true;
            newState.isCombination = true;
        }
        if (playerHand[0].getValue() == playerHand[1].getValue() || playerHand[0].getValue() == playerHand[2].getValue() || playerHand[1].getValue() == playerHand[2].getValue()) {
            newState.isPlayerPairs = true;
            newState.isCombination = true;
        }
        if (computerHand[0].getSymbol().equals("A") || computerHand[1].getSymbol().equals("A") || computerHand[2].getSymbol().equals("A")) {
            newState.isComputerAce = true;
        }
        if (playerHand[0].getSymbol().equals("A") || playerHand[1].getSymbol().equals("A") || playerHand[2].getSymbol().equals("A")) {
            newState.isPlayerAce = true;
        }
        if (computerHand[0].getSymbol().equals("K") || computerHand[1].getSymbol().equals("K") || computerHand[2].getSymbol().equals("K")) {
            newState.isComputerKing = true;
        }
        if (playerHand[0].getSymbol().equals("K") || playerHand[1].getSymbol().equals("K") || playerHand[2].getSymbol().equals("K")) {
            newState.isPlayerKing = true;
        }
        if (computerHand[0].getSymbol().equals("Q") || computerHand[1].getSymbol().equals("Q") || computerHand[2].getSymbol().equals("Q")) {
            newState.isComputerQueen = true;
        }
        if (playerHand[0].getSymbol().equals("Q") || playerHand[1].getSymbol().equals("Q") || playerHand[2].getSymbol().equals("Q")) {
            newState.isPlayerQueen = true;
        }
    }

    public void determineWinner(Card[] playerHand, Card[] computerHand, String player) {
        if (newState.isComputerStraightFlush) {
            if (!newState.isPlayerStraightFlush) {
                newState.computerWins = true;
                System.out.println("Computer has Straight flush!!");

            } else {
                System.out.println(player + " has Straight flush and " + playerHand[0].getSymbol() + " high");
                System.out.println("Computer has Straight flush and " + computerHand[0].getSymbol() + " high");
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    newState.playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    newState.computerWins = true;
                } else {
                    newState.itsATie = true;
                }
            }
        } else {
            if (newState.isPlayerStraightFlush) {
                System.out.println(player + " has Straight flush!!");
                newState.playerWins = true;
            }
        }
        if (newState.isComputerThreeOfOKind) {
            if (!newState.isPlayerThreeOfOKind) {
                System.out.println("Computer has 3 of a kind, 3 " + computerHand[0].getSymbol() + "'s");
                newState.computerWins = true;
            } else {
                System.out.println(player + " has 3 of a kind, 3 " + playerHand[0].getSymbol() + "'s");
                System.out.println("Computer has 3 of a kind, 3 " + computerHand[0].getSymbol() + "'s");
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    System.out.println(player);
                    newState.playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    newState.computerWins = true;
                } else {
                    newState.itsATie = true;
                }
            }
        } else {
            if (newState.isPlayerThreeOfOKind) {
                System.out.println(player + " has 3 of a kind, 3 " + playerHand[0].getSymbol() + "'s");
                newState.playerWins = true;
            }
        }
        if (newState.isComputerStraight) {
            if (!newState.isPlayerStraight) {
                System.out.println("Computer has a straight ");
                newState.computerWins = true;
            } else {
                System.out.println(player + " has a straight and " + playerHand[0].getValue() + " high");
                System.out.println("Computer has a straight and " + computerHand[0] + " high");
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    newState.playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    newState.computerWins = true;
                } else {
                    newState.itsATie = true;
                }
            }
        } else {
            if (newState.isPlayerStraight) {
                System.out.println(player + " has a straight ");
                newState.playerWins = true;
            }
        }
        if (newState.isComputerFlush) {
            if (!newState.isPlayerFlush) {
                System.out.println("Computer has a flush");
                newState.computerWins = true;
            } else {
                System.out.println(player + " has a flush and " + playerHand[0].getSymbol() + " high");
                System.out.println("Computer has a flush and " + computerHand[0].getSymbol() + " high");
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    newState.playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    newState.computerWins = true;
                } else {
                    newState.itsATie = true;
                }
            }
        } else {
            if (newState.isPlayerFlush) {
                System.out.println(player + " has a flush");
                newState.playerWins = true;
            }
        }
        if (newState.isComputerPairs) {
            if (!newState.isPlayerPairs) {
                System.out.println("Computer has a pair of " + computerHand[1].getSymbol() + "'s");
                newState.computerWins = true;
            } else {
                System.out.println("Computer has a pair of " + computerHand[1].getSymbol() + "'s");
                System.out.println(player + " has a pair of " + playerHand[1].getSymbol() + "'s");
                if (playerHand[1].getValue() > computerHand[1].getValue()) {

                    newState.playerWins = true;
                } else if (playerHand[1].getValue() < computerHand[1].getValue()) {

                    newState.computerWins = true;
                } else {
                    if (playerHand[0].getValue() + playerHand[1].getValue() + playerHand[2].getValue() > computerHand[0].getValue() + computerHand[1].getValue() + computerHand[2].getValue()) {
                        newState.playerWins = true;
                    } else if (playerHand[0].getValue() + playerHand[1].getValue() + playerHand[2].getValue() < computerHand[0].getValue() + computerHand[1].getValue() + computerHand[2].getValue()) {
                        newState.computerWins = true;
                    } else {
                        newState.itsATie = true;
                    }
                }
            }
        } else {
            if (newState.isPlayerPairs) {
                System.out.println(player + " has a pair");
                newState.playerWins = true;
            }
        }

        if (!newState.isCombination) {
            if (playerHand[0].getValue() > computerHand[0].getValue()) {
                System.out.println(player + " has " + playerHand[0].getSymbol() + " high");
                newState.playerWins = true;
            } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                System.out.println("Computer has " + computerHand[0].getSymbol() + " high");
                newState.computerWins = true;
            } else {
                if (playerHand[1].getValue() > computerHand[1].getValue()) {
                    System.out.println(player + " has " + playerHand[0].getSymbol() + " high and a " + playerHand[1].getSymbol());
                    newState.playerWins = true;
                } else if (playerHand[1].getValue() < computerHand[1].getValue()) {
                    System.out.println("Computer has " + computerHand[0].getSymbol() + " high and a " + computerHand[1].getSymbol());
                    newState.computerWins = true;
                } else {
                    if (playerHand[2].getValue() > computerHand[2].getValue()) {
                        System.out.println(player + " has " + playerHand[0].getSymbol() + " high,  a " + playerHand[1].getSymbol() + " and a " + playerHand[2].getSymbol());
                        newState.playerWins = true;
                    } else if (playerHand[2].getValue() < computerHand[2].getValue()) {
                        System.out.println("Computer has " + computerHand[0].getSymbol() + " high,  a " + computerHand[1].getSymbol() + " and a " + computerHand[2].getSymbol());
                        newState.computerWins = true;
                    } else {
                        newState.itsATie = true;
                    }
                }
            }
        }

    }

    public boolean hasLessThanQueenHigh(Card[] computerHand) {
        if (!(newState.isComputerPairs || newState.isComputerThreeOfOKind || newState.isComputerFlush || newState.isComputerStraight)) {
            int highestValue = 0;
            for (Card card : computerHand) {
                if (card.getValue() > highestValue) {
                    highestValue = card.getValue();
                }
            }
            return highestValue < 12;
        }
        return false;
    }

}
