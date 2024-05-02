package org.example.UserInteractions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListOfCommands {
    Scanner input = new Scanner(System.in);
    String[] messages = {"Welcome to JAVA card games", "Please enter your name", "Options", "Press 1 for Black Jack",
            "Press 2 for Solitaire", "Press 3 to see Black Jack instructions", "Press 4 to see Solitaire instructions",
            "Press 5 to play Black Jack", "Press 5 to play Solitaire", "Press 6 for Black Jack leaderboard",
            "Press 7 for Solitaire leaderboard", "Press 8 to quit game"};

    public int optionSelect() {
        while (true) {
            try {
                int option = input.nextInt();
                if (option > 0 && option < 13) {
                    return option;
                } else {
                    System.out.println("Invalid input. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
            }
        }

    }

    public String nameInput() {
        while (true) {
            try {
                return input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid name");
            }
        }
    }


    public void printMessage(int index) {
        System.out.println(messages[index]);
    }


}
