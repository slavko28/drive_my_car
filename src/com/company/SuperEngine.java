package com.company;

public class SuperEngine implements Engine {

    private int currentPowerInPercent;
    private int maxPowerInPercent = 100;
    private int stepPower = 10;

    public SuperEngine() {
        this.currentPowerInPercent = 0;
    }

    @Override
    public void morePower() {
        if (maxPowerInPercent < currentPowerInPercent + stepPower) {
            System.out.println(String.format("Error: the engine is already running at maximum power. Current power - %d percent", currentPowerInPercent));
            return;
        }
        currentPowerInPercent += stepPower;
        System.out.println("Car start moving more faster");
    }

    @Override
    public void lessPower() {
        if (stillWorking() && currentPowerInPercent >= stepPower + 1) {
            currentPowerInPercent = 10;
            System.out.println("The engine idling.");
        }
        System.out.println("Error: the engine is already idling");
    }

    @Override
    public boolean start() {
        if (!stillWorking()) {
            currentPowerInPercent = 10;
            return true;
        }
        return false;
    }

    @Override
    public void stopEngine() {
        if (stillWorking()) {
            currentPowerInPercent = 0;
            System.out.println("The engine stopped");
        } else {
            System.out.println("Error: the engine has already stopped");
        }
    }

    @Override
    public boolean stillWorking() {
        return currentPowerInPercent > 0;
    }

}
