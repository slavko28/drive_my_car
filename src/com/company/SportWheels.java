package com.company;

public class SportWheels implements Wheels {
    private WheelsState state;

    public SportWheels() {
        this.state = WheelsState.STOPPED;
    }

    private void changeState(WheelsState newState) {
        if (state.equals(newState)) {
            System.out.println(String.format("Error: the wheels have already %s", newState.name));
            return;
        }
        this.state = newState;
        System.out.println(String.format("The wheels are %s", newState.name));
    }

    @Override
    public void go() {
        changeState(WheelsState.SPINNING);
    }

    @Override
    public void stop() {
        changeState(WheelsState.STOPPED);
    }

    @Override
    public boolean isSpinning() {
        return state.equals(WheelsState.SPINNING);
    }

    @Override
    public boolean isStopped() {
        return state.equals(WheelsState.STOPPED);
    }

    private enum WheelsState {
        SPINNING("spinning"), STOPPED("stopped");

        private String name;

        WheelsState(String name) {
            this.name = name;
        }
    }

}
