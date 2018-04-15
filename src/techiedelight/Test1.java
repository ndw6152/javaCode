package techiedelight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Anonealio on 9/23/2017.
 */
public class Test1 {

    void backTrack(HashSet<List<Integer>> allSolution, List<Integer> solution, int[] input, int index, int k) {
        if (solution.size() == k) {
            allSolution.add(new ArrayList<>(solution));  // 112, 113, 123,
            return;
        }

        for (int i = index; i < input.length; i++) {        // index = 1+1; value 2
            solution.add(input[i]);
            backTrack(allSolution, solution, input, i + 1, k);
            solution.remove(solution.size() - 1);
        }


    }


    public HashSet<List<Integer>> findCombinations(int[] input, int k) {
        HashSet<List<Integer>> result = new HashSet<>();
        if (input.length == 0) {
            return result;
        }
        Arrays.sort(input);
        backTrack(result, new ArrayList<>(), input, 0, 2);
        return result;
    }


    public static void main(String[] args) {
        Test1 t = new Test1();
        int[] arr = {1, 2, 1};
        HashSet s = t.findCombinations(arr, 2);
    }

}