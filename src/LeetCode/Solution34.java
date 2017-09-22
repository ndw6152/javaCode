package LeetCode;

/**
 * Created by Anonealio on 9/14/2017.
 */
public class Solution34 {
    public int firstEqualTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int pivotIndex;
        int pivot;
        while(low < high) {
            pivotIndex = (low + high)/2;
            pivot = nums[pivotIndex];

            if(pivot < target) {

                low = pivotIndex + 1;
            }
            else {
                high = pivotIndex;
            }
            System.out.println(low + "  "+ high + ". pivotVal = " + pivot + " " + pivotIndex);
        }
        return low;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstEqualTarget(nums, target);
        if(first >= nums.length || nums[first] != target) {
            int[] result = {-1, -1};
            return result;
        }
        System.out.println(first);
        int last = firstEqualTarget(nums, target+1);
        if(last == 0 && nums[last] == target) {
            int[] result = {first, last};
            return result;
        }
        if(nums[last] != target) {
            int[] result = {first, last-1};
            return result;
        }
        int[] result = {first, last};
        return result;
    }

    public static void main(String[] args) {
        Solution34 s = new Solution34();
        int[] arr = {0,1,2,4,5,5,8};
        int[] res = (s.searchRange(arr, 5));
        System.out.println("result = " + res[0] + "  " + res[1]);
    }

}
