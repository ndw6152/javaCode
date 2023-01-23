package randomStuff;

/**
 * Created by ndw6152 on 7/12/2018.
 */
public class MaxPal {


    // only returns the length of the palindrome if the first char of substring is 0
    // i.e if is it a palindrome that starts from 0, then we just need to add the chars that are left over
    // if it is a palindrome that is after index 0, it does not matter, we still need to insert everything
    public int maxPalFromStart(String str, int start, int end) {
        while(str.charAt(start) == str.charAt(end)) {

            if(start == 0 || end == str.length()-1) {
                break;
            }
            start--;
            end++;
        }
        if(start == 0) {
            if(str.charAt(start) == str.charAt(end)) {
                return end - start +1;
            }
        }
        return -1;
    }

    // function finds the minimum # of chars that needs to be inserted at the start to make a valid palindrome
    public int minAdditionalCharsToMakePal(String str) {
        if(str == null || str.length() ==0) {
            return 0;
        }

        int max = 0;
        int first = maxPalFromStart(str, 0,0);
        max = Math.max(first, max);

        for(int i =1; i < str.length(); i++) {
            int val = Math.max(maxPalFromStart(str, i,i), maxPalFromStart(str, i-1,i));
            max = Math.max(val, max);
        }

        return str.length() - max;
    }


    // function start from start and end index and expand left and right to see if the additional
    // characters still form a valid substring palindrom
    public String maxSubPal(String str, int start, int end) {
        while(str.charAt(start) == str.charAt(end)) {
            if(start == 0 || end == str.length()-1) {
                return str.substring(start, end+1);
            }
            start--;
            end++;
        }

        return str.substring(start+1, end);
    }

    // function finds the max substring palindrome in the string
    public String longestPalindrome(String str) {
        if(str == null || str.length() ==0) {
            return "";
        }
        String result = "";
        int max = 0;
        String first = maxSubPal(str, 0, 0);
        if(first.length() > max) {
            max = first.length();
            result = first;
        }

        for(int i = 1; i < str.length(); i++) {
            String s1 = maxSubPal(str, i-1, i);
            String s2 = maxSubPal(str, i, i);

            if(s2.length() > s1.length()) {
                if(s2.length() > max) {
                    max = s2.length();
                    result = s2;
                }
            }
            else {
                if(s1.length() > max) {
                    max = s1.length();
                    result = s1;
                }
            }
        }
        return result;
    }

    public static String reverseWords(String a) {
        String[] words = a.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i].trim());

            if(i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }


    public static boolean isPalindromeInt(int val) {
        int cur = val;
        long data = 0;

        while(cur !=0 ) {
            int lsb = cur %10;
            data = data*10 + lsb;
            cur  /= 10;
        }

        while(val != 0) {
            int lval = val %10;
            int ldata = (int) data %10;
            if(lval != ldata) {
                return false;
            }

            val /= 10;
            data /= 10;
        }


        return true;
    }


    public static void main(String[] args) {
        MaxPal sol = new MaxPal();
        System.out.println("Should be 0 already palindrome: " + sol.minAdditionalCharsToMakePal("aaaaa"));
        System.out.println("Should be 6: " + sol.minAdditionalCharsToMakePal("aaceaaaa"));
        System.out.println("Should be 5: " + sol.minAdditionalCharsToMakePal("eabcba"));

        System.out.println(sol.longestPalindrome("abac"));
        System.out.println(sol.longestPalindrome("cabac"));
        System.out.println(sol.longestPalindrome("caac"));
        System.out.println(sol.longestPalindrome("aabcc"));

        String str  = "           abc   ab   c ab      ";
        str = str.replaceAll("\\s+", " ");
        String[] a = str.split(" ");
        for(String s : a) {
            System.out.println(s);
        }

        System.out.println(reverseWords(str));


        System.out.println(isPalindromeInt(101));
        System.out.println(isPalindromeInt(123));


    }
}
