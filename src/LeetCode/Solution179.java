package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Anonealio on 9/23/2017.
 * Code to showcase the use of comparators in Arrays.sort
 */
public class Solution179 {

    public void printStringArray(Object[] strs) {
        for(Object str: strs) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public String largestNumber(int[] nums) {

        if(nums.length <1) {
            return "";
        }

        String[] strs = new String[nums.length];
        for(int i = 0; i <nums.length; i++) {
            strs[i] = nums[i] + "";
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            sb.insert(0, str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution179 s = new Solution179();

        System.out.println("345".compareTo("344"));

        String[] strs2 = {"334", "371", "388"};
        Arrays.sort(strs2, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i.charAt(i.length()-1) +"";
                String s2 = j.charAt(j.length()-1) +"";
                return i.compareTo(j);//s1.compareTo(s2);
            }
        });
        s.printStringArray(strs2);

        Integer[] strs3 = {100, 103, 101, 151};
        Arrays.sort(strs3, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 < o2? -1: 1;
                    }
                }
        );
        s.printStringArray(strs3);


        System.out.println("------------- largest numbers ");
        int[] arr = {30, 3, 34, 5, 9};
        System.out.println(s.largestNumber(arr));
        int[] arr2 = {};
        System.out.println(s.largestNumber(arr2));
        int[] arr3 = {304, 33};
        System.out.println(s.largestNumber(arr3));
        int[] arr4 = {1, 4, 11,13,103,102};
        System.out.println(s.largestNumber(arr4));
        System.out.println("------------- largest numbers ");
        System.out.println("1".compareTo("102"));
        System.out.println("1".compareTo("103"));
        System.out.println("1".compareTo("11"));

        System.out.println("11".compareTo("102"));
        System.out.println("11".compareTo("103"));
    }
}
