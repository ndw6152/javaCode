package randomStuff;

import java.util.*;

/**
 * Created by ndw6152 on 6/24/2018.
 */
public class Go {

    public boolean check(int[][] board, boolean[][] visited, int r, int c, int val) {
        int rowSize = board.length;
        int colSize = board[0].length;

        if (r < 0 || r >= rowSize || c < 0 || c >= colSize) {  // if border
            return true;
        } else if (visited[r][c]) { // if already visited
            return true;
        }
        visited[r][c] = true;

        if (board[r][c] == 0) { // open gap
            return false;
        } else if (board[r][c] != val) { // blocked by a different character
            return true;
        }
        return checkPos(board, visited, r, c);
    }

    public boolean checkPos(int[][] board, boolean[][] visited, int r, int c) {
        int val = board[r][c];
        visited[r][c] = true;

        return check(board, visited, r, c - 1, val) &&
                check(board, visited, r, c + 1, val) &&
                check(board, visited, r - 1, c, val) &&
                check(board, visited, r + 1, c, val);
    }

    // function is used to check if the position is surrounded by another value
    // 0 represents a gap and no value is placed at that position
    public boolean isCaptured(int[][] board, int r, int c) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        if (col == 0) {
            return false;
        }
        if (r <= 0 || r >= row || c <= 0 || c >= col) {
            return false;
        }
        boolean[][] visited = new boolean[row][col];

        return checkPos(board, visited, r, c);
    }



    public ArrayList<Integer> solve(int p1, int p2, int p3, int k) {
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(k <= 0) {
            return result;
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(p1);primes.add(p2);primes.add(p3);

        HashSet<Integer> set = new HashSet<>();
        for(Integer p : primes) {
            if(!set.contains(p)) {
                set.add(p);
                minHeap.add(p);
            }
        }

        int temp;
        while(result.size() < k) {
            temp = minHeap.poll();
            result.add(temp);

            for(Integer p : primes) {
                int newVal = temp*p;
                if(!set.contains(newVal)) {
                    set.add(newVal);
                    minHeap.add(newVal);
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> maxset(int[] arr) {
        ArrayList<Integer> result = null;
        if(arr.length ==0) {
            return new ArrayList<>();
        }

        long maxSum = Integer.MIN_VALUE;
        long curSum = 0;
        ArrayList<Integer> current = new ArrayList<Integer>();
        for(int i =0; i< arr.length; i++) {
            if(arr[i] < 0) {
                if(curSum > maxSum) {
                    maxSum = curSum;
                    result = new ArrayList<Integer>(current);
                }
                curSum = 0;
                current = new ArrayList<Integer>();
            }
            else {
                curSum += arr[i];
                current.add(arr[i]);
            }
        }
        if(curSum > maxSum) {
            maxSum = curSum;
            result = new ArrayList<Integer>(current);
        }
        System.out.println(result);
        return result;
    }



    public static void main(String[] args) {
        Go sol = new Go();

        int[][] board =
                {{0,0,2,0,0},
                 {0,2,1,2,0},
                 {0,0,2,2,1},
                 {0,2,1,1,2},
                 {0,0,2,2,1}};

        System.out.println(sol.isCaptured(board, 0, 0) + " open position");
        System.out.println(sol.isCaptured(board, 1, 2) + " surrounded on 4 sides");
        System.out.println(sol.isCaptured(board, 3, 2) + " need to check the next pos to the right");
        System.out.println(sol.isCaptured(board, 3, 3) + " need to check the next pos to the left");
        System.out.println(sol.isCaptured(board, 4, 4) + " blocked by edge and other pieces");
        System.out.println(sol.isCaptured(board, 2, 4) + " checking top, this has a gap so false");
        System.out.println(sol.isCaptured(board, 5, 5) + " outside of board");
        System.out.println(sol.isCaptured(board, 7, 7) + " outside of board");

        System.out.println(sol.isCaptured(board, 2, 1) + " has gaps");


        System.out.println(sol.solve(19,31, 17,4));


        int[] a = {336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421};
        sol.maxset(a);
    }
}
