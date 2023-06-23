package com.example.geektrust;

import com.example.geektrust.common.Command;
import com.example.geektrust.controller.Controller;

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
                    Controller.addDriver(command[0],command[1],command[2]);
                } else if (Objects.equals(command[0], Command.ADD_RIDER)) {
                    Controller.addRider(command[0],command[1],command[2]);
                } else if (Objects.equals(command[0], Command.MATCH)) {
                    Controller.match();
                } else if (Objects.equals(command[0], Command.START_RIDE)) {
                    Controller.startRide();
                } else if (Objects.equals(command[0], Command.STOP_RIDE)) {
                    Controller.stopRide();
                } else if (Objects.equals(command[0], Command.BILL)) {
                    Controller.bill();
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
