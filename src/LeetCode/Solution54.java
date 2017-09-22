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

    public static void main(String[]args) {
        Solution54 s = new Solution54();
        int[][] matrix ={{7},{9},{6}}; //{{1,1,1,1},{4,5,6,4},{2,2,2,2}};// {{1,2,3},{4,5,6},{7,8,9}};
        s.spiralOrder(matrix);

        s.hammingWeight(11);
    }
}