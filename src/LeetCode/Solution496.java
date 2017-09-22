package LeetCode;

import java.util.Hashtable;
        import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int i=0; i< nums2.length; i++) {
            int val = nums2[i];
            int greater = -1;
            for(int j =i+1; j<nums2.length; j++) {
                if(nums2[j] > val){
                    greater = nums2[j];
                    break;
                }
            }
            table.put(val, greater);
        }

        int[] result = new int[nums1.length];
        for(int x =0; x < nums1.length; x++) {
            result[x] = table.get(nums1[x]);
        }
        return result;
    }

}