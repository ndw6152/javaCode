package randomStuff;

import java.util.*;

/**
 * Created by ndw6152 on 7/17/2018.
 */
public class Similar {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length == 0 || list2.length ==0 ) {
            return new String[1];
        }


        Hashtable<String, Integer> table = new Hashtable<>();
        for(int i = 0; i < list2.length; i++) {
            table.put(list2[i], i);
        }

        Hashtable<String, Integer> similar = new Hashtable<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < list1.length; i++) {
            String str = list1[i];
            if(table.containsKey(str)) {
                int sum = table.get(str) + i;
                similar.put(str, sum);
            }
        }
        int curMin = Integer.MAX_VALUE;
        for(String ss : similar.keySet()) {
            int val = similar.get(ss);

            if(val == curMin) {
                result.add(ss);
            }
            else if(val < curMin) {
                result = new ArrayList<>();
                result.add(ss);
            }
        }
        return result.toArray(new String[0]);
    }

    public void test() {
        int[][] arr = {{10,2},{1,2}, {6,3}, {3,10}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        System.out.println();
    }



    public static void main(String[] args) {
        Similar sol = new Similar();
        String[] str1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] str2= {"KFC","Burger King","Tapioca Express","Shogun"};
        sol.findRestaurant(str1, str2);

        sol.test();
    }

}
