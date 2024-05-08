import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.scanner.util;


public class tictactoe {
    
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
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
            System.out.println();
            System.out.println("-------------");
        }
    }

    
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
                (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]);
    }

    
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        printBoard();

        while (!isBoardFull()) {
            System.out.print("Player " + currentPlayer + ", enter your move (row [0-2] column [0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            
            board[row][col] = currentPlayer;
            printBoard();

            
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            switchPlayer();
        }

        if (!checkWin()) {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

