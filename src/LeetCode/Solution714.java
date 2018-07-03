package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ndw6152 on 6/19/2018.
 */
public class Solution714 {
    public int maxProfit(int[] arr, int fee) {
        int size = arr.length;

        int sum = 0;
        int curBy = Integer.MAX_VALUE;
        int curSell = Integer.MIN_VALUE;

        for(int i = 0; i < size;) {
            while(i < size && arr[i] < curBy) {
                curBy = arr[i];
                i++;
            }
            while(i <size && arr[i] > curSell) {
                curSell = arr[i];
                i++;
            }
            if(curSell - curBy - fee > 0) {
                sum += curSell - curBy - fee;
                curBy = Integer.MAX_VALUE;
                curSell = Integer.MIN_VALUE;
            }
            else {
                i++;
            }
        }
        return sum;

    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] minBuy = new int[prices.length];
        int[] sell = new int[prices.length];

        minBuy[0] = -prices[0];
        sell[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            minBuy[i] = Math.max(minBuy[i-1], (sell[i-1]-prices[i]));
            sell[i] = Math.max(sell[i-1], prices[i] + minBuy[i-1] - fee);
        }
        return sell[prices.length-1];
    }


    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A == 0) {
            result.add(1);
            return result;
        }
        if(A == 1) {
            result.add(1);
            result.add(1);
        }
        ArrayList<Integer> temp;
        for(int i =2; i<= A; i++) {
            temp = new ArrayList<>();
            temp.add(1);

            for(int j = 1; j<result.size(); j++) {
                int val = result.get(j) + result.get(j-1);
                System.out.println(val);
                temp.add(val);
            }
            temp.add(1);
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution714 sol = new Solution714();
//        int[] arr = {1, 3, 2, 8, 4, 9};
//        System.out.println(sol.maxProfit2(arr, 2));
//
//        int[] arr2 = {1,3,7,5,10,3};
//        System.out.println(sol.maxProfit2(arr2, 3));
        //sol.getRow(2);
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(4,3,2,1));
        Collections.sort(arr);
        System.out.println(arr);
    }


}
