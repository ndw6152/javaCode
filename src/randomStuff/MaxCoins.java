package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 6/11/2018.
 */
public class MaxCoins {


    public static void backtrack(int[] result, int[] coins, int sum, int curAmount, int index, ArrayList<Integer> arr) {
        if(index == coins.length) {
            if(curAmount == sum ) { //&& arr.size() == coins.length) {
                result[0] = result[0]+1;
            }
            return;
        }

        for(int i = index; i < coins.length; i++) {

            for(int j =0; j * coins[i] + curAmount <= sum; j++) {

                arr.add(j * coins[i]);
                backtrack(result, coins, sum, curAmount + (j * coins[i]), i+1, arr);
                arr.remove(arr.size()-1);

            }

        }
    }

    public static int makeChange(int[] coins, int amount) {
        if(amount <= 0 || coins.length == 0) {
            return 0;
        }
        int[] result = new int[1];

        backtrack(result, coins, amount, 0, 0,new ArrayList<>());

        return result[0];
    }


    public static void backtrack(int[] coins, ArrayList<ArrayList<Integer>> result, int sum,
                                 ArrayList<Integer> current, int index, int curSum) {
        if(curSum >= sum) {
            if(curSum == sum) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i = index; i< coins.length; i++) {
            current.add(coins[i]);
            backtrack(coins, result, sum, current, i, curSum + coins[i]);
            current.remove(current.size()-1);
        }
    }

    public static ArrayList<ArrayList<Integer>> makeCombosCoins(int[] coins, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(k <= 0 || coins.length == 0) {
            return null;
        }

        backtrack(coins, result, k, new ArrayList<>(), 0, 0);

        return result;

    }



    public static void main(String[] arg) {
        int[] arr = {1, 10, 5, 25};

        System.out.println(makeCombosCoins(arr, 10));
    }

}
