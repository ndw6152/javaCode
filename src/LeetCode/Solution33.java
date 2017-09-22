package LeetCode;

/**
 * Created by Anonealio on 9/1/2017.
 */
class Solution33 {

    public int binarySearch(int[] nums, int target, int low, int high) {
        if(low >= high) {
            int pivotIndex = (low+high)/2;
            int pivot = nums[pivotIndex];
            if(pivot == target) {
                return pivotIndex;
            }

            int left = nums[low];
            int right = nums[high];
            if(left <= pivot) {
                if(target <=pivot && target >= left) {
                    return binarySearch(nums, target, low, pivotIndex);
                }
                else {
                    return binarySearch(nums, target, pivotIndex+1, high);
                }
            }
            else{
                if(target <= right && target >= pivot) {
                    return binarySearch(nums, target, pivotIndex+1, high);
                }
                else {
                    return binarySearch(nums, target, low, pivotIndex);
                }
            }
        }
        else {
            return -1;
        }


    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length -1);
    }

    public static void main(String[] args) {
        Solution33 s = new Solution33();
        int[] arr = {6,7,0,1,2,4,5};
        s.search(arr, 5);
    }
}