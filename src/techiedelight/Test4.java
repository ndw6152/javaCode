package techiedelight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Anonealio on 9/24/2017.
 * Find all valid words in a boggle board game (3x3)
 * http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 */
public class Test4 {

    HashSet<String> set;

    public Test4() {
        set = new HashSet<>();
        initializeSet();
    }

    class Coord {
        int r;
        int c;

        Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void initializeSet() {
        set.add("GEEKS");
        set.add("FOR");
        set.add("QUIZ");
        set.add("GO");
    }


    // functions checks if position is valid within the board and has not been visited yet.
    public boolean isValid(int r, int c, boolean[][] visited) {
        return r >=0 && r <visited.length && c >= 0 && c < visited.length && !visited[r][c];
    }

    // returns a list of all possible next neighbors to visit from current position.
    public List<Coord> createNeighbors(boolean[][] visited, int row, int col) {
        List<Coord> result = new ArrayList<>();

        for(int r = row -1; r <= row +1; r++) {
            for(int c = col -1; c <= col +1; c++) {

                if(isValid(r, c, visited)) {
                    result.add(new Coord(r, c));
                }

            }
        }
        return result;
    }

    public void backTrack(List<String> allSolution, StringBuffer solution, char[][] grid, int r, int c, boolean[][] visited) {
        String current = solution.toString();
        if(set.contains(current)) {
            allSolution.add(current);
        }
        if(current.length() == 9) {
            return;
        }

        List<Coord> neighbors = createNeighbors(visited, r, c);
        int row;
        int col;
        for(Coord coord : neighbors) {
            row = coord.r;
            col = coord.c;
            solution.append(grid[row][col]);
            visited[row][col] = true;
            backTrack(allSolution, solution, grid, row, col, visited);
            visited[row][col] = false;
            solution.deleteCharAt(solution.length() -1);
        }
    }

    public List<String> getOutputWordsFromBoard(char[][] grid) {
        List<String> result = new ArrayList<>();

        int row = grid.length;
        int col = 0;
        if(row > 0) {
            col = grid[0].length;
        }
        if(row > 0 && col >0) {
            boolean[][] visited;

            for(int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    visited = new boolean[row][col];
                    StringBuffer sb = new StringBuffer();
                    sb.append(grid[r][c]);
                    visited[r][c] = true;
                    backTrack(result, sb, grid, r, c, visited);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test4 test = new Test4();
        char[][] board  = {{'G','I','Z'},
                            {'U','E','K'},
                            {'Q','S','E'}};

        System.out.println(test.getOutputWordsFromBoard(board));

        System.out.println("1".compareTo("14"));
    }
}
