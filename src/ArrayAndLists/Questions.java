package ArrayAndLists;

import java.util.Hashtable;

/**
 * Created by Anonealio on 6/26/2017.
 */
public class Questions {

    // 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    // cannot use additional data structures?
    public boolean isUnique(String str) {
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

    public boolean isUniqueWithHashTable(String str) {
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

    public static void main(String[] args) {

        Questions q = new Questions();
        System.out.println(q.isUniqueWithHashTable("abc"));
        System.out.println(q.isUniqueWithHashTable("abc1234"));
        System.out.println(q.isUniqueWithHashTable("aaaaaaa"));
        System.out.println(q.isUniqueWithHashTable("abbbbcc"));
        System.out.println(q.isUniqueWithHashTable(""));
        System.out.println(q.isUniqueWithHashTable("\"av\\-12"));
        System.out.println(q.isUniqueWithHashTable("\"av\\\\12"));

    }
}
