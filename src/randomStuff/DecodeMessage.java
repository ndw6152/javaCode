package randomStuff;

/**
 * Created by ndw6152 on 7/22/2018.
 */
public class DecodeMessage {

    class Nodee {
        int val;
        public Nodee(int x) {
            this.val = x;
        }
    }

    public int numWaysToDecode(String str, int[] memo) {


        Nodee x = new Nodee(10);
        if(str.length() == 0) {
            return 1;
        }
        if(str.charAt(0) == '0') {
            return 0;
        }
        if(str.length() == 1) {
            return 1;
        }

        if(memo[str.length()] != 0) {
            return memo[str.length()];
        }

        int result = numWaysToDecode(str.substring(1), memo);

        String firstTwo = str.substring(0,2);
        if(Integer.parseInt(firstTwo) >= 10 && Integer.parseInt(firstTwo) <= 26) {
            result += numWaysToDecode(str.substring(2), memo);
        }

        memo[str.length()] = result;
        return result;
    }


    public int numWaysToDecode(String str) {
        int[] dp = new int[str.length()+1];

        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= str.length(); i++) {
            int oneElem = Integer.parseInt(str.substring(i-1, i));
            int twoDigits = Integer.parseInt(str.substring(i-2, i));

            if(oneElem >0 && oneElem <= 9) {
                dp[i] += dp[i-1];
            }
            if(twoDigits >=10 && twoDigits <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[str.length()];
    }




    public static void main(String[] args) {
        DecodeMessage sol = new DecodeMessage();

        System.out.println(sol.numWaysToDecode("1212", new int[5]));

        System.out.println(sol.numWaysToDecode("1212"));


    }

}
