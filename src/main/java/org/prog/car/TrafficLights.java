package org.prog.car;

import org.prog.Car;

public class TrafficLights {

    public void sendSignal(Car targetCar, String color) {
        targetCar.setCurrentTrafficLight(color);
    }
}


