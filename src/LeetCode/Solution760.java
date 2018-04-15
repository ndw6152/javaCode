package LeetCode;

import java.util.*;

/**
 * Created by Anonealio on 1/25/2018.
 */
public class Solution760 {

    public Hashtable<Integer, ArrayList<Integer>> createTable(int[] arr) {
        Hashtable<Integer, ArrayList<Integer>> table = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            if (table.get(arr[i]) == null) {
                ArrayList<Integer> data = new ArrayList<>();
                data.add(i);
                table.put(arr[i], data);
            } else {
                ArrayList<Integer> data = table.get(arr[i]);
                data.add(i);
                table.put(arr[i], data);
            }
        }
        return table;
    }


    public int[] anagramMappings(int[] A, int[] B) {

        Hashtable<Integer, ArrayList<Integer>> table = createTable(B);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (table.get(A[i]) != null) {
                ArrayList<Integer> data = table.get(A[i]);
                if (data.size() != 0) {
                    result.add(data.get(i));
                    data.remove(0);
                    table.put(A[i], data);
                }
                return new int[0];
            } else {
                return new int[0];
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}