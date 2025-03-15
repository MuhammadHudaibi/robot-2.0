import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 2;
        int y = 3;

        printCoordinatePlane(x, y);
        System.out.printf("Posisi awal anda {%d, %d}\n", x, y);



        while (true){
            System.out.print("Masukkan arah (W/A/S/D) tekan 'Q' untuk keluar: ");
            String a = sc.nextLine();

            switch (a.toLowerCase()){
                case "w":
                    y += Robot.UP.getDirection();
                    System.out.printf("Posisi anda {%d, %d}\n", x, y);
                    printCoordinatePlane(x, y);
                    break;
                case "a":
                    x += Robot.LEFT.getDirection();
                    System.out.printf("Posisi anda {%d, %d}\n", x, y);
                    printCoordinatePlane(x, y);
                    break;
                case "s":
                    y += Robot.DOWN.getDirection();
                    System.out.printf("Posisi anda {%d, %d}\n", x, y);
                    printCoordinatePlane(x, y);
                    break;
                case "d":
                    x += Robot.RIGHT.getDirection();
                    System.out.printf("Posisi anda {%d, %d}\n", x, y);
                    printCoordinatePlane(x, y);
                    break;
                case "q":
                    System.out.printf("Posisi akhir anda {%d, %d}\n", x, y);
                    printCoordinatePlane(x, y);
                    return;
                default:
                    System.out.println("Intput tidak valid");
                    break;
            }
        }
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
}
