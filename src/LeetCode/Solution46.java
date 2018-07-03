package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anonealio on 9/15/2017.
 * Permutation problem using backtracking and an additional nums[] to save whether you were used already or not
 */
public class Solution46 {

    public void backTrack(ArrayList<ArrayList<Integer>> allSolutions,
                          ArrayList<Integer> solution,
                          int[] nums,
                          boolean[] used) {

        if (solution.size() == nums.length) {
            allSolutions.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                solution.add(nums[i]);
                used[i] = true;
                backTrack(allSolutions, solution, nums, used);
                used[i] = false;
                solution.remove(solution.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        if (nums.length == 0) {
            return array;
        }
        boolean[] used = new boolean[nums.length];
        backTrack(array, new ArrayList<>(), nums, used);
        return array;
    }

    public static void main(String[] args) {
        Solution46 s = new Solution46();
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> result  = s.permute(arr);
        System.out.println(result);
    }
}