package org.example;

import org.example.UserInteractions.FileRead;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        FileRead hamish = new FileRead();

        hamish.writeScore("Pablo", 234);
        hamish.readAllScores();
    }
}