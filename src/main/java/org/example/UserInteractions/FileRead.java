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


    public void writeScore(String username, int score) {
        try {
            writer.write(username + " : " + score + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readAllScores(String file) {
        try {
            leaderboard.clear();
            reader = new BufferedReader(new FileReader(file));
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
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
