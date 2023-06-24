package com.example.geektrust.models;

public class Ride {
    private String ride_id;
    private String driver_id;
    private String rider_id;

    public Ride(String ride_id, String driver_id, String rider_id) {
        this.ride_id = ride_id;
        this.driver_id = driver_id;
        this.rider_id = rider_id;
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
}
