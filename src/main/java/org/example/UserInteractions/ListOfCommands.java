package org.example.UserInteractions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListOfCommands {
    private final String[] messages;
    Scanner input = new Scanner(System.in);

    // Constructor
    public ListOfCommands() {
        messages = new String[CommandOptions.values().length];
        for (int i = 0; i < CommandOptions.values().length; i++) {
            messages[i] = CommandOptions.values()[i].getOption();
        }
    }

    public int optionSelect() {
        while (true) {
            try {
                int option = input.nextInt();
                if (option > 0 && option <= CommandOptions.values().length) {
                    return option;
                } else {
                    System.out.println("Invalid input. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                input.next();
            }
        }
    }

    public void printMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}