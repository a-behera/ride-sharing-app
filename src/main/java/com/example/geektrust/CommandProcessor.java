package com.example.geektrust;

import java.util.Objects;

import com.example.geektrust.common.Command;
import com.example.geektrust.controller.Controller;

public class CommandProcessor {
    public void processCommand(String input) {
        String[] command = input.split(" ");

        if (Objects.equals(command[0], Command.ADD_DRIVER)) {
            Controller.addDriver(command[1], command[2], command[3]);
        } else if (Objects.equals(command[0], Command.ADD_RIDER)) {
            Controller.addRider(command[1], command[2], command[3]);
        } else if (Objects.equals(command[0], Command.MATCH)) {
            Controller.match(command[1]);
        } else if (Objects.equals(command[0], Command.START_RIDE)) {
            Controller.startRide(command[1], command[2], command[3]);
        } else if (Objects.equals(command[0], Command.STOP_RIDE)) {
            Controller.stopRide(command[1], command[2], command[3], command[4]);
        } else if (Objects.equals(command[0], Command.BILL)) {
            Controller.bill(command[1]);
        } else {
            System.out.println("Unknown Command");
        }
    }

}
