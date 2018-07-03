package randomStuff;

import LeetCode.Solution46;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Anonealio on 8/3/2017.
 */
public class Question4 {

    // method create all possible correct combinations of parenthese
    public Hashtable<String, Integer> createParentheses(int n) {
        Hashtable<String, Integer> table = new Hashtable<>();
        if( n == 1) {
            table.put("()", 1);
            return table;
        }
        n = n-1;
        Hashtable<String, Integer> table2 = createParentheses(n);
        for( String str: table2.keySet() ) {
            table.put("(" + str + ")", 1);
            table.put( str + "()", 1);
            table.put("()" +str, 1);
        }
        return table;
    }

    public void printTable(Hashtable<String, Integer> table) {
        for(String str: table.keySet()) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Question4 q = new Question4();
        Hashtable<String, Integer> table = q.createParentheses(2);
        q.printTable(table);
    }




}
