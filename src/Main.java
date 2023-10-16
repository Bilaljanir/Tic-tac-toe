import java.util.Scanner;

public class Main {
    private static final char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        playGame();

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
    private static void playGame() {
        boolean gameFinished = false;
        char winner = ' ';

        while (!gameFinished) {
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (checkForWin(row, col)) {
                winner = currentPlayer;
                gameFinished = true;
            }
            else if(isBoardFull()) {
                gameFinished = true;
            } else  {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        } else (){
            System.out.println("Invalid move. Try again.");
        }
    }
        if (winner != ' ') {
        System.out.println("Player " + winner + " wins!");
    } else {
        System.out.println("It's a draw!");
    }
}

    private static int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + ", enter the number of the cell you want to mark: ");
        int selectedCell = scanner.nextInt();

        if (selectedCell >= 1 && selectedCell <= 9) {
            move[0] = (selectedCell - 1) / 3;
            move[1] = (selectedCell - 1) % 3;
        } else {
            System.out.println("Invalid cell number. Try again.");
            return getPlayerMove();
        }

        return move;
    }
}