package org.example.UserInteractions;

import java.io.*;

public class FileRead {

    BufferedWriter writer;
    BufferedReader reader;

    // Constructor
    public FileRead() {
        try {
            this.writer = new BufferedWriter(new FileWriter("Scores.txt",true));
            this.reader = new BufferedReader(new FileReader("Scores.txt"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void writeScore(String username, int score)  {
        // read first
        // find empty line
        // write
        try {
            writer.write("\n" + username + " : " + score);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readAllScores(){
        try {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(reader.readLine());
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
