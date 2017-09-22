package LeetCode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anonealio on 9/5/2017.
 */
public class Solution633 {

    public int getSquare(List<Integer> solution) {
        int result = 0;
        for (int i : solution) {
            result += i * i;
        }
        return result;
    }

    boolean flag = false;

    public void backTrack(List<Integer> solution, int k, int start, int sum) {
        if (solution.size() == k) {
            int result = getSquare(solution);
            if (sum == result) {
                flag = true;
                return;
            }
        } else {
            if (!flag) {
                for (int i = start; i <= Math.sqrt(sum); i++) {
                    if (!flag) {
                        solution.add(i);
                        backTrack(solution, k, i + 1, sum);
                        solution.remove(solution.size() - 1);
                    }
                }
            }
        }
    }

    public boolean judgeSquareSum(int c) {
        backTrack(new ArrayList<Integer>(), 2, 0, c);
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Stack<Character> s= new Stack<>();
        return flag;
    }


    public static void main(String[] args) {
        Solution633 s = new Solution633();
        s.judgeSquareSum(2);
    }
}