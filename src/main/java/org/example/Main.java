package org.example;

import org.example.Games.BlackJack.BlackJack;
import org.example.Games.Poker.Poker;
import org.example.UserInteractions.FileRead;
import org.example.UserInteractions.ListOfCommands;

public class Main {
    static Poker poker = new Poker();
    static BlackJack blackJack = new BlackJack();
    static ListOfCommands commands = new ListOfCommands();
    static FileRead PokerLeaderboard = new FileRead("src/main/java/org/example/Assets/PokerScores.txt");
    static FileRead BlackjackLeaderboard = new FileRead("src/main/java/org/example/Assets/BlackjackScores.txt");
    static FileRead BlackjackRules = new FileRead("src/main/java/org/example/Assets/BlackjackRules.txt");
    static FileRead PokerRules = new FileRead("src/main/java/org/example/Assets/PokerRules.txt");
    static FileRead WelcomeMessage = new FileRead("src/main/java/org/example/Assets/Welcome.txt");


    public static void main(String[] args) {
        WelcomeMessage.readAllScores();
        System.out.println();
        boolean gameStarted = false;
        while (!gameStarted) {
            commands.printMessages();
            int option = commands.optionSelect();
            switch (option) {
                case 1:
                    BlackjackRules.readAllScores();
                    break;
                case 2:
                    PokerRules.readAllScores();
                    break;
                case 3:
                    BlackjackLeaderboard.readAllScores();
                    break;
                case 4:
                    PokerLeaderboard.readAllScores();
                    break;
                case 5:
                    blackJack.play();
                    break;
                case 6:
                    poker.playPoker();
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }

        }
    }
}
