package ArrayAndLists;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Anonealio on 6/26/2017.
 */
public class Questions {

    // 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    // cannot use additional data structures?
    public boolean isUnique(String str) { // O(n) space O(n)
        System.out.print(str + " = ");
        if(str.length() == 0) {
            return false;
        }
        int[] results = new int[256];
        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(results[(int)ch] == 0) {
                results[(int)ch] = 1;
            }
            else {
                return false;
            }
        }
        return true;

//        Questions q = new Questions();
//        System.out.println(q.isUnique("abc"));
//        System.out.println(q.isUnique("abc1234"));
//        System.out.println(q.isUnique("aaaaaaa"));
//        System.out.println(q.isUnique("abbbbcc"));
//        System.out.println(q.isUnique(""));
//        System.out.println(q.isUnique("\"av\\-12"));
//        System.out.println(q.isUnique("\"av\\\\12"));
    }

    public boolean isUniqueWithHashTable(String str) { // O(n) space O(n)
        System.out.print(str + " = ");
        if(str.length() == 0) {
            return false;
        }
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(!table.containsKey((int)ch)){
                table.put((int)ch, 1);
            }
			else {
                return false;
            }
        }
        return true;
    }


    public String sortString(String str) {
        char[] ch2 = str.toCharArray();
        Arrays.sort(ch2);
        return ch2.toString();
    }

    public boolean isUniqueNoDS(String str) {
        System.out.print(str + " = ");
        String sortStr = sortString(str);

        for(int i = 1; i<sortStr.length(); i++) {
            if((sortStr.charAt(i)) == (sortStr.charAt(i-1))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        Questions q = new Questions();
        System.out.println(q.isUniqueNoDS("abc"));
        System.out.println(q.isUniqueNoDS("abc1234"));
        System.out.println(q.isUniqueNoDS("aaaaaaa"));
        System.out.println(q.isUniqueNoDS("abbbbcc"));
        System.out.println(q.isUniqueNoDS(""));
        System.out.println(q.isUniqueNoDS("\"av\\-12"));
        System.out.println(q.isUniqueNoDS("\"av\\\\12"));

    }
}
