package LeetCode;

/**
 * Created by Anonealio on 8/31/2017.
 */
class Solution214b {

    int maxSize = 0;
    int leftIndex = -1;
    int rightIndex = -1;


    public String shortestPalindrome2(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + (s.substring(0, j)) + suffix;
    }

    public boolean checkIfPalindrome(String str, int right) {
        int left = 0;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void findIfSubstringPalindrome(String str) {
        char leftChar = str.charAt(0);
        int rightIndex = str.length() -1;

        while(rightIndex >= 0) {
            if(str.charAt(rightIndex) == leftChar) {
                if(checkIfPalindrome(str, rightIndex)) {
                    this.rightIndex = rightIndex;
                    return;
                }
            }
            rightIndex--;
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
            findIfSubstringPalindrome(s);

            if(rightIndex == s.length()-1){
                return s;
            }
            else if(rightIndex != -1) {
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



    public static void main(String[] args) {
        Solution214b s = new Solution214b();
        System.out.println(s.shortestPalindrome2("aXcFa"));
    }
}
