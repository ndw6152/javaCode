package LeetCode;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ndw6152 on 6/18/2018.
 */
public class Solution771 {

    public int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        for(Character ch : J.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for(Character ch : S.toCharArray()) {
            if(set.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    public boolean repeatedSubstringPattern(String s) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new  HashSet<>();

        dp[0] = true;

        for(int i =1; i <= s.length(); i++) {
            set.add(s.substring(0,i));

            for(int j = 1; j< i; j++) {
                if(set.contains(s.substring(0, j)) && set.contains(s.substring(j, i)) && s.substring(0, j).equals(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        int index = 'b' -'a';
        System.out.println(arr[index]);
        StringBuilder sb = new StringBuilder();
        String s = "ABC";
        System.out.println(s.substring(0,3));
        boolean[] dp = new boolean[s.length() + 1];


        Solution771 sol = new Solution771();

        System.out.println(sol.repeatedSubstringPattern("ababab"));
    }


}
