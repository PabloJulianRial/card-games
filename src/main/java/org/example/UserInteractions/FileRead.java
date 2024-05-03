package org.example.UserInteractions;

import java.io.*;
import java.util.ArrayList;

public class FileRead {

    BufferedWriter writer;
    BufferedReader reader;
    ArrayList<String> leaderboard = new ArrayList<String>();

    // Constructor
    public FileRead() {
        try {
            this.writer = new BufferedWriter(new FileWriter("Scores.txt", true));
            this.reader = new BufferedReader(new FileReader("Scores.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // add a line to the bottom of the file when the game finishes
    public void writeScore(String username, int score) {
        try {
            writer.write(username + " : " + score + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read all the scores that are on the leaderboard and return the score to the terminal
    public void readAllScores() {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboard.add(line);
            }
            reader.close();
            System.out.println(leaderboard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}