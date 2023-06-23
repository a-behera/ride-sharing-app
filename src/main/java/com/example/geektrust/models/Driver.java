package com.example.geektrust.models;

public class Driver {
    private String driver_id;
    private String x_coordinate;
    private String y_coordinate;

    public Driver(String driver_id, String x_coordinate, String y_coordinate) {
        this.driver_id = driver_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public String getX_coordinate() {
        return x_coordinate;
    }

    public String getY_coordinate() {
        return y_coordinate;
    }
}
