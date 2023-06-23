package com.example.geektrust.models;

public class Rider {
    private String rider_id;
    private String x_coordinate;
    private String y_coordinate;

    public Rider(String rider_id, String x_coordinate, String y_coordinate) {
        this.rider_id = rider_id;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public String getRider_id() {
        return rider_id;
    }

    public String getX_coordinate() {
        return x_coordinate;
    }

    public String getY_coordinate() {
        return y_coordinate;
    }
}
