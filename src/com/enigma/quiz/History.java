package com.enigma.quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class History {
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
            e.printStackTrace();
        }
    }

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
            e.printStackTrace();
        }
        return lastLine;
    }

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

}
