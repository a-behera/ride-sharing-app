package com.example.geektrust.controller;

import com.example.geektrust.models.Driver;
import com.example.geektrust.models.Rider;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Rider> riders = new ArrayList<>();

    public static void addDriver(String driver_id, String x_coordinate, String y_coordinate) {
        Driver newDriver = new Driver(driver_id, x_coordinate, y_coordinate);
        drivers.add(newDriver);
    }

    public static void addRider(String rider_id, String x_coordinate, String y_coordinate) {
        Rider newRider = new Rider(rider_id, x_coordinate, y_coordinate);
        riders.add(newRider);
    }

    public static void match(String rider_id) {
        ArrayList<String> matchedDrivers = new ArrayList<>();

        for (Rider rider : riders) {
            if (Objects.equals(rider.getRider_id(), rider_id)) {
                for (Driver driver : drivers) {
                    double distance = calculateDistance(rider.getX_coordinate(), rider.getY_coordinate(),
                            driver.getX_coordinate(), driver.getY_coordinate());
                    if (distance <= 5.0) {
                        matchedDrivers.add(driver.getDriver_id());
                    }
                }
            }
        }
        if (matchedDrivers.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("DRIVERS_MATCHED ");

            for (String driverId : matchedDrivers) {
                sb.append(driverId).append(" ");
            }
            String output = sb.toString().trim();
            System.out.println(output);
        } else {
            System.out.println("NO_DRIVERS_AVAILABLE");
        }
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

    private static double calculateDistance(String rider_x, String rider_y, String driver_x, String driver_y) {
        double x1 = Double.parseDouble(rider_x);
        double y1 = Double.parseDouble(rider_y);
        double x2 = Double.parseDouble(driver_x);
        double y2 = Double.parseDouble(driver_y);
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
