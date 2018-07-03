package ArrayAndLists;

import randomStuff.Question3;

import java.util.Hashtable;

/**
 * Created by Anonealio on 6/26/2017.
 */
public class Question1_2 {

    // Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
    public Hashtable<Character, Integer> generateCountTable(String str) {
        Hashtable<Character, Integer> table = new Hashtable<>();

        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(table.get(ch) == null) {
                table.put(ch, 1);
            }
            else{
                int val = table.get(ch);
                table.put(ch, ++val);
            }
        }
        return table;
    }

    public boolean isPermutation(String str, String str2) {  // O(m+n+h1) space = O(h1 + h2)
        if(str.length() != str2.length()) {
            return false;
        }
        Hashtable<Character, Integer> table = generateCountTable(str);
        Hashtable<Character, Integer> table2 = generateCountTable(str2);


        for(char key : table.keySet()) {

            if(!table2.containsKey(key)) {
                return false;
            }
            if(!table.get(key).equals(table2.get(key))) { // checking if count of each characters is same in both strings
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Question1_2 q = new Question1_2();
        System.out.println( q.isPermutation("false", "") );
        System.out.println( q.isPermutation("abc", "abc") );
        System.out.println( q.isPermutation("cva", "abc") );
        System.out.println( q.isPermutation("cba", "abc") );
        System.out.println( q.isPermutation("14235", "12345") );
        System.out.println( q.isPermutation("", "") );

    }
}
