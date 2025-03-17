package com.enigma.quiz.impl;

import com.enigma.quiz.Coordinate;
import com.enigma.quiz.Direction;
import com.enigma.quiz.History;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryImpl implements History {
    @Override
    public void write(String command, int x, int y, Object direction, boolean isEnd) {
        try (FileWriter writer = new FileWriter("History.txt", true)) {
            String formattedText;
            if (isEnd) {
                formattedText = String.format("posisi akhir: %c, %d, %d%n", direction.toString().charAt(0), x, y);
            } else {
                formattedText = String.format("%s -> {%c, %d, %d}%n", command.charAt(0), direction.toString().charAt(0), x, y);
            }
            writer.write(formattedText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readLastPosition() {
        String lastLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("History.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("posisi akhir:")) {
                    lastLine = line;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lastLine;
    }

    @Override
    public Coordinate getLastPosition() {
        String lastLine = readLastPosition();
        if (lastLine != null) {
            String[] parts = lastLine.split(": ")[1].split(", ");
            char direction = parts[0].charAt(0);
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            return new Coordinate(x, y, direction);
        }
        return new Coordinate(2, 3, 'N');
    }

    @Override
    public int[] move(int x, int y, Direction direction) {
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
