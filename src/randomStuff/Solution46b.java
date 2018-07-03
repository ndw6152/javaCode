package randomStuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anonealio on 9/15/2017.
 * Permutation problem using backtracking and an additional nums[] to save whether you were used already or not
 *
 * monsoon hacker rank problem
 */
public class Solution46b {


    public int getSum(List<Integer> arr) {
        int sum = 0;
        for(int i =0;i<arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    public void backTrack(ArrayList<ArrayList<Integer>> allSolutions,
                          List<Integer> solution,
                          int[] nums,
                          int n) {
        if (getSum(solution) > n) {
            return;
        }
        if (getSum(solution) == n) {
            allSolutions.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(solution.size() > 0) {
                if(nums[i] < solution.get(solution.size()-1)) {
                    continue;
                }
            }
            solution.add(nums[i]);
            backTrack(allSolutions, solution, nums, n);
            solution.remove(solution.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] nums, int n) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        if (nums.length == 0) {
            return array;
        }
        backTrack(array, new ArrayList<>(), nums, n);
        return array;
    }

    public int findMinArray(ArrayList<ArrayList<Integer>> arrays) {
        int count = Integer.MAX_VALUE;
        for(int i = 0; i<arrays.size(); i++) {
            int size = arrays.get(i).size();
            if(size < count) {
                count = size;
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }





    public static void main(String[] args) {
        Solution46b s = new Solution46b();
        int[] arr = {1, 3};
        ArrayList<ArrayList<Integer>> array = s.permute(arr, 6);
        System.out.println(array);
        System.out.println(s.findMinArray(array));



        int[] arr2 = {1, 3, 6};
        ArrayList<ArrayList<Integer>> arrays2 = s.permute(arr2, 6);
        System.out.println(arrays2);
        System.out.println(s.findMinArray(arrays2));

    }
}