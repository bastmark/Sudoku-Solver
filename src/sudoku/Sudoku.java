package sudoku;

import java.util.Arrays;
import static sudoku.Utils.containsDuplicates;
import static sudoku.Utils.flatten;

/**
 * Sudoku class used to create a Sudoku object. Containing methods using backtracking to solve a sudoku puzzle.
 *
 * @author Johannes Bastmark
 * @author Szymon Stypa
 * @author Axel Domell
 *
 * @version 1.0
 * @see <a href="https://github.com/bastmark/Sudoku-solver">Github repository</a>
 */
public class Sudoku {
    private int[][] board;
    private int size = 9;

    /**
     * Sudoku constructor.
     */
    public Sudoku() {
        board = new int[size][size];
    }

    /**
     * Sudoku constructor.
     * @param board corresponds to a sudoku puzzle
     */
    public Sudoku(int[][] board){
        this.board = board;
        size = board.length;
    }

    /**
     * Returns size. Size is the length or height of the board.
     * @return int size
     */
    int size() {
        return size;
    }

    /**
     * Returns filled. True if board contains no "0" else false.
     * @return boolean filled
     */
    private boolean filled() {
        return flatten(board).noneMatch(value -> value.equals(0));
    }

    /**
     * Inserts value at row, col in the sudoku board.
     * Returns true if value could be inserted at position else false.
     * @param value value
     * @param row row in board
     * @param col column in board
     * @return boolean insert
     */
    boolean insert(int value, int row, int col) {
        try {
            board[row][col] = value;
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Returns the sudoku board.
     * @return int[][] getBoard
     */
    int[][] getBoard(){
        return board;
    }

    /**
     * Returns value at row, col in the sudoku board.
     * @param row row in board
     * @param col column in board
     * @return int value
     */
    int get(int row, int col) {
        try {
            return board[row][col];
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    /**
     * Returns boolean. True if board is valid else false.
     * Board is valid if no value exist more than one time in each given row, column and section of the sudoku board.
     * values of 0 can be multiple.
     * @return boolean valid
     */
    boolean valid() {
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
                s[j] = board[(i % 3) * 3 + j % 3][(j / 3) + (i / 3) * 3];
            }

            // Strip the zeros (since we only want to check if current input is valid)
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

    /**
     * Returns boolean. True if board is solved else false (valid and filled).
     * Board is valid if no value exist more than one time in each given row, column and section of the sudoku board.
     * @return boolean solved
     */
    boolean solved() {
        return valid() && filled();
    }

    /**
     * Returns boolean. True if the sudoku board could be solved else false.
     * @return boolean solve
     */
    boolean solve() {
        if (!valid()) return false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // If there is a 0 value
                if (board[i][j] == 0) {
                    // Generate a value that fits the board
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = k;
                        if (solve()) return true;
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns String. Returns a string representation of the current sudoku board.
     * @return String toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] row : board) {
            for (int val : row) {
                sb.append(val).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
