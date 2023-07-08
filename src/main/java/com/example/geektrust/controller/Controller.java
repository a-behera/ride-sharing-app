package com.example.geektrust.controller;

import com.example.geektrust.common.Constants;
import com.example.geektrust.models.Driver;
import com.example.geektrust.models.Match;
import com.example.geektrust.models.Ride;
import com.example.geektrust.models.Rider;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Rider> riders = new ArrayList<>();

    static ArrayList<Match> matches = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();
    static ArrayList<Ride> stoppedRides = new ArrayList<>();

    public static void addDriver(String driver_id, String x_coordinate, String y_coordinate) {
        boolean isIdPresent = false;
        for (Driver driver : drivers) {
            if (Objects.equals(driver.getDriver_id(), driver_id)) {
                isIdPresent = true;
                break;
            }
        }

        if (isIdPresent) {
            throw new RuntimeException("Driver ID Already Present.");
        } else {
            Driver newDriver = new Driver(driver_id, x_coordinate, y_coordinate);
            drivers.add(newDriver);
        }
    }

    public static void addRider(String rider_id, String x_coordinate, String y_coordinate) {
        boolean isIdPresent = false;
        for (Rider rider : riders) {
            if (Objects.equals(rider.getRider_id(), rider_id)) {
                isIdPresent = true;
                break;
            }
        }

        if (isIdPresent) {
            throw new RuntimeException("Rider ID Already Present.");
        } else {
            Rider newRider = new Rider(rider_id, x_coordinate, y_coordinate);
            riders.add(newRider);
        }
    }

    public static void match(String rider_id) {
        ArrayList<String> matchedDrivers = new ArrayList<>();

        for (Rider rider : riders) {
            if (Objects.equals(rider.getRider_id(), rider_id)) {
                for (Driver driver : drivers) {
                    double distance = calculateDistance(rider.getX_coordinate(), rider.getY_coordinate(),
                            driver.getX_coordinate(), driver.getY_coordinate());
                    if (distance <= Constants.RANGE) {
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

    public static void stopRide(String ride_id, String dest_x_coordinate, String dest_y_coordinate, String time_taken) {
        if (Integer.parseInt(time_taken) < 0) {
            throw new RuntimeException("Time Taken For A Ride Cannot Be Negative.");
        }

        boolean isRideIdExists = false;
        for (Ride ride : rides) {
            if (Objects.equals(ride.getRide_id(), ride_id)) {
                isRideIdExists = true;
                break;
            }
        }
        if (isRideIdExists) {
            System.out.println("RIDE_STOPPED " + ride_id);
            Ride stoppedRide = new Ride(ride_id, dest_x_coordinate, dest_y_coordinate, time_taken, true);
            stoppedRides.add(stoppedRide);
        } else {
            System.out.println("INVALID_RIDE");
        }
    }

    public static void bill(String ride_id) {
        // from start ride array get rider id.
        String rider_id = null;
        String driver_id = null;
        for (Ride ride : rides) {
            if (Objects.equals(ride.getRide_id(), ride_id)) {
                rider_id = ride.getRider_id();
                driver_id = ride.getDriver_id();
                break;
            }
        }

        // from rider array get coordinate
        String start_x_co = null;
        String start_y_co = null;
        for (Rider rider : riders) {
            if (Objects.equals(rider.getRider_id(), rider_id)) {
                start_x_co = rider.getX_coordinate();
                start_y_co = rider.getY_coordinate();
                break;
            }
        }

        // from stop ride array get destinations & time taken.
        String dest_x_co = null;
        String dest_y_co = null;
        String time_taken = null;
        for (Ride ride : stoppedRides) {
            if (Objects.equals(ride.getRide_id(), ride_id)) {
                dest_x_co = ride.getDestination_x_coordinate();
                dest_y_co = ride.getDestination_y_coordinate();
                time_taken = ride.getTime_taken();
                break;
            }
        }

        // calculate distance.
        double distance = calculateDistance(start_x_co, start_y_co, dest_x_co, dest_y_co);

        // calculate bill
        double additional_km = Constants.ADDITIONAL_KM_CHARGES * distance;
        assert time_taken != null;
        double additional_min = Constants.ADDITIONAL_MIN_CHARGES * Double.parseDouble(time_taken);
        double total_amount = Constants.BASE_FAIR + additional_km + additional_min;
        double service_tax = total_amount * Constants.SERVICE_TAX_CHARGES;

        double bill = total_amount + service_tax;

        BigDecimal bd = new BigDecimal(bill);
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        double roundedValue = bd.doubleValue();

        System.out.println("BILL " + ride_id + " " + driver_id + " " + roundedValue);

    }

    private static double calculateDistance(String rider_x, String rider_y, String driver_x, String driver_y) {
        double x1 = Double.parseDouble(rider_x);
        double y1 = Double.parseDouble(rider_y);
        double x2 = Double.parseDouble(driver_x);
        double y2 = Double.parseDouble(driver_y);
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
