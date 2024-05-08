package org.example.CardDeck;

import org.example.Games.Poker.Dealer;
import org.example.Games.Poker.HandState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DealerTest {
    static HandState newState = new HandState();
    private final Card[] playerHand = new Card[3];
    private final Card[] computerHand = new Card[3];
    Dealer dealer = new Dealer();

    @Test
    @DisplayName("player_checkHands_hasStraightFlush")
    void hasStraightFlush() {
        playerHand[0] = new Card("10", "❤️", 12);
        playerHand[1] = new Card("10", "❤️", 12);
        playerHand[2] = new Card("8", "❤️", 10);
        computerHand[0] = new Card("7", "❤️", 9);
        computerHand[1] = new Card("6", "❤️", 8);
        computerHand[2] = new Card("5", "❤️", 7);

        dealer.checkHands(playerHand, computerHand);
        assertTrue(newState.isComputerFlush);
    }


    @org.junit.jupiter.api.Test
    void determineWinner() {
    }

    @org.junit.jupiter.api.Test
    void resetBooleans() {
    }
}