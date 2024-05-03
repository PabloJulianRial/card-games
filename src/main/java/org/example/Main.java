package org.example;

import org.example.UserInteractions.FileRead;

public class Main {
    public static void main(String[] args) {


        FileRead hamish = new FileRead();
        hamish.writeScore("a", 1);

        
        hamish.readAllScores();
    }
}