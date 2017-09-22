package LeetCode;

/**
 * Created by Anonealio on 9/15/2017.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution47 {
    public void backTrack(Set<List<Integer>> allSolutions,
                          List<Integer> solution,
                          int[] nums,
                          boolean[] used) {

        if (solution.size() == nums.length) {
            allSolutions.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            else {
                solution.add(nums[i]);
                used[i] = true;
                backTrack(allSolutions, solution, nums, used);
                used[i] = false;
                solution.remove(solution.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        boolean[] used = new boolean[nums.length];
        backTrack(set, new ArrayList<>(), nums, used);

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);

        return result;
    }
}