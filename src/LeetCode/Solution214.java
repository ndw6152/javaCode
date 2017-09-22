package LeetCode;

/**
 * Created by Anonealio on 8/31/2017.
 */
class Solution214 {

    int maxSize = 0;
    int leftIndex = -1;
    int rightIndex = -1;


    public void findLongestSubstringPalindrome(String str, int left, int right) {

        while(left >= 0 && right <= str.length()-1 && str.charAt(left) == str.charAt(right)) {
            if(left == 0) {
                int size = right - left +1;
                if(size > maxSize) {
                    maxSize = size;
                    leftIndex = left;
                    rightIndex = right;
                }
            }
            left--;
            right++;
        }
    }

    public String genWorstCasePalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        // loop through all chars after the first one
        for(int i =1; i < str.length(); i++) {
            sb.insert(0, str.charAt(i));
        }
        return sb.toString();
    }

    public String shortestPalindrome(String s) {
        if(s.length() <2) {
            return s;
        }

        else {
            for(int j = 0; j <=s.length()/2; j++) {
                findLongestSubstringPalindrome(s, j, j);
                findLongestSubstringPalindrome(s, j, j+1);
            }

            if(rightIndex == s.length()-1){
                return s;
            }
            else if(leftIndex != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, s.length()));
                // loop through all chars after the first one
                for(int i = rightIndex+1; i < s.length(); i++) {
                    sb.insert(0, s.charAt(i));
                }
                return sb.toString();
            }
            else {
                String result = genWorstCasePalindrome(s);
                return result;
            }
        }
    }
}