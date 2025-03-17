package com.enigma.quiz;

public interface History {
    void write(String command, int x, int y, Object direction, boolean isEnd);
    String readLastPosition();
    Coordinate getLastPosition();
    int[] move(int x, int y, Direction direction);
}
