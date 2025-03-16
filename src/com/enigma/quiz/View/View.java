package com.enigma.quiz.View;

import com.enigma.quiz.Coordinate;
import com.enigma.quiz.Direction;
import com.enigma.quiz.History;
import com.enigma.quiz.Static.Scanners;

public class View {
    public void view() {
        History history = new History();
        Coordinate coordinate = new Coordinate(2, 3);

        int x = coordinate.getX();
        int y = coordinate.getY();

        Direction currentDirection = Direction.NORTH;

        System.out.println("Arah awal: " + currentDirection);
        System.out.printf("Koordinat awal anda {%d, %d}\n", x, y);
        Graph.printCoordinatePlane(x, y);
        System.out.println("Masukkan perintah (l untuk gsnti arah ke kanan, " +
                "r untuk ganti arah ke kiri, " +
                "a untuk bergerak maju, " +
                "q untuk keluar):");

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
                    int[] newPosition = Coordinate.move(x, y, currentDirection);
                    x = newPosition[0];
                    y = newPosition[1];
                    history.write(commands.toUpperCase(), x, y, currentDirection, false);
                } else {
                    System.out.println("Perintah tidak dikenali: " + command);
                }
            }

            System.out.println("Arah saat ini: " + currentDirection);
            System.out.printf("Koordinat awal anda {%d, %d}\n", x, y);

            Graph.printCoordinatePlane(x,y);
            coordinate.setX(x);
            coordinate.setY(y);
        }
        history.write("", coordinate.getX(), coordinate.getY(), currentDirection, true);
    }
}
