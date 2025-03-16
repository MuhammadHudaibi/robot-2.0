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

    public static int[] move(int x, int y, Direction direction) {
        switch (direction) {
            case N:
                y += 1;
                break;
            case S:
                y -= 1;
                break;
            case E:
                x += 1;
                break;
            case W:
                x -= 1;
                break;
        }
        return new int[]{x, y};
    }
}
