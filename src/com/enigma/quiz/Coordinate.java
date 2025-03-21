package com.enigma.quiz;

public class Coordinate {
    int x;
    int y;
    char direction;

    public Coordinate(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
