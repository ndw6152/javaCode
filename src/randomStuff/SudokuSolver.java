package randomStuff;

import java.util.Hashtable;

/**
 * Created by ndw6152 on 6/12/2018.
 */

/*
Sudoku Solver
Write the function sudokuSolve that checks whether a given sudoku board (i.e. sudoku puzzle) is solvable. If so, the function will returns true. Otherwise (i.e. there is no valid solution to the given sudoku board), returns false.

In sudoku, the objective is to fill a 9x9 board with digits so that each column, each row, and each of the nine 3x3 sub-boards that compose the board contains all of the digits from 1 to 9. The board setter provides a partially completed board, which for a well-posed board has a unique solution. As explained above, for this problem, it suffices to calculate whether a given sudoku board has a solution. No need to return the actual numbers that make up a solution.

A sudoku board is represented as a two-dimensional 9x9 array of the characters ‘1’,‘2’,…,‘9’ and the '.' character, which represents a blank space. The function should fill the blank spaces with characters such that the following rules apply:

In every row of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
In every column of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
In every 3x3 sub-board that is illustrated below, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
A solved sudoku is a board with no blank spaces, i.e. all blank spaces are filled with characters that abide to the constraints above. If the function succeeds in solving the sudoku board, it’ll return true (false, otherwise).

*/
public class SudokuSolver {


    public boolean isValid(char[][] board, int r, int c, char choice) {
        for(int i =0; i<9; i++) { // check row
            if(board[i][c] == choice) {
                return false;
            }
            if(board[r][i] == choice) {
                return false;
            }

            if(board[r/3 * 3 + i/3][c/3 *3 + i%3] == choice) {
                return false;
            }
        }
        return true;
    }

    public boolean backtrack(char[][] board, int r, int c) {
        if(r == 9) {
            return true;
        }

        if(board[r][c] == '.') {
            for(int k =1; k<=9; k++) {
                if(isValid(board, r, c, Character.forDigit(k, 10))) {
                    board[r][c] = Character.forDigit(k, 10);
                    int nextRow = r;
                    int nextCol = c +1;
                    if(nextCol == 9) {
                        nextRow = r+1;
                        nextCol = 0;
                    }
                    boolean result = backtrack(board, nextRow, nextCol);
                    if(result) {
                        return true;
                    }
                }
            }
            board[r][c] = '.';
            return false;
        }
        else {
            int nextRow = r;
            int nextCol = c +1;
            if(nextCol == 9) {
                nextRow = r+1;
                nextCol = 0;
            }
            return backtrack(board, nextRow, nextCol);
        }
    }


    public boolean solveSudoku(char[][] board) {
        int rowSize = board.length;
        if(rowSize == 0) {
            return false;
        }
        int colSize = board[0].length;
        if(colSize == 0) {
            return false;
        }
        return backtrack(board, 0, 0);
    }

    public static void main(String[] args) {

        char[][] arr = {
                {'5','.','.','6','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        SudokuSolver s = new SudokuSolver();
        boolean result = s.solveSudoku(arr);
        System.out.println(result);
    }
}
