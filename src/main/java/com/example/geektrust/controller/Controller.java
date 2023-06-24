package com.example.geektrust.controller;

import com.example.geektrust.models.Driver;
import com.example.geektrust.models.Match;
import com.example.geektrust.models.Ride;
import com.example.geektrust.models.Rider;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Rider> riders = new ArrayList<>();

    static ArrayList<Match> matches = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();

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
            Match match = new Match(rider_id, matchedDrivers);
            matches.add(match);
        } else {
            System.out.println("NO_DRIVERS_AVAILABLE");
        }
    }

    public static void startRide(String ride_id, String selected_driver, String rider_id) {
        boolean isRideIdExists = false;
        for (Ride ride : rides) {
            if (Objects.equals(ride.getRide_id(), ride_id)) {
                isRideIdExists = true;
                break;
            }
        }

        String assigned_driver;
        for (Match match : matches) {
            if (Objects.equals(match.getRider_id(), rider_id)) {
                if (match.getMatched_drivers().size() < Integer.parseInt(selected_driver) || isRideIdExists) {
                    System.out.println("INVALID_RIDE");
                } else {
                    assigned_driver = match.getMatched_drivers().get(Integer.parseInt(selected_driver) - 1);
                    Ride newRide = new Ride(ride_id, assigned_driver, rider_id);
                    rides.add(newRide);
                    System.out.println("RIDE_STARTED " + ride_id);
                }
            }
        }
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
