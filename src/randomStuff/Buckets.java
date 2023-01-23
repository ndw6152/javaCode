package randomStuff;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by ndw6152 on 7/12/2018.
 */
public class Buckets {
    public String convert(String a, int val) {
        if(a.length() == 0 || val < 1) {
            return "";
        }
        if(val == 1) {
            return a;
        }

        SortedMap<Integer, ArrayList<String>> map = new TreeMap<>();

        for(int i = 0; i< val; i++) {
            map.put(i, new ArrayList<>());
        }

        int dir = 1;
        int index = 0;
        for(int i = 0 ; i< a.length(); i++) {
            index += dir;

            if(index == val) {
                index -= 2;
                dir = -1;
            }
            else if(index == -1) {
                index = 0;
                dir = 1;
            }
            ArrayList<String> cur = map.get(index);
            cur.add(a.charAt(i) +"");
            map.put(index, cur);
        }

        StringBuilder sb = new StringBuilder();

        for(Integer key : map.keySet()) {
            ArrayList<String> current = map.get(key);
            for(String s: current) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Buckets sol = new Buckets();

        //System.out.println(sol.convert("ABCDE", 3));
        System.out.println(sol.convert("PAYPALISHIRING", 3));

    }
}
