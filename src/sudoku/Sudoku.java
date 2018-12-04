package sudoku;

import java.util.Arrays;

public class Sudoku {
    private int[][] board;
    private int size = 9;
    private int empty=0;

    public Sudoku() {
        board = new int[size][size];
    }

    public Sudoku(int[][] board){
        this.board = board;
        size = board.length;
    }

    public int size() {
        return size;
    }

    public boolean insert(int value, int row, int col) {
        try {
            board[row][col] = value;
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int[][] getBoard(){
        return board;
    }

    public int get(int row, int col) {
        try {
            return board[row][col];
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    // Checks if the board has been solved. If "useValid" is set to true, the function checks if the board
    // is valid this far, (multiple zeroes aren't counted as duplicates)
    public boolean solved(boolean useValid) {
        for (int i = 0; i < size; i++) {
            int[] r = new int[size];
            int[] c = new int[size];
            int[] s = new int[size];

            for (int j = 0; j < size; j++) {
                // Get all values in row
                r[j] = board[i][j];
                // Get all values in column
                c[j] = board[j][i];
                // Get all values in section
                s[j] = board[(i % 3) * 3 + j % 3][(int) (j / 3) + (int) (i / 3) * 3];
            }

            // Check if any of the arrays (row, column, section) contain duplicate values
            if (containsDuplicates(r, useValid) || containsDuplicates(c, useValid) || containsDuplicates(s,useValid)) {
                return false;
            }
        }

        return true;
    }

    // new solve function in the making
    public boolean solve() {
    	return true;
    }

    private boolean containsDuplicates(int[] arr, boolean useValid) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (useValid) {
                    if (arr[i] == arr[j] && arr[i] != 0 && arr[j] != 0) {
                        return true;
                    }
                } else {
                    if (arr[i] == arr[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
