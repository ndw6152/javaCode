package LeetCode;

/**
 * Created by Anonealio on 8/23/2017.
 */
class Solution {

    int getMultiplier(int val) {
        long multiplier = 1;
        while(val >= multiplier) {
            multiplier *= 10;
        }
        return Math.toIntExact(multiplier/10);
    }

    public long getReverse(int x) {
        long result = 0;
        int divisor = getMultiplier(x);
        long mult = 1;
        while(x >= 1) {
            int current = x/divisor;
            result += current * mult;
            x = x%divisor;
            mult *= 10;
            divisor /= 10;

        }
        return result;
    }

    public int reverse(int x) {


        long result = 0;
        if(x > 0) {

            result = getReverse(x);
            if(result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        else {
            x *= -1;
            result = getReverse(x);
            result *= -1;
            if(result < Integer.MIN_VALUE){
                return 0;
            }
        }
        return Math.toIntExact(result);

    }
}

class Solution7 {
    public long getReverse(int x) {
        long result = 0;
        while(x > 0) {
            int current = x%10;
            result = result*10 + current;
            x = x/10;
        }
        return result;
    }

    public int reverse(int x) {
        long result = 0;

        if(x == 0) {
            return x;
        }
        else if(x > 0) {
            result = getReverse(x);
            if(result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        else {
            x *= -1;
            result = getReverse(x);
            result *= -1;
            if(result < Integer.MIN_VALUE){
                return 0;
            }
        }
        return Math.toIntExact(result);
    }

    public boolean checkPalindromeInt(int val) {
        return val == reverse(val);
    }


    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.reverse(12345));
        System.out.println(s.reverse(1534236469)); // overflow

        System.out.println(s.checkPalindromeInt(12345));
        System.out.println(s.checkPalindromeInt(123454321));
        System.out.println(s.checkPalindromeInt(1221));

        System.out.println(s.checkPalindromeInt(32123));
    }
}