package randomStuff;

import java.util.*;

/**
 * Created by ndw6152 on 7/1/2018.
 */
public class MsftSolution {

    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {  // -1 if o1 is < o2
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        MsftSolution sol = new MsftSolution();

        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        System.out.println(sb.toString());
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        char[] arr = {'a','a'};
        for(char ch: arr) {
            System.out.println(ch);
        }
    }
}
