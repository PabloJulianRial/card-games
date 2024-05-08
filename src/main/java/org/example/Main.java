package org.example;

import org.example.Games.Poker;
import org.example.UserInteractions.FileRead;
import org.example.UserInteractions.ListOfCommands;

public class Main {
    static Poker poker = new Poker();
    static ListOfCommands commands = new ListOfCommands();
    static FileRead PokerLeaderboard = new FileRead("src/main/java/org/example/Assets/PokerScores.txt");
    static FileRead BlackjackLeaderboard = new FileRead("src/main/java/org/example/Assets/BlackjackScores.txt");
    static FileRead BlackjackRules = new FileRead("src/main/java/org/example/Assets/BlackjackRules.txt");
    static FileRead PokerRules = new FileRead("src/main/java/org/example/Assets/PokerRules.txt");
    private static boolean gameStarted = false;

    public static void main(String[] args) {


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
//                    break;case 5:
//                    gameStarted = true;
//                    BlackJack.playBlackJack();
//                    break;
                case 6:
                    gameStarted = true;
                    poker.playPoker();
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }

        }
    }
}
