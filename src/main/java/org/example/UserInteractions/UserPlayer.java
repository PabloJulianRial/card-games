package org.example.UserInteractions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPlayer {
    private final static Scanner scanner = new Scanner(System.in);

    public UserPlayer() {
        Scanner scanner = new Scanner(System.in);
    }

    public int getBet(int bank) {

        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That's not a number, please enter a number");
            scanner.next();
        }
        if (input > bank || input <= 0) {
            input = 0;
            System.out.println("you don't have that much money to bet. You've only got £" + bank + " in the bank");
        }
        return input;
    }
}
