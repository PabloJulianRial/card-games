package org.example.UserInteractions;

public enum CommandOptions {
    OPTIONS("SELECT AN OPTION  ↓"),
    BJ_RULES("Press 1 to see Black Jack instructions"),
    POKER_RULES("Press 2 to see Poker instructions"),
    BJ_LEADERBOARD("Press 3 for Black Jack leaderboard"),
    POKER_LEADERBOARD("Press 4 for Poker leaderboard"),
    PLAY_BJ("Press 5 to play Black Jack"),
    PLAY_POKER("Press 6 to play Poker"),
    QUIT("Press 7 to quit game");

    private final String option;

    CommandOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}


