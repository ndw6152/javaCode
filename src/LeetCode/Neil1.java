//package LeetCode;
//
///**
// * Created by Anonealio on 9/12/2017.
// */
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time.
//        The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        How many possible unique paths are there?
//
//
//        https://leetcode.com/static/images/problemset/robot_maze.png
//        Above is a 3 x 7 grid. How many possible unique paths are there?
//
//        Note: m and n will be at most 100.
//
//        9:52
//
//        [a,x,x,x,x,x]
//        [x,c,x,x,x,x]
//        [x,x,x,x,x,z]
//
//        [a,b]
//        [c,d]
//
//        a b d
//        a c d 2
//
//        [a,b,c]		[1,1,1]
//        [d,e,f]		[1,2,3]
//        [g,h,i]		[1,3,6]
//
//        a,b,c,f,i
//        a,b,e,f,i
//        a,b,e,h,i
//        a,d,e,h,i
//        a,d,e,f,i
//        a,d,g,h,i
//
//
//
//        [a,b]
//        [c,d]
//
//        Time O(mXn)  space O(mn);
//class Solution {
//
//
//  []
//          [1,1]
//          [1, 10]
//
//
//          [[0,0,0],
//          [0,1,0],
//          [0,0,0]]
//
//          [1,1,1]
//          [1,-1,1]
//          [1,1,2]
//    public int uniquePathsWithObstacles(int[][] matrix) {
//
//    }
//    public int uniquePaths(int row, int col) {
//
//        if(row <=0 || col <=0) {
//            return -1;
//        }
//
//        //int[][] matrix = new int[row][col];
//
//        matrix[0][0] = 1;
//        int left =0;
//        int top =0;
//        int val = 0;
//        for(int r =0; r < row; r++;) {
//
//            for(int c=0; c<col; c++) {
//                if(r ==0 && c == 0) {
//                    continue;
//                }
//                if(matrix[r][c] == 1) { // checks if obstacle
//                    matrix[r][c] = -1;
//                    continue;
//                }
//
//                left = 0;
//                top = 0;
//                if(c-1 >= 0 && matrix[r][c-1] != -1) {
//                    left = matrix[r][c-1];
//                }
//                if(r-1 >=0 && matrix[r-1][c] != -1) {
//                    top = matrix[r-1][c];
//                }
//                val = left + top;
//
//                if(r == row-1 && c == col-1) {
//                    return val;
//                }
//                matrix[r][c] = val;
//            }
//        }
//        return 0;
//    }
//}
//
//  https://leetcode.com/problems/minimum-path-sum/description/
//  https://leetcode.com/problems/unique-paths-ii/description/
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
