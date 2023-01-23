package randomStuff;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ndw6152 on 8/7/2018.
 */
public class MadeOf {
    HashSet<String> dict;

    public MadeOf() {
        dict = new HashSet<>();
        dict.add("app");
        dict.add("apple");
        dict.add("pine");
        dict.add("word");
        dict.add("pin");
    }

    // function returns true if the word is made of valid words from the dict
    public boolean isMadeOfWords(String word) {
        if(word.length() ==0 ) {
            return false;
        }

        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;

        for(int i = 1; i <= word.length(); i++) {
            String part = word.substring(0, i);
            if(dict.contains(part)) {
                dp[i] = true;
            }
            else {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && dict.contains(part.substring(j))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

        }
        return dp[word.length()];
    }


//    class Solution {
//        public int rotatedDigits(int N) {
//            if (N <= 0) {
//                return 0;
//            }
//            int[] dp = new int[N + 1];  // dp state
//            int count = 0;
//            for (int i = 0; i <= N; i++) {
//                if (i < 10) {
//                    if (i == 1 || i == 8 || i == 0) {
//                        dp[i] = 1;
//                    } else if (i == 2 || i == 5 || i == 6 || i == 9) {
//                        dp[i] = 2;
//                        count++;
//                    }
//                } else {
//                    int a = i / 10;
//                    int b = i % 10;
//                    if (dp[a] == 1 && dp[b] == 1) {
//                        dp[i] = 1;
//                    } else if (dp[a] >= 1 && dp[b] >= 1) {
//                        dp[i] = 2;
//                        count++;
//                    }
//                }
//            }
//            return count;
//        }
//
//    }
//public boolean wordBreak(String s,List<String> wordDict){
//        int n=s.length();
//        HashSet<String> map=new HashSet(wordDict);
//        boolean[] dp=new boolean[n+1];
//        dp[n]=true;
//        int min=Integer.MAX_VALUE;
//        int max=Integer.MIN_VALUE;
//        for(String word:map){
//            int len=word.length();
//            min=Math.min(len,min);
//            max=Math.max(len,max);
//        }
//        for(int i=n-min;i>=0;i--){
//            for(int j=i+min;j<=n&&j<=i+max;j++){
//                if(dp[j]&&map.contains(s.substring(i,j))) dp[i]=true;
//            }
//        }
//        return dp[0];
//    }

    public boolean wordBreakOptimized(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

    // not efficient
    public boolean wordBreak(String str)
    {
        int size = str.length();

        // Base case
        if (size == 0)  return true;

        // Try all prefixes of lengths from 1 to size
        for (int i=1; i<=size; i++)
        {
            // The parameter for dictionaryContains is
            // str.substr(0, i) which is prefix (of input
            // string) of length 'i'. We first check whether
            // current prefix is in  dictionary. Then we
            // recursively check for remaining string
            // str.substr(i, size-i) which is suffix of
            // length size-i
            if (dict.contains( str.substring(0, i) ) &&
                    wordBreak( str.substring(i) ))
                return true;
        }

        // If we have tried all prefixes and
        // none of them worked
        return false;
    }



    public static void main(String[] args) {
        MadeOf sol = new MadeOf();

        System.out.println(sol.isMadeOfWords("hello"));

        System.out.println(sol.isMadeOfWords("app"));
        System.out.println(sol.isMadeOfWords("apple"));
        System.out.println(sol.isMadeOfWords("pine"));
        System.out.println(sol.isMadeOfWords("applepine"));
        System.out.println(sol.isMadeOfWords("applepin"));

        ///
        System.out.println(sol.wordBreak("water"));
        System.out.println(sol.wordBreak("waterapple"));
        System.out.println(sol.wordBreak("applepine"));



    }
}
