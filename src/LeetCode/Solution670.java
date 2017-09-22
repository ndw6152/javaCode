package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anonealio on 9/4/2017.
 */
public class Solution670 {
    public ArrayList<Integer> getStringArray(int val) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (val > 0) {
            arr.add(0, val % 10);
            val /= 10;
        }
        return arr;
    }

    public int createInt(ArrayList<Integer> arr) {
        int result = 0;
        for (int x : arr) {
            result = result * 10 + x;
        }
        return result;
    }


    public int maximumSwap(int num) {

        ArrayList<Integer> arr = getStringArray(num);

        int index = 0;
        // find if number is in descending order
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) > arr.get(i)) {
                index = i;
                break;
            } else if (i == arr.size() - 2) {
                return num;
            }
        }

        // find a number after index that is largest than index;
        int max = arr.get(index);
        int swapIndex = 0;
        for (int j = index; j <= arr.size() - 1; j++) {
            if (arr.get(j) > max) {
                max = arr.get(j);
                swapIndex = j;
            }
        }

        // find a number up to index that is less than max
        int minVal = 0;
        int minIndex = 0;
        for (int x = 0; x <= index; x++) {
            if (arr.get(x) < max) {
                minIndex = x;
                minVal = arr.get(x);
                break;
            }
        }

        // swap the values;
        arr.set(minIndex, max);
        arr.set(swapIndex, minVal);

        return createInt(arr);
    }

    public static void main(String[] args) {
        Solution670 s = new Solution670();
        List<List<Integer>> arr = new ArrayList<>();

        List<Integer> ar = Arrays.asList(1,1,1,1);
        int currentSolutionSum = ar.stream().mapToInt(value -> value).sum();
        int result = 0;
        for(int i : ar) {
            result += ar.get(i);
        }
        System.out.println(result);



        s.maximumSwap(98368);
    }

}