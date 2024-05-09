package org.example.Games.Poker;

public class HandState {
    public boolean isPlayerPairs;
    public boolean isComputerFlush;
    boolean isComputerThreeOfOKind;
    boolean isCombination;
    boolean isPlayerThreeOfOKind;
    boolean isPlayerFlush;
    boolean isComputerStraight;
    boolean isPlayerStraight;
    boolean isComputerPairs;
    boolean isComputerAce;
    boolean isPlayerAce;
    boolean isComputerKing;
    boolean isPlayerKing;
    boolean isComputerQueen;
    boolean isPlayerQueen;
    boolean isComputerStraightFlush;
    boolean isPlayerStraightFlush;
    boolean computerWins;
    boolean playerWins;
    boolean itsATie;

    public HandState() {
        this.isComputerThreeOfOKind = false;
        this.isCombination = false;
        this.isPlayerThreeOfOKind = false;
        this.isComputerFlush = false;
        this.isPlayerFlush = false;
        this.isComputerStraight = false;
        this.isPlayerStraight = false;
        this.isComputerPairs = false;
        this.isPlayerPairs = false;
        this.isComputerAce = false;
        this.isPlayerAce = false;
        this.isComputerKing = false;
        this.isPlayerKing = false;
        this.isComputerQueen = false;
        this.isPlayerQueen = false;
        this.isComputerStraightFlush = false;
        this.isPlayerStraightFlush = false;
        this.computerWins = false;
        this.playerWins = false;
        this.itsATie = false;

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
