package randomStuff;

import java.util.Hashtable;

/**
 * Created by ndw6152 on 7/1/2018.
 */
public class LongestSubString {

    public static int longestNRSubstringLen(String input) {
        int maxCount = 0;
        Hashtable<Character, Integer> table = new Hashtable<>();

        if(input.length() == 0) {
            return maxCount;
        }
        int count = 0;

        char[] arr = input.toCharArray();
        char ch;
        int minIndex = 0;

        for(int i =0; i < arr.length; i++) {
            ch = arr[i];

            if(table.containsKey(ch)) {
                int prevIndex = table.get(ch);
                if(prevIndex < minIndex) {

                }
                else {

                }
                count = i - (prevIndex+1);
            }
            table.put(ch, i);
            count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        System.out.println(longestNRSubstringLen("acvevfghic"));

    }
}
