package ArrayAndLists;

import java.util.Hashtable;

/**
 * Created by Anonealio on 7/4/2017.
 *
 */
public class Question1_5 {

    public Hashtable<Character, Integer> createTable(String str) {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();

        for(int i =0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(table.get(ch) != null) {
                int val = table.get(ch) + 1;
                table.put(ch, val);
            }
            else {
                table.put(ch, 1);
            }
        }
        return table;
    }


    public boolean compareTable(Hashtable<Character, Integer> table1, Hashtable<Character, Integer> table2) {
        int replaced = 0;
        for(Character ch : table2.keySet()) {
            int count2 = table2.get(ch);
            if(table1.get(ch) != null) {
                int count1 = table1.get(ch);
                if(count1 != count2) {
                    replaced++;
                }
            }
            else {
                replaced++;
                if(count2 > 1) {
                    return false;
                }
                if(replaced > 1) {
                    return false;

                }
            }
        }
        return true;
    }

    public boolean compareTables(Hashtable<Character, Integer> table1, Hashtable<Character, Integer> table2) {
        if(table1.size() < table2.size()){
            return compareTable(table1, table2);
        }
	    else {
            return compareTable(table2, table1);
        }

    }


    public boolean checkOneAway(String str, String str2) {

        int size1 = str.length();
        int size2 = str2.length();

        int diff = size1 - size2;

        if(diff == 0 || diff == 1 || diff == -1) {
            Hashtable<Character, Integer> table1 = createTable(str);
            Hashtable<Character, Integer> table2 = createTable(str2);

            return compareTables(table1, table2);
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        Question1_5 q = new Question1_5();

        System.out.println(q.checkOneAway("pale", "ple"));
        System.out.println(q.checkOneAway("pale", "pale"));
        System.out.println(q.checkOneAway("pale", "pales"));
        System.out.println(q.checkOneAway("", ""));
        System.out.println(q.checkOneAway("", "a"));
        System.out.println(q.checkOneAway("ab", "a"));
        System.out.println(q.checkOneAway("apple", "aple"));
        System.out.println("-----");
        System.out.println(q.checkOneAway("pale", "ble"));
        System.out.println(q.checkOneAway("pale", "bl"));
        System.out.println(q.checkOneAway("pale", "bake"));
        System.out.println(q.checkOneAway("what", ""));
        System.out.println(q.checkOneAway("aaaa", "bbbb"));
        System.out.println(q.checkOneAway("aaaacc", "bbbbdd"));
    }
}
