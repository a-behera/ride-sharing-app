package com.example.geektrust;

import com.example.geektrust.controller.Controller;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void test_addDriver() {
        Controller.addDriver("D1", "0", "1");
    }

    @Test
    void test_addRider() {
        Controller.addRider("R1", "3", "5");
    }

    @Test
    void test_match() {
        Controller.match("R1");
    }

    @Test
    void test_startRide() {
        Controller.startRide("RIDE-101", "1", "R1");
    }

    @Test
    void test_stopRide() {
        Controller.stopRide("RIDE-101", "10", "2", "48");
    }
}