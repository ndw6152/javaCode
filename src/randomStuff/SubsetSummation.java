package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 7/1/2018.
 */
public class SubsetSummation {
    public static void backtrack(int[] arr, int target, int index, int sum, boolean[] result) {
        if(sum == target) {
            result[0] = true;
            return;
        }
        if(sum > target || result[0] == true) {
            return;
        }
        int curSum = sum;
        for(int i = index; i < arr.length; i++) {
            curSum += arr[i];
            backtrack(arr, target, i+1, curSum, result);
            curSum -= arr[i];
        }

    }
    public static boolean groupSum(int[] arr, int target) {
        if(arr.length == 0) {
            return false;
        }

        boolean[] result = new boolean[1];

        backtrack(arr, target, 0, 0, result);
        return result[0];
    }


    public static ArrayList<String> combo(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length() == 0) {
            return result;
        }
        if(str.length() == 1) {
            result.add(str);
            return result;
        }

        char ch = str.charAt(0);
        ArrayList<String> array2 = combo(str.substring(1));
        result.addAll(array2);
        result.add(ch +"");

        for(String s : array2) {
            for(int i =0; i <= s.length(); i++) {
                result.add(s.substring(0, i) + ch + s.substring(i, s.length()));
            }
        }
        return result;
    }

    public static ArrayList<String> getCombPerms(String s) {
        if(s == null) {
            return null;
        }
        return combo(s);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 5, 6,5};
        groupSum(arr, 30);

        getCombPerms("abc");

        String str = "hello";
    }

}
