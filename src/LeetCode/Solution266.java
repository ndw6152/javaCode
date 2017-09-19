package LeetCode;

import java.util.*;

/**
 * Created by Anonealio on 9/16/2017.
 * Print all palindrome permutations of a string
 *
 */
public class Solution266 {

/*
 * verify can make a palindrome from the string chars.
 * if can make palindrome then, create a String from half of the chars in the hashmap; for each char take half the count
 * leave the odd character still there
 * then create all possible permutations of the half string (use hashset to avoid duplicates causing repeated permutations)
 * if an odd one available, add it in the middle
 * then add the other half in reverse in this case using a stringBuilder.toString().reverse();
 */
    Hashtable<Character, Integer> charTable;

    public boolean cameMakePalindrome(String str) {
        charTable = new Hashtable<>();
        int oddChars = 0;

        int value;
        for(int i = 0; i <str.length(); i++) {
            char ch = str.charAt(i);
            if(charTable.get(ch) == null) {
                charTable.put(ch, 1);
            }
            else {
                value = charTable.get(ch) + 1;
                charTable.put(ch, value);
            }
        }

        // looping again to verify that there is only one odd characters
        for(char ch : charTable.keySet()) {
            if(charTable.get(ch) %2 == 1) {
                oddChars++;
            }
        }

        return oddChars < 2;
    }

    public String createHalfStringFromHashtable() {
        int count;
        int numCharsToAdd;
        StringBuilder sb = new StringBuilder();

        Iterator<Character> iter = charTable.keySet().iterator();
        char current;
        while(iter.hasNext()) {
            current = iter.next();
            count = charTable.get(current);
            if(count >1) {
                numCharsToAdd = count/2;
                for(int i =0; i<numCharsToAdd; i++) {
                    sb.append(current);
                }
                if(count %2 ==0)
                    iter.remove();
            }
        }

        return sb.toString();
    }


    public void backTrack(HashSet<String> allSolutions, StringBuilder solution, String str, boolean[] visited) {

        if(solution.length() == str.length()) {
            allSolutions.add(solution.toString());
            return;
        }
        for(int i =0; i <str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution.append(str.charAt(i));
                backTrack(allSolutions, solution, str, visited);
                visited[i] = false;
                solution.deleteCharAt(solution.length()-1);
            }
        }
    }

    public HashSet<String> permute(String str) {
        HashSet<String> result = new HashSet<>();
        boolean[] visited = new boolean[str.length()];
        backTrack(result, new StringBuilder(), str, visited);


        return result;
    }




    public List<String> permutationPalindrome(String str) {
        if(!cameMakePalindrome(str)) {
            return new ArrayList<>();
        }
        else {
            String half = createHalfStringFromHashtable();
            List<String> result = new ArrayList<>();
            HashSet<String> possibleStrTable = permute(half);
            Iterator<Character> iter = charTable.keySet().iterator();
            char oddCharacter = '-';
            if(charTable.size() != 0) {
                oddCharacter = iter.next();
            }
            for(String comboHalf : possibleStrTable) {
                if(charTable.size() != 0) { // have an odd character in the string;
                    result.add(comboHalf + oddCharacter + new StringBuilder(comboHalf).reverse());
                }
                else {
                    result.add(comboHalf + new StringBuilder(comboHalf).reverse());
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        Solution266 s = new Solution266();
        System.out.println( s.cameMakePalindrome("abc") );

        System.out.println( s.cameMakePalindrome("aaaab") );
        System.out.println(s.createHalfStringFromHashtable());

        if(s.cameMakePalindrome("aabbccccd")) {
            System.out.println(s.createHalfStringFromHashtable());
        }

        System.out.println("--------- AABBC -----");
        System.out.println(s.permutationPalindrome("AABBC"));
        System.out.println("--------- AABB ----");
        System.out.println(s.permutationPalindrome("AABB"));

        System.out.println("--------------");

        System.out.println(s.permutationPalindrome("aabbcadad"));

        System.out.println("---------- ABC ----");
        System.out.println(s.permutationPalindrome("ABC"));
        System.out.println("---------- ABCA ----");
        System.out.println(s.permutationPalindrome("ABCA"));
        System.out.println("---------- 1231234 ----");
        System.out.println(s.permutationPalindrome("1231234"));
    }
}
