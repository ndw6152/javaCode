package LeetCode;

import java.util.Arrays;

/**
 * Created by Anonealio on 9/19/2017.
 * Longest palindromic substric in a string
 */
public class Solution5 {
    int max = 0;
    int low = 0;
    int high = 0;

    public void expandFromChar(String s, int left, int right) {
        int low = 0;
        int high = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            low = left;
            high = right;
            left--;
            right++;
        }

        if (max < high - low + 1) {
            this.low = low;
            this.high = high + 1; // excluding the right char
            this.max = high - low + 1;
        }
    }

    public String longestPalindrome(String s) {
        max = 0;
        low = 0;
        high = 0;

        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            expandFromChar(s, i, i);
            expandFromChar(s, i, i + 1);
        }
        return s.substring(low, high);
    }


    public int expandFromCenter(String str, int i, int j) {
        int low = 2;
        int high = 1;

        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            low = i;
            high = j;
            i--;
            j++;
        }
        return high - low + 1;
    }

    public int longestLengthPalindrome(String s) {
        int max = 0;

        int currentLength = 0;
        for (int x = 0; x < s.length(); x++) {
            currentLength = expandFromCenter(s, x, x);
            if (currentLength > max) {
                max = currentLength;
            }
            currentLength = expandFromCenter(s, x, x + 1);
            if (currentLength > max) {
                max = currentLength;
            }
        }
        return max;
    }


    public String getPalindrome(String str, int start, int end) {
        int low = start;

        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            low = start;
            start--;
            end++;
        }
        return str.substring(low, end);
    }

    public String longestPalSubstr(String str){
        if(str == null || str.length() ==0 ){
            return "";
        }
        String maxStr = "";

        String cur;
        for(int i = 0; i <str.length(); i++) {
            String s = getPalindrome(str, i,i);
            String s2 = "";
            if(i+1 < str.length()) {
                s2 = getPalindrome(str, i, i+1);
            }
            cur = s.length() > s2.length() ? s: s2;
            maxStr = cur.length() > maxStr.length() ? cur : maxStr;
        }
        return maxStr;
    }




    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome("ababc"));
        System.out.println(s.longestLengthPalindrome("ababc"));

        System.out.println(s.longestPalindrome("aaabba"));
        System.out.println(s.longestLengthPalindrome("aaabba"));

        System.out.println(s.longestPalindrome("abc"));
        System.out.println(s.longestLengthPalindrome("abc"));

        System.out.println(s.longestPalSubstr("AABBCC"));
        System.out.println(s.longestPalSubstr("cabac"));

        char[] c = {'a','b','c'};
        String ss = new String(c);
        System.out.println(ss);
    }
}
