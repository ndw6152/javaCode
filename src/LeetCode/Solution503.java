package LeetCode;

import java.util.Stack;

/**
 * Created by Anonealio on 9/11/2017.
 */
public class Solution503 {
        class Pair {
            public int index;
            public int val;

            Pair(int index, int val) {
                this.index = index;
                this.val = val;
            }
        }

        public void nextGreaterElements() {
            int[] arr = new int[3];
            arr[0] = 1;
            System.out.println(arr.length);


            for( int i = 0; i< arr.length; i++ ){
                System.out.println(arr[i]);
            }

        }

        public static void main(String[] args) {
            Solution503 s = new Solution503();
            s.nextGreaterElements();
        }
}