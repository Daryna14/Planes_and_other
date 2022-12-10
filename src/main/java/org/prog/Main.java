package org.prog;

public class Main {

    public static void main(String[] args) {

        Plane Hurricane = new Plane();
        String[] passengerName = new String[6];

        passengerName[0] = "John Smith";
        passengerName[1] = "Bella Donna";
        passengerName[2] = "Oliver Twist";
        passengerName[3] = "Sherlock Holmes";
        passengerName[4] = "Harry Potter";
        passengerName[5] = "Robinson Crusoe";

        Plane.setPassengerName(passengerName);

        for (int i = 0; i < Hurricane.passengers.length; i++) {
            System.out.println(Hurricane.getPassengerName(i));

        }
    }
}
