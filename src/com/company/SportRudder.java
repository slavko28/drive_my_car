package com.company;


public class SportRudder implements Rudder {

    private Direction positionOfRudder = Direction.STRAIGHT;

    private void turnSteeringWheel(Direction direction) {
        if (this.positionOfRudder.equals(direction)) {
            System.out.println(String.format("Error: the rudder has already turned %s", direction.name));
            return;
        }
        this.positionOfRudder = direction;
        System.out.println(String.format("The rudder turned %s", direction.name));
    }

    @Override
    public void steerLeft() {
        turnSteeringWheel(Direction.LEFT);
    }

    @Override
    public void steerStraight() {
        turnSteeringWheel(Direction.STRAIGHT);
    }

    @Override
    public void steerRight() {
        turnSteeringWheel(Direction.RIGHT);
    }

    private enum Direction {
        LEFT("left"), RIGHT("right"), STRAIGHT("straight");

        private String name;

        Direction(String name) {
            this.name = name;
        }
    }
}
