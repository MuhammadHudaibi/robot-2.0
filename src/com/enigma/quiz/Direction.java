package com.enigma.quiz;

public enum Direction {
    N("North"), E("East"), S("South"), W("West");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public Direction turnLeft() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }

    public String getDirection() {
        return direction;
    }
}
