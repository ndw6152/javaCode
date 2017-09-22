package LeetCode;

/**
 * Created by Anonealio on 8/24/2017.
 */
import java.util.HashSet;

class Solution9 {

    // compare to see if an integer is a palindrome
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        if (x < 10) {
            return true;
        }
        int result = 0;
        int original = x;
        while (x > 0) { // start from right and make new reverse digit, then compare with original, note remember to save original.
            int right = x%10;
            result = result*10 + right;
            x /= 10;
        }
        return result == original;
    }
}
