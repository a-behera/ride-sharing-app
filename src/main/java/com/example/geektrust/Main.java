package com.example.geektrust;

import com.example.geektrust.common.Command;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("sample_input\\input3.txt ");

            Scanner sc = new Scanner(fis); // file to be scanned

            // returns true if there is another line to read
            while (sc.hasNextLine()) {

               //Add your code here to process input commands
                String input = sc.nextLine();
                String[] command = input.split(" ");

                if(Objects.equals(command[0], Command.ADD_DRIVER)){
                    System.out.println();
                } else if (Objects.equals(command[0], Command.ADD_RIDER)) {
                    System.out.println();
                } else if (Objects.equals(command[0], Command.MATCH)) {
                    System.out.println();
                } else if (Objects.equals(command[0], Command.START_RIDE)) {
                    System.out.println();
                } else if (Objects.equals(command[0], Command.STOP_RIDE)) {
                    System.out.println();
                } else if (Objects.equals(command[0], Command.BILL)) {
                    System.out.println();
                } else {
                    System.out.println("Unknown Command");
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
