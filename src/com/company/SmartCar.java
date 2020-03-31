package com.company;

public class SmartCar implements Car {

    private boolean isKeyInstalled;
    private Engine engine;
    private Transmission transmission;
    private Wheels wheels;
    private Rudder rudder;

    public SmartCar(Engine engine, Transmission transmission, Wheels wheels, Rudder rudder) {
        this.engine = engine;
        this.transmission = transmission;
        this.wheels = wheels;
        this.rudder = rudder;
        this.isKeyInstalled = false;
    }

    public void insertKey() {
        if (isKeyInstalled) {
            System.out.println("Error: the key is already in the lock");
        } else {
            isKeyInstalled = true;
            System.out.println("Key inserted");
        }
    }

    public void removeKey() {
        if (isKeyInstalled) {
            processRemoveKey();
        } else {
            System.out.println("Error: here is no any key.");
        }
    }

    private void processRemoveKey() {
        if (stillMoving()) {
            System.out.println("Error: You can not remove key. Please, stop the car.");
        } else if (transmission.isOnPark()) {
            engine.stopEngine();
            isKeyInstalled = false;
            System.out.println("The key removed");
        }
    }

    @Override
    public void turnKey() {
        if (isKeyInstalled) {
            processStartEngine();
        } else {
            System.out.println("Error: please, insert the key.");
        }
    }

    private void processStartEngine() {
        if (startEngine()) {
            System.out.println("The engine is running now");
        } else {
            System.out.println("Error: the engine has already started");
        }
    }

    @Override
    public void pressBrake() {
        wheels.stop();
        engine.lessPower();
    }

    @Override
    public void releaseBrake() {
        if (wheels.isStopped()) {
            wheels.go();
        } else {
            System.out.println("Error: wheels are already unlocked");
        }
    }

    @Override
    public void pressGas() {
        if (stillMoving()) {
            engine.morePower();
        } else {
            System.out.println("Error: The engine overload. Try to put car in drive");
        }
    }

    @Override
    public void releaseGas() {
        if (!stillMoving()) {
            engine.lessPower();
        } else {
            System.out.println("Error: the engine is already idling");
        }
    }

    @Override
    public void steerLeft() {
        if (stillMoving()) {
            rudder.steerLeft();
        } else {
            printNotSteerError();
        }
    }

    private void printNotSteerError() {
        System.out.println("Error: Do not steer when the car doesn't move )))");
    }

    @Override
    public void steerStraight() {
        if (stillMoving()) {
            rudder.steerStraight();
        } else {
            printNotSteerError();
        }
    }

    @Override
    public void steerRight() {
        if (stillMoving()) {
            rudder.steerRight();
        } else {
            printNotSteerError();
        }
    }

    private boolean stillMoving() {
        return !transmission.isOnPark();
    }

    @Override
    public void putCarInPark() {
        if (wheels.isSpinning()) {
            System.out.println("Error: You just tried to put the car in park while it was moving forward!. Please, stop the car.");
        } else {
            processPuttingInPark();
        }
    }

    private void processPuttingInPark() {
        transmission.park();
    }

    @Override
    public void putCarInDrive() {
        if (transmission.drive()) {
            releaseBrake();
        }
    }

    @Override
    public void putCarInReverse() {
        if (!transmission.isOnDrive()) {
            transmission.reverse();
            releaseBrake();
        } else {
            System.out.println("Error: You have just tried to put transmission into reverse mode. Please, stop the car first.");
        }
    }

    @Override
    public boolean startEngine() {
        return engine.start();
    }

}
