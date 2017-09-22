package LeetCode;

/**
 * Created by Anonealio on 8/29/2017.
 */
public class Solution31 {
    public void reverseNums(int[] nums, int low, int high) {
        int i = low;

        while (i < high) {
            int temp = nums[i];
            nums[i] = nums[high];
            nums[high] = temp;
            i++;
            high--;
        }
    }

    public void swapInt(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            boolean flag = true;
            int i;

            for (i = nums.length - 2; i >= 0; i--) { // find first number that breaks descending order
                if (nums[i] < nums[i+1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {  // if flag all descending thus reverse all the numbers;
                reverseNums(nums, 0, nums.length - 1);
            } else {
                if (i >= 0) {
                    int rightIndex = nums.length - 1;
                    while (rightIndex > i) { // compare all elements starting from right side, if element is larger than element at i, swap it.
                        if (nums[rightIndex] > nums[i]) {   // if not flag this means that there is an element > nums[i]
                            break;
                        }
                        rightIndex--;
                    }
                    swapInt(nums, rightIndex, i);
                }
                reverseNums(nums, i+1, nums.length - 1);
            }
        }
    }

    public void printArr(int[] arr) {
        for(int i :arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }





    class Solution31b{
        public void nextPermutation(int[] nums){
            int n = nums.length;
            if(n  < 2) return;
            int first = firstIndex(nums) - 1;

            if(first != -1){
                int second = secondIndex(nums, nums[first]);
                swap(first, second, nums);
            }


            reverse(first + 1, n - 1, nums);
        }

        private int firstIndex(int[] nums){
            for(int i = nums.length - 1; i > 0; i--){
                if(nums[i - 1] < nums[i]){
                    return i;
                }
            }
            return 0;
        }

        private int secondIndex(int[] nums, int first){
            for (int i = nums.length - 1; 0 <= i; --i) {
                if (first < nums[i]) return i;
            }
            return -1;
        }

        private void swap(int a, int b, int[] nums){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

        private void reverse(int a, int b, int[] nums){
            while (a < b) {
                swap(a++, b--, nums);
            }
        }
    }




















    public static void main(String[] args) {
        Solution31 s = new Solution31();
        int[] arr = {9,4,6,5,3};
        s.nextPermutation(arr);
        s.printArr(arr);


        int[] arr2 = {1,2,1,8,7,6,5,4,3};
        s.printArr(arr2);
        s.nextPermutation(arr2);
        s.printArr(arr2);
    }
}
