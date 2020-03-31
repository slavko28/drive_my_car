package com.company;

public class SmartTransmission implements Transmission {

    private TransmissionState state;

    public SmartTransmission() {
        this.state = TransmissionState.PARK;
    }

    public boolean changeState(TransmissionState newState) {
        if (this.state.equals(newState)) {
            System.out.println(String.format("Error: the transmission has already work in %s mode", newState.name));
            return false;
        }
        System.out.println(String.format("The transmission has turned into %s mode", newState.name));
        this.state = newState;
        return true;
    }

    @Override
    public void park() {
        changeState(TransmissionState.PARK);
    }

    @Override
    public boolean drive() {
        return changeState(TransmissionState.DRIVE);
    }

    @Override
    public void reverse() {
        changeState(TransmissionState.REVERSE);
    }

    @Override
    public boolean isOnDrive() {
        return state.equals(TransmissionState.DRIVE);
    }

    @Override
    public boolean isOnPark() {
        return state.equals(TransmissionState.PARK);
    }

    private enum TransmissionState {
        PARK("park"), DRIVE("drive"), REVERSE("reverse");

        private String name;

        TransmissionState(String name) {
            this.name = name;
        }
    }
}
