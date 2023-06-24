package com.example.geektrust.models;

import java.util.ArrayList;

public class Match {
    private String rider_id;
    private ArrayList<String> matched_drivers;

    public Match(String rider_id, ArrayList<String> matched_drivers) {
        this.rider_id = rider_id;
        this.matched_drivers = matched_drivers;
    }

    public String getRider_id() {
        return rider_id;
    }

    public ArrayList<String> getMatched_drivers() {
        return matched_drivers;
    }
}
