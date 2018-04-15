package FireCode;

import java.util.ArrayList;
import java.util.Hashtable;

///
/// Print all paths from top left to bottom right
///
public class PrintPath {

    public void solver(char[][] board, ArrayList<String> result, StringBuilder sb, int row, int col, int r, int c) {
        sb.append(board[r][c]);

        if(r == row -1 && c == col -1) {
            String str = sb.toString();
            result.add(str);
            return;
        }
        if(c + 1 < col) {
            solver(board, result, sb, row, col, r, c+1);
            sb.deleteCharAt(sb.length() -1);
        }
        if(r +1 < row) {
            solver(board, result, sb, row, col, r+1, c);
            sb.deleteCharAt(sb.length() -1);
        }
    }


    public void solver2(char[][] board, ArrayList<String> result, StringBuilder sb, int row, int col, int r, int c) {
        if(r == row || c == col) {
            return;
        }
        sb.append(board[r][c]);

        if(r == row -1 && c == col -1) {
            String str = sb.toString();
            result.add(str);
            sb.deleteCharAt(sb.length() -1);
            return;
        }
        solver2(board, result, sb, row, col, r, c+1);
        solver2(board, result, sb, row, col, r+1, c);
        sb.deleteCharAt(sb.length() -1);
    }

    public ArrayList<String> printPaths(char[][] board){
        int row = board.length;
        if(row == 0) {
            return new ArrayList<>();
        }
        int col = board[0].length;
        if(col == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solver2(board, results, sb, row, col, 0, 0);
        return results;
    }

    public static int[] coupleSum(int[] numbers, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>();

        int diff;
        int index;
        int[] result = new int[2];

        for(int i = 0; i<numbers.length; i++) {
            diff = target - numbers[i];
            if(table.get(diff) != null) {
                System.out.println(diff);
                result[0] = table.get(diff);
                result[1] = i+1;
                return result;
            }
            else {
                table.put(diff, i+1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        PrintPath sol = new PrintPath();
        char[][] table = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

        ArrayList<String> result = sol.printPaths(table);
        System.out.println(result.get(0));

        int[ ]arra = {1,9,2,4,5};
        coupleSum(arra, 10);
    }
}
