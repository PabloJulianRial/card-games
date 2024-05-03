package org.example.UserInteractions;

public enum CommandOptions {
    WELCOME("Welcome to 'JAVA Casino' "),
    NAME("Please enter your name"),
    OPTIONS("Options"),
    BJ("Press 1 for Black Jack"),
    POKER("Press 2 for Poker"),
    BJ_RULES("Press 3 to see Black Jack instructions"),
    POKER_RULES("Press 4 to see Poker instructions"),
    PLAY_BJ("Press 5 to play Black Jack"),
    PLAY_POKER("Press 6 to play Poker"),
    BJ_LEADERBOARD("Press 7 for Black Jack leaderboard"),
    POKER_LEADERBOARD("Press 8 for Solitaire leaderboard"),
    QUIT("Press 9 to quit game");

    private final String option;

    CommandOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}


