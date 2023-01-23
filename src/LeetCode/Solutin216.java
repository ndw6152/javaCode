package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anonealio on 9/5/2017.
 */
class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int sum) {
        List<List<Integer>> allSolution = new ArrayList<>();
        backTrack(allSolution, new ArrayList<Integer>(), k, 1, sum); // startIndex = 1
        System.out.println(allSolution);
        System.out.println(allSolution.size());
        return allSolution;
    }


    public int getSum(List<Integer> solution) {
        int result = 0;
        for (int i : solution) {
            result += i;
        }
        return result;
    }

    public void backTrack(List<List<Integer>> allSolution,
                          List<Integer> currentSolution,
                          int maxSize,
                          int startIndex,
                          int sum) {

        int[] numbersAvailable = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // except 0;
        if (currentSolution.size() == maxSize) {
            int result = getSum(currentSolution);
            if (sum == result) {
                allSolution.add(new ArrayList<>(currentSolution));
            }
        } else {
            for (int i = startIndex; i < numbersAvailable.length; i++) {
                currentSolution.add(numbersAvailable[i]);
                backTrack(allSolution, currentSolution, maxSize, i + 1, sum);
                currentSolution.remove(currentSolution.size() - 1);
            }
        }
    }


    public List<List<Integer>> combinationSum32(int k, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, sum);

        return ans;
    }

    private void combination(
            List<List<Integer>> ans,
            List<Integer> comb,
            int k,
            int start,
            int sum) {
        if (comb.size() == k && sum == 0) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i + 1, sum - i);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution216 s = new Solution216();
        s.combinationSum3(3, 7);

    }


    public static void mainn(String[] args) {

    }
}
