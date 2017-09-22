package LeetCode;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by Anonealio on 9/19/2017.
 */
public class Solution409 {

    public Hashtable<Character, Integer> createCharCountTable(String str) {

        Hashtable<Character, Integer> table = new Hashtable<>();
        for (char ch : str.toCharArray()) {
            if (table.get(ch) != null) {
                table.replace(ch, table.get(ch) + 1);
            } else {
                table.put(ch, 1);
            }
        }
        return table;
    }

    public String createLongestPalindrome(Hashtable<Character, Integer> table) {
        Iterator<Character> iter = table.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        char midChar;

        while (iter.hasNext()) {
            char ch = iter.next();
            int count = table.get(ch) / 2;

            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                }

                if (table.get(ch) % 2 == 0) {
                    iter.remove();
                }
            }
        }
        String reverse = sb.reverse().toString();

        Iterator<Character> iter2 = table.keySet().iterator();
        if (iter2.hasNext()) {
            midChar = iter2.next();
            sb.append(midChar);
        }
        sb.append(reverse);
        return sb.toString();
    }

    public int longestPalindrome(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Hashtable<Character, Integer> table = createCharCountTable(s);
        String result = createLongestPalindrome(table);
        return result.length();

    }
}