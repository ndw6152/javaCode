package ArrayAndLists;

import java.util.Hashtable;

/**
 * Created by Anonealio on 6/27/2017.
 */
public class Question1_4 {

    public Hashtable<Character, Integer> generateTable(String str) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        str = str.toLowerCase();

        for(int i =0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ' ') {
                continue;
            }
            if(table.get(ch) == null) {
                table.put(ch, 1);
            }
            else{
                int val = table.get(ch) + 1;
                table.put(ch, val);
            }
        }

        return table;
    }


    public boolean checkIfPermutationPalindrome(String str) {
        // O(s + u) s = size of string, u = size of unique char
        // space = O(u)

        Hashtable<Character, Integer> table = generateTable(str);

        int oneOdd = 0;
        boolean flag;
        for(char ch : table.keySet()) {
            if(table.get(ch)%2 == 1) {
                oneOdd++;
            }
        }
        if(oneOdd <= 1) {
            flag = true;
        }
        else {
            flag = false;
        }
        if(str.length() == 0) {
            flag = false;
        }
        System.out.println(flag);
        return flag;
    }

    public static void main(String[] args) {
        Question1_4 q = new Question1_4();

        q.checkIfPermutationPalindrome("Tact Coa");
        q.checkIfPermutationPalindrome("tacocat");
        q.checkIfPermutationPalindrome("ra1ce1car");
        q.checkIfPermutationPalindrome("atco ctarabbar");
        q.checkIfPermutationPalindrome("rRraaCC");
        q.checkIfPermutationPalindrome("1");
        q.checkIfPermutationPalindrome("11");
        System.out.println("--- ");
        q.checkIfPermutationPalindrome("rrraacc2");
        q.checkIfPermutationPalindrome("rrraacc23");
        q.checkIfPermutationPalindrome("rrraaaccc");
        q.checkIfPermutationPalindrome("1235");
        q.checkIfPermutationPalindrome("");
    }
}