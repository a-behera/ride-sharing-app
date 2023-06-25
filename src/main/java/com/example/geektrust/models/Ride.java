package com.example.geektrust.models;

public class Ride {
    private String ride_id;
    private String driver_id;
    private String rider_id;
    private String destination_x_coordinate;
    private String destination_y_coordinate;
    private String time_taken;
    private boolean ride_status;

    public Ride(String ride_id, String driver_id, String rider_id) {
        this.ride_id = ride_id;
        this.driver_id = driver_id;
        this.rider_id = rider_id;
    }

    public Ride(String ride_id, String destination_x_coordinate, String destination_y_coordinate, String time_taken, boolean ride_status) {
        this.ride_id = ride_id;
        this.destination_x_coordinate = destination_x_coordinate;
        this.destination_y_coordinate = destination_y_coordinate;
        this.time_taken = time_taken;
        this.ride_status = ride_status;
    }

    public String getRide_id() {
        return ride_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public String getRider_id() {
        return rider_id;
    }

    public String getDestination_x_coordinate() {
        return destination_x_coordinate;
    }

    public String getDestination_y_coordinate() {
        return destination_y_coordinate;
    }

    public String getTime_taken() {
        return time_taken;
    }

    public boolean isRide_status() {
        return ride_status;
    }
}
