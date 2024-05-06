package org.example.UserInteractions;

import java.io.*;
import java.util.ArrayList;

public class FileRead {

    BufferedWriter writer;
    BufferedReader reader;
    ArrayList<String> leaderboard = new ArrayList<String>();
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";

    // Constructor
    public FileRead(String file) {
        try {
            this.writer = new BufferedWriter(new FileWriter("src/main/java/org/example/Assets/Scores.txt", true));
            this.reader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // add a line to the bottom of the file when the game finishes
    public void writeScore(String username, int score) {
        try {
            writer.write(username + " : " + score + "\n");
            writer.flush(); // Flush the stream to ensure data is written immediately
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read all the scores that are on the leaderboard and return the score to the terminal
    public void readAllScores(String file) {
        try {
            leaderboard.clear(); // Clear the previous leaderboard
            reader = new BufferedReader(new FileReader(file)); // Reopen the reader
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboard.add(line);
            }
            for (int i = 0; i < leaderboard.size(); i++) {
                System.out.println(YELLOW + leaderboard.get(i) + RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Close the reader in a finally block to ensure it's always closed
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
