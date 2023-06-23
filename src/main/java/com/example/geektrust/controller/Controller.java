package com.example.geektrust.controller;

import com.example.geektrust.models.Driver;
import com.example.geektrust.models.Rider;

import java.util.ArrayList;

public class Controller {
    static ArrayList<Driver> drivers = new ArrayList<Driver>();
    static ArrayList<Rider> riders = new ArrayList<Rider>();

    public static void addDriver(String driver_id, String x_coordinate, String y_coordinate) {
        Driver newDriver = new Driver(driver_id, x_coordinate, y_coordinate);
        drivers.add(newDriver);
    }

    public static void addRider(String rider_id, String x_coordinate, String y_coordinate) {
        Rider newRider = new Rider(rider_id, x_coordinate, y_coordinate);
        riders.add(newRider);
    }

    public static void match() {
        System.out.println(drivers.size());
    }

    public static void startRide() {
        System.out.println(drivers.size());
    }

    public static void stopRide() {
        System.out.println(drivers.size());
    }

    public static void bill() {
        System.out.println(drivers.size());
    }

    private static double calculateDistance(String driver_x, String driver_y, String rider_x, String rider_y) {
        double x1 = Double.parseDouble(driver_x);
        double y1 = Double.parseDouble(driver_y);
        double x2 = Double.parseDouble(rider_x);
        double y2 = Double.parseDouble(rider_y);
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }
}
