package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);

            Scanner sc = new Scanner(fis); // file to be scanned

            CommandProcessor commandProcessor = new CommandProcessor();

            // returns true if there is another line to read
            while (sc.hasNextLine()) {

                // Add your code here to process input commands
                String input = sc.nextLine();
                commandProcessor.processCommand(input);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
