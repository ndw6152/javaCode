package randomStuff;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by ndw6152 on 6/28/2018.
 */
public class RecoverIP {

    public static void backTrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, String str, int start) {
        if(current.size() == 4) {
            if(start == str.length()) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(i+start > str.length()) {
                return;
            }
            int val = Integer.parseInt(str.substring(start, start +i));
            if(val >=0 && val <= 255) {
                if(val < 10 && i > 1) return; // take care of cases where it is 001, 01 etc
                current.add(val);
                backTrack(result, current, str, start+i);
                current.remove(current.size()-1);
            }
            else {
                return;
            }
        }

    }



    public static String generateIPAddrs(String str) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), str, 0);

        return null;
    }

    public static void main(String[] args) {
        String str = "1234";

        System.out.println(generateIPAddrs("12345"));
        System.out.println(generateIPAddrs("25525511135"));

    }
}
