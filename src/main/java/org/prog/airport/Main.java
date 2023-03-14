package org.prog.airport;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Plane> planeList = new ArrayList<>();
        planeList.add(new Plane("Flight1", 2));
        planeList.add(new Plane("Flight2", 3));
        planeList.add(new Plane("Flight3", 3));

        Plane[] airportPlanes = new Plane[3];
        airportPlanes[0] = new Plane("Flight1", 2);
        airportPlanes[1] = new Plane("Flight2", 3);
        airportPlanes[2] = new Plane("Flight3", 3);

        FlightControl airport = new FlightControl(airportPlanes);
        airport.setPlaneDestination("Flight1", "Italy");
        airport.setPlaneDestination("Flight2", "Georgia");
        airport.setPlaneDestination("Flight3", "Lviv");

        createPassengers(airport);

        for (int i = 0; i < airport.passengerNames.length; i++) {
            airport.boardPassenger(i);
        }
    }

        public static void createPassengers(FlightControl airport) {
            airport.registerPassenger(0, "Alice", 0, "Flight1");
            airport.registerPassenger(1, "Bob", 1, "Flight1");

            airport.registerPassenger(2, "Joe", 0, "Flight2");
            airport.registerPassenger(3, "Jane", 1, "Flight2");
            airport.registerPassenger(4, "Alice", 2, "Flight2");

            airport.registerPassenger(5, "Sarah", 0, "Flight3");
            airport.registerPassenger(6, "Arnie", 1, "Flight3");
            airport.registerPassenger(7, "Kyle", 10, "Flight3");
        }




}

