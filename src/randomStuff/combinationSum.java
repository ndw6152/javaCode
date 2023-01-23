package randomStuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by ndw6152 on 7/8/2018.
 */
public class combinationSum {

    public void backtrack(ArrayList<ArrayList<Integer>> result,
                          ArrayList<Integer> current,
                          ArrayList<Integer> arr,
                          int sum,
                          int index ) {

        if(sum < 0) {
            return;
        }
        if(sum ==0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < arr.size(); i++) {
            current.add(arr.get(i));
            backtrack(result, current, arr, sum -arr.get(i), i+1);
            current.remove(current.size()-1);
        }

    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(arr.size() == 0 || sum < 0){
            return result;
        }

        Collections.sort(arr);

        backtrack(result, new ArrayList<>(), arr, sum, 0);
        return result;
    }


    public void backtrack2(HashSet<ArrayList<Integer>> result,
                          ArrayList<Integer> current,
                          ArrayList<Integer> arr,
                          int sum,
                          int index) {

        if(sum < 0) {
            return;
        }

        if(sum ==0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i =index; i < arr.size(); i++) {
            current.add(arr.get(i));
            backtrack2(result, current, arr, sum - arr.get(i), i);
            current.remove(current.size()-1);
        }

    }


    public ArrayList<ArrayList<Integer>> combinationSum22(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(arr.size() == 0) {
            return result;
        }

        Collections.sort(arr);
        HashSet<ArrayList<Integer>> resultSet = new HashSet<>();
        backtrack2(resultSet, new ArrayList<>(), arr, sum, 0);
        return new ArrayList<>(resultSet);
    }
    public static void main(String[] args) {
        combinationSum sol = new combinationSum();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(8);arr.add(10);arr.add(6);arr.add(11);arr.add(1);arr.add(16);arr.add(8);
        sol.combinationSum(arr, 28);
    }
}
