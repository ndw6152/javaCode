package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anonealio on 9/6/2017.
 */
public class Solution54 {

    ArrayList<Integer> array = new ArrayList<>();
    int u;
    int d;
    int l;
    int r;

    public void printOuterLayer(int[][] matrix, int u, int d, int l, int r) {
        for (int i = l; i <= r; i++) { // print top
            array.add(matrix[u][i]);
        }
        for (int j = u + 1; j <= d; j++) { // print right
            array.add(matrix[j][r]);
        }
        this.u++;
        this.r--;

        if(u >d || r < l) {
            this.u++;
            this.d--;
            this.l++;
            this.r--;
            return;
        }
        for (int x = r - 1; x >= l; x--) { // print bottom
            array.add(matrix[d][x]);
        }
        for (int y = d - 1; y > u; y--) { // print left
            array.add(matrix[y][l]);
        }

        this.d--;
        this.l++;

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        u = 0;
        d = matrix.length - 1;

        l = 0;
        r = matrix[0].length - 1;

        while (u <= d && l <= r) {
            printOuterLayer(matrix, u, d, l, r);
        }

        return this.array;
    }

    public int hammingWeight(int n) {
        int count = 0;

        int value = n;
        while(value !=0) {  // in reverse
            count += value%2;
            System.out.print(value%2);
            value /= 2;
        }
        return count;
    }

    public void spiral(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        int row = matrix.length;
        if(row == 0) {
            return;
        }
        int col = matrix[0].length;

        int r = 0;
        int c = 0;

        while(row> 0 || col > 0) {
            if(row == 1) {
                for(int i =0; i<col; i++) {
                    System.out.print(matrix[r][c++] +" ");
                }
                return;
            }
            else if(col == 1) {
                for(int i =0; i<row; i++) {
                    System.out.print(matrix[r++][c] +" ");
                }
                return;
            }
            else {
                for(int i =1; i < col; i++ ) {  // right
                    System.out.print(matrix[r][c++] +" ");
                }
                for(int i =1; i < row; i++ ) {  // down
                    System.out.print(matrix[r++][c] +" ");
                }
                for(int i =1; i < col; i++ ) {  // left
                    System.out.print(matrix[r][c--] +" ");
                }
                for(int i =1; i < row; i++ ) { // top
                    System.out.print(matrix[r--][c] +" ");
                }

                row -= 2;
                col -= 2;
                r++; c++;
            }
        }
    }

    public int[][] spiralSquare(int n) {
        if(n < 0) {
            return null;
        }

        int[][] matrix = new int[n][n];

        int count = 1;
        int r = 0;
        int c = 0;

        while(n > 0) {
            if(n == 1) {
                matrix[r][c] = count++;
            }

            for(int i =1; i < n; i++ ) {  // right
                matrix[r][c++] = count++;
            }
            for(int i =1; i < n; i++ ) {  // down
                matrix[r++][c] = count++;
            }
            for(int i =1; i < n; i++ ) {  // left
                matrix[r][c--] = count++;
            }
            for(int i =1; i < n; i++ ) { // top
                matrix[r--][c] = count++;
            }

            n -= 2;
            r++; c++;
        }
        return matrix;
    }

    public ArrayList<ArrayList<Integer>> createArray(int[][] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i =0; i < arr.length; i++) {
            for(int j =0; j < arr[0].length; j++) {
                temp.add(arr[i][j]);
            }
            result.add(temp);
            temp = new ArrayList<>();
        }
        return result;
    }

    public void printMatrix(int[][] arr) {
        if(arr == null) {
            return;
        }
        for(int i =0; i < arr.length; i++) {
            for(int j =0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printArrayList(ArrayList<ArrayList<Integer>> arr) {
        if(arr == null) {
            return;
        }
        for(int i =0; i < arr.size(); i++) {
            for(int j =0; j < arr.get(0).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[]args) {
        Solution54 s = new Solution54();
//        int[][] matrix ={{7},{9},{6}}; //{{1,1,1,1},{4,5,6,4},{2,2,2,2}};// {{1,2,3},{4,5,6},{7,8,9}};
//        s.spiralOrder(matrix);
//        s.hammingWeight(11);
        int[][] arr = s.spiralSquare(3);
        s.printMatrix(arr);

        int[][] arr2 = s.spiralSquare(5);
        s.printMatrix(arr2);

        ArrayList<ArrayList<Integer>> result = s.createArray(arr2);
        s.printArrayList(result);

        s.spiral(arr2);


    }
}