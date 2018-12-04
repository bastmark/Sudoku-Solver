package sudoku;

import java.util.Arrays;

public class Sudoku {
    private int[][] board;
    private int size = 9;
    private int empty=0;

    public Sudoku() {
        board = new int[size][size];
    }

    public boolean insert(int value, int row, int col) {
        try {
            board[row][col] = value;
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int get(int row, int col) {
        try {
            return board[row][col];
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    public boolean solved() {
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
            if (containsDuplicates(r) || containsDuplicates(c) || containsDuplicates(s)) {
                return false;
            }
        }

        return true;
    }
    
    public boolean solve() {
    	for(int row=0;row<size; row++) {
    		for(int col=0;col<size; col++) {
    			if(board[row][col]==empty) {						//Check if box is empty
    				for(int number=1; number<=size; number++) {
    					if(solved()==true) {
    						insert(number, row, col);
    					}
    					if(solved()) {
    						return true;
    					}else {
    						board[row][col]=empty;
    					}
    				}
    			}
    			return false;
    		}
    	}
    	return true;
    }

    
    private boolean containsDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
