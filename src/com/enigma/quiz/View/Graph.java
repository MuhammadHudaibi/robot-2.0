package com.enigma.quiz.View;

public class Graph {
    public static void printCoordinatePlane(int x, int y) {
        int size = 10;
        for (int i = size; i >= -size; i--) {
            for (int j = -size; j <= size; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("+");
                } else if (i == 0) {
                    System.out.print("-");
                } else if (j == 0) {
                    System.out.print("|");
                } else if (i == y && j == x) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
