package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 6/1/2018.
 */
public class Solution {

    public static void backTrack(ArrayList<ArrayList<Integer>> allSolutions, ArrayList<Integer> solution,
                          int[] nums,int index) {

        for(int i = index; i < nums.length; i++) {
            solution.add(nums[i]);
            allSolutions.add(new ArrayList<>(solution));
            backTrack(allSolutions, solution, nums,i+1);
            solution.remove(solution.size() - 1);
        }
    }


    public  ArrayList<ArrayList<Integer>> allSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(nums.length == 0) {
            return results;
        }
        results.add(new ArrayList<>());
        backTrack(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }


    public void createPermutations(int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, boolean[] used){
        if(solution.size() == arr.length) {
            result.add(new ArrayList<>(solution));
        }
        else{
            for(int i = 0; i < arr.length; i++) {
                if(!used[i]) {
                    used[i] = true;
                    solution.add(arr[i]);
                    createPermutations(arr, result, solution, used);
                    solution.remove(solution.size()-1);
                    used[i] = false;
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> allPermutations(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        createPermutations(nums, result, new ArrayList<>(), used);

        return result;
    }



    public void createCombinations(int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution,
                                   int k, int index){
        if(solution.size() == k) {
            result.add(new ArrayList<>(solution));
        }
        else{
            for(int i = index; i < arr.length; i++) {
                solution.add(arr[i]);
                createCombinations(arr, result, solution, k, i+1);
                solution.remove(solution.size()-1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> allCombinations(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        createCombinations(nums, result, new ArrayList<>(), k, 0);

        return result;
    }

    public void createCombinationsAllowDuplicates(int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution,
                                                  int k, int index){
        if(solution.size() == k) {
            result.add(new ArrayList<>(solution));
        }
        else{
            for(int i = index; i < arr.length; i++) {
                solution.add(arr[i]);
                createCombinationsAllowDuplicates(arr, result, solution, k, i);
                solution.remove(solution.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> allComboDups(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        createCombinationsAllowDuplicates(nums, result, new ArrayList<>(), k, 0);

        return result;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1,2,3};
        ArrayList<ArrayList<Integer>> result = s.allSubsets(test);
        System.out.println(result );

        ArrayList<ArrayList<Integer>> result2 = s.allPermutations(test);
        System.out.println(result2);


        int[] test3 = {1,2,3,4,5};
        ArrayList<ArrayList<Integer>> result3 = s.allCombinations(test3, 3);
        System.out.println("size = " + result3.size());
        System.out.println(result3);
        ArrayList<ArrayList<Integer>> result4 = s.allComboDups(test3, 3);
        System.out.println("size = " + result4.size());
        System.out.println(result4);

    }
}
