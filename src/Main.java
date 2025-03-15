import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 2;
        int y = 3;

        Direction currentDirection = Direction.NORTH;

        System.out.println("Arah awal: " + currentDirection);
        System.out.printf("Koordinat awal anda {%d, %d}\n", x, y);
        printCoordinatePlane(x, y);
        System.out.println("Masukkan perintah (l untuk gsnti arah ke kanan, r untuk ganti arah ke kiri, a untuk bergerak maju, q untuk keluar):");

        while (true) {
            String commands = scanner.nextLine();
            commands.toLowerCase();

            if (commands.equals("q")) {
                break;
            }

            for (char command : commands.toCharArray()) {
                if (command == 'l') {
                    currentDirection = currentDirection.turnLeft();
                } else if (command == 'r') {
                    currentDirection = currentDirection.turnRight();
                } else if (command == 'a') {
                    int[] newPosition = move(x, y, currentDirection);
                    x = newPosition[0];
                    y = newPosition[1];
                } else {
                    System.out.println("Perintah tidak dikenali: " + command);
                }
            }

            System.out.println("Arah saat ini: " + currentDirection);
            System.out.printf("Koordinat awal anda {%d, %d}\n", x, y);

            printCoordinatePlane(x,y);
        }

        System.out.println("Program selesai.");
        scanner.close();
    }

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

    public static int[] move(int x, int y, Direction direction) {
        switch (direction) {
            case NORTH:
                y += 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case EAST:
                x += 1;
                break;
            case WEST:
                x -= 1;
                break;
        }
        return new int[]{x, y};
    }
}
