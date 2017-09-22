package LeetCode;

/**
 * Created by Anonealio on 8/22/2017.
 */

class Solution561 {

    public int partition(int[]arr, int low, int high) {
        if(low < high){
            int pivot = arr[high];
            int i = low;

            for(int j = low; j< high; j++) {
                if(arr[j] <= pivot) {
                    if(j != i) { //swap
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                    i++;
                }
            }
            if(i != high) {
                int temp = arr[i];
                arr[i] = pivot;
                arr[high] = temp;
            }
            return i;
        }
        else {
            return -1;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int middle = partition(arr, low, high);

            if(middle > -1) {
                quickSort(arr, low, middle-1);
                quickSort(arr, middle+1, high);
            }
        }
    }

    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int result = 0;
        for(int i =0; i< nums.length; i+=2) {
            result += Math.min(nums[i], nums[i+1]);
        }
        return result;
    }



    // O(n)
    public int arrayPairSum2(int[] nums) {
        int[] arr = new int[20001];
        int result = 0;

        for(int i=0; i<nums.length; i++) {
            int index = nums[i] + 10000;
            arr[index]++;
        }

        boolean flag = false;
        int value1 = -10001;
        int value2 = -10001;

        for(int j=0; j<arr.length; j++) {
            if(arr[j] != 0) {
                if(!flag) {
                    value1 = j - 10000;
                    flag = true;
                    arr[j]--;
                }
                else {
                    value2 = j - 10000;
                    result += Math.min(value1, value2);
                    flag = false;
                    arr[j]--;
                }
            }
        }
        return result;
    }
}