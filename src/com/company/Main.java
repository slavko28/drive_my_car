package com.company;

public class Main {
    public static void main(String[] args) {
        Engine engine = new SuperEngine();
        Transmission transmission = new SmartTransmission();
        Wheels wheels = new SportWheels();
        Rudder rudder = new SportRudder();
        Car car = new SmartCar(engine, transmission, wheels, rudder);


        car.insertKey();
        car.turnKey();
        car.putCarInDrive();
        car.pressGas();
        car.pressGas();
        car.putCarInDrive();
        car.pressBrake();
        car.putCarInDrive();
        car.insertKey();
        car.pressGas();
        car.steerLeft();
        car.putCarInReverse();
        car.steerLeft();
        car.steerRight();
        car.pressBrake();
        car.putCarInPark();
        car.removeKey();



    }
}
