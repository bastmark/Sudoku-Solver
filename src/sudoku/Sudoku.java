package sudoku;

import java.util.Arrays;

import static sudoku.Utils.containsDuplicates;
import static sudoku.Utils.flatten;

public class Sudoku {
    private int[][] board;
    private int size = 9;

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

    public boolean filled() {
        return flatten(board).noneMatch(value -> value.equals(0));
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

    // Checks if the board is valid so far
    public boolean valid() {
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

            r = Arrays.stream(r).filter(value -> value != 0).toArray();
            c = Arrays.stream(c).filter(value -> value != 0).toArray();
            s = Arrays.stream(s).filter(value -> value != 0).toArray();

            // Check if any of the arrays (row, column, section) contain duplicate values
            if ((containsDuplicates(r) || containsDuplicates(c) || containsDuplicates(s))) {
                return false;
            }
        }

        return true;
    }

    // Checks if the sudoku has been solved (valid and all values are != 0)
    public boolean solved() {
        return valid() && filled();
    }

    // new solve function in the making
    public boolean solve() {
    	return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] row : board) {
            for (int val : row) {
                sb.append(String.valueOf(val)).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
