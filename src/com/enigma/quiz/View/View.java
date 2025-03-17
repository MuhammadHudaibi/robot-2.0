package com.enigma.quiz.View;

import com.enigma.quiz.Coordinate;
import com.enigma.quiz.Direction;
import com.enigma.quiz.History;
import com.enigma.quiz.Static.Scanners;
import com.enigma.quiz.impl.HistoryImpl;

public class View {
    public void view() {
        History history = new HistoryImpl();
        Coordinate coordinate = history.getLastPosition();

        int x = coordinate.getX();
        int y = coordinate.getY();
        Direction currentDirection = Direction.valueOf(String.valueOf(coordinate.getDirection()));

        System.out.println("Arah awal: " + currentDirection.getDirection());
        System.out.printf("Koordinat awal anda {%d, %d}\n", x, y);

        Graph.printCoordinatePlane(x, y);
        System.out.println("Masukkan perintah (l = kiri, " +
                "r = kanan, " +
                "a = maju, " +
                "q = keluar):");

        while (true) {
            String commands = Scanners.inputText();

            if (commands.equals("q")) {
                break;
            }

            for (char command : commands.toCharArray()) {
                if (command == 'l') {
                    currentDirection = currentDirection.turnLeft();
                    history.write(commands.toUpperCase() ,x, y, currentDirection, false);
                } else if (command == 'r') {
                    currentDirection = currentDirection.turnRight();
                    history.write(commands.toUpperCase() ,x, y, currentDirection, false);
                } else if (command == 'a') {
                    int[] newPosition = history.move(x, y, currentDirection);
                    x = newPosition[0];
                    y = newPosition[1];
                    history.write(commands.toUpperCase(), x, y, currentDirection, false);
                } else {
                    System.out.println("Perintah tidak dikenali: " + command);
                }
            }

            System.out.println("Arah saat ini: " + currentDirection.getDirection());
            System.out.printf("Koordinat awal anda {%d, %d}\n", x, y);

            Graph.printCoordinatePlane(x,y);
            coordinate.setX(x);
            coordinate.setY(y);
        }
        history.write("", coordinate.getX(), coordinate.getY(), currentDirection, true);
    }
}
