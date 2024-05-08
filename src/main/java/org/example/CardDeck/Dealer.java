// Dealer.java
package org.example.CardDeck;

public class Dealer {
    private final Deck deck;
    public boolean isComputerThreeOfOKind = false;
    public boolean isCombination = false;
    public boolean isPlayerThreeOfOKind = false;
    public boolean isComputerFlush = false;
    public boolean isPlayerFlush = false;
    public boolean isComputerStraight = false;
    public boolean isPlayerStraight = false;
    public boolean isComputerPairs = false;
    public boolean isPlayerPairs = false;
    public boolean isComputerAce = false;
    public boolean isPlayerAce = false;
    public boolean isComputerKing = false;
    public boolean isPlayerKing = false;
    public boolean isComputerQueen = false;
    public boolean isPlayerQueen = false;
    public boolean isComputerStraightFlush = false;
    public boolean isPlayerStraightFlush = false;
    public boolean computerWins = false;
    public boolean playerWins = false;
    public boolean itsATie = false;


    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public void dealHands(Card[] playerHand, Card[] computerHand) {
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
        if ((computerHand[0].getValue() - computerHand[1].getValue() == 1) && (computerHand[1].getValue() - computerHand[2].getValue() == 1)) {
            isComputerStraight = true;
            isCombination = true;
        }
        if ((playerHand[0].getValue() - playerHand[1].getValue() == 1) && (playerHand[1].getValue() - playerHand[2].getValue() == 1)) {
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
    }

    public void determineWinner(Card[] playerHand, Card[] computerHand, String player) {
        //---------------------check who wins-----------------------------------
        //---------------comp has straight flush------------------
        if (isComputerStraightFlush) {
            if (!isPlayerStraightFlush) {
                computerWins = true;
                System.out.println("Computer has Straight flush!!");
                //-----------------------both straight flush----------------------
            } else {
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    System.out.println(player + " has Straight flush and " + playerHand[0].getSymbol() + " high");
                    System.out.println("Computer has Straight flush and " + computerHand[0].getSymbol() + " high");
                    playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    System.out.println("Computer has Straight flush and " + computerHand[0].getSymbol() + " high");
                    System.out.println(player + " has Straight flush and " + playerHand[0].getSymbol() + " high");
                    computerWins = true;
                } else {
                    itsATie = true;
                }
            }
        }
        //--------------player has straight flush--------------------------------
        else {
            if (isPlayerStraightFlush) {
                System.out.println(player + " has Straight flush!!");
                playerWins = true;
            }
        }
        //-------------------computer has 3 of a kind------------------

        if (isComputerThreeOfOKind) {
            if (!isPlayerThreeOfOKind) {
                System.out.println("Computer has 3 of a kind, 3 " + computerHand[0].getSymbol() + "'s");
                computerWins = true;
                //both 3 of a kind----------------------
            } else {
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    System.out.println(player);
                    playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    System.out.println(player + " has 3 of a kind, 3 " + playerHand[0].getSymbol() + "'s");
                    System.out.println("Computer has 3 of a kind, 3 " + computerHand[0].getSymbol() + "'s");
                    computerWins = true;
                } else {
                    System.out.println(player + " has 3 of a kind, 3 " + playerHand[0].getSymbol() + "'s");
                    System.out.println("Computer has 3 of a kind, 3 " + computerHand[0].getSymbol() + "'s");
                    itsATie = true;
                }
            }
            //------------------player has 3 of a kind---------------------------
        } else {
            if (isPlayerThreeOfOKind) {
                System.out.println(player + " has 3 of a kind, 3 " + playerHand[0].getSymbol() + "'s");
                playerWins = true;
            }
        }
        //---------------comp has straight ------------------
        if (isComputerStraight) {
            if (!isPlayerStraight) {
                System.out.println("Computer has a straight ");
                computerWins = true;
                //-----------------------------both straight----------------------
            } else {
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    playerWins = true;
                    System.out.println(player + " has a straight and " + playerHand[0].getValue() + " high");
                    System.out.println("Computer has a straight and " + computerHand[0] + " high");
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    System.out.println(player + " has a straight and " + playerHand[0].getValue() + " high");
                    System.out.println("Computer has a straight and " + computerHand[0] + " high");
                    computerWins = true;
                } else {
                    itsATie = true;
                }
            }
        }
        //--------------player has straight --------------------------------
        else {
            if (isPlayerStraight) {
                System.out.println(player + " has a straight ");
                playerWins = true;
            }
        }
        //------------------computer has flush-----------------
        if (isComputerFlush) {
            if (!isPlayerFlush) {
                System.out.println("Computer has a flush");
                computerWins = true;
                //------------------------both flush----------------------
            } else {
                if (playerHand[0].getValue() > computerHand[0].getValue()) {
                    System.out.println(player + " has a flush and " + playerHand[0].getSymbol() + " high");
                    System.out.println("Computer has a flush and " + computerHand[0].getSymbol() + " high");
                    playerWins = true;
                } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                    System.out.println(player + " has a flush and " + playerHand[0].getSymbol() + " high");
                    System.out.println("Computer has a flush and " + computerHand[0].getSymbol() + " high");
                    computerWins = true;
                } else {
                    itsATie = true;
                }
            }
        } else {
            if (isPlayerFlush) {
                System.out.println(player + " has a flush");
                playerWins = true;
            }
        }
        //-----------------------computer pairs------------------------
        if (isComputerPairs) {
            if (!isPlayerPairs) {
                System.out.println("Computer has a pair of " + computerHand[0].getSymbol() + "'s");
                computerWins = true;
                //------------------------both pairs----------------------
            } else {
                System.out.println("Computer has a pair");
                System.out.println(player + " has a pair");
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
                System.out.println(player + " has a pair");
                playerWins = true;
            }
        }
        //--------------------if there are no combinations-------------------------------
        if (!isCombination) {
            if (playerHand[0].getValue() > computerHand[0].getValue()) {
                System.out.println(player + " has " + playerHand[0].getSymbol() + " high");
                playerWins = true;
            } else if (playerHand[0].getValue() < computerHand[0].getValue()) {
                System.out.println("Computer has " + computerHand[0].getSymbol() + " high");
                computerWins = true;
            } else {
                if (playerHand[1].getValue() > computerHand[1].getValue()) {
                    System.out.println(player + " has " + playerHand[0].getSymbol() + " high and a " + playerHand[1].getSymbol());
                    playerWins = true;
                } else if (playerHand[1].getValue() < computerHand[1].getValue()) {
                    System.out.println("Computer has " + computerHand[0].getSymbol() + " high and a " + computerHand[1].getSymbol());
                    computerWins = true;
                } else {
                    if (playerHand[2].getValue() > computerHand[2].getValue()) {
                        System.out.println(player + " has " + playerHand[0].getSymbol() + " high,  a " + playerHand[1].getSymbol() + " and a " + playerHand[2].getSymbol());
                        playerWins = true;
                    } else if (playerHand[2].getValue() < computerHand[2].getValue()) {
                        System.out.println("Computer has " + computerHand[0].getSymbol() + " high,  a " + computerHand[1].getSymbol() + " and a " + computerHand[2].getSymbol());
                        computerWins = true;
                    } else {
                        itsATie = true;
                    }
                }
            }
        }

    }

    public void resetBooleans() {
        isComputerThreeOfOKind = false;
        isCombination = false;
        isPlayerThreeOfOKind = false;
        isComputerFlush = false;
        isPlayerFlush = false;
        isComputerStraight = false;
        isPlayerStraight = false;
        isComputerPairs = false;
        isPlayerPairs = false;
        isComputerAce = false;
        isPlayerAce = false;
        isComputerKing = false;
        isPlayerKing = false;
        isComputerQueen = false;
        isPlayerQueen = false;
        isComputerStraightFlush = false;
        isPlayerStraightFlush = false;
        computerWins = false;
        playerWins = false;
        itsATie = false;

    }
}