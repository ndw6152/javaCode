package randomStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Anonealio on 6/22/2017.
 */
public class Question3 {

    // give the starting index of all possible permutation of a smaller string s in a bigger string b
    public ArrayList<Integer> findIndices(String s, String b) {

        int window = s.length();
        char[] ch1 = s.toCharArray();
        Arrays.sort(ch1);
        String sortedS = Arrays.toString(ch1);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i+window <= b.length(); i++) {
            String elements = b.substring(i, i+window);
            // int index = verifyStrings2(sortedS, elements, i);
            int index = verifyStrings2(s, elements, i);
            if(index >= 0) {
                result.add(index);
            }
        }
        return result;

    }

    public int verifyStrings(String sortedS, String s2, int index) {

        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);

        if (sortedS.equals(Arrays.toString(ch2)) ) {
            return index;
        }
        else {
            return -1;
        }
    }


    public Hashtable<Character, Integer> populateMap(String s) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        for(int i=0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(table.containsKey(cur)){
                int count = table.get(cur);
                table.put(s.charAt(i), ++count);
            }
            else{
                table.put(s.charAt(i), 1);
            }
        }
        return table;
    }
    public int verifyStrings2(String s1, String s2, int index) {
        Hashtable<Character, Integer> table1 = populateMap(s1);
        Hashtable<Character, Integer> table2 = populateMap(s2);

        if(table1.keySet().size() == table2.keySet().size()) {
            for(Character ch : table1.keySet()) {
                if(!table1.get(ch).equals(table2.get(ch))) {
                    return -1;
                }
            }
        }
        else{
            return -1;
        }

        return index;
    }

    public static void main(String[] args) {

        Question3 q = new Question3();
        ArrayList<Integer> arr = q.findIndices("cabb", "afgcbabcbaghjjbcab");

        System.out.println(arr);
    }

}
