package randomStuff;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by ndw6152 on 6/26/2018.
 */
public class LargestNumber {

    public String findLargest(List<Integer> arr) {
        if(arr.size() == 0) {
            return "";
        }

        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String str1 = a + "" + b;
                String str2 = b + "" + a;
                Long val1 = Long.parseLong(str1);
                Long val2 = Long.parseLong(str2);

                if (val1 < val2) {  // sorting in descending order
                    return 1;
                } else if (val1.equals(val2)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        LargestNumber sol = new LargestNumber();
        List<Integer> arr = new ArrayList<>();
        arr.add(30);arr.add(9);arr.add(3);
        sol.findLargest(arr);
    }
}
