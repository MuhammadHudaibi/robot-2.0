package com.enigma.quiz;

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
}
