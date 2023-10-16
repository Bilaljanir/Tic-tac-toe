import java.util.Scanner;

public class Main {
    private static final char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
    }

    private static void initializeBoard() {
        char cellValue = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cellValue++;
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
