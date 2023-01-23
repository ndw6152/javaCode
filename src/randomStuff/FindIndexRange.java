package randomStuff;

/**
 * Created by ndw6152 on 7/5/2018.
 */
public class FindIndexRange {

    public int findFirstTarget(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = (low+ high)/2;
            if(arr[mid] == target && (mid == 0 || arr[mid-1] < target)) {
                return mid;
            }
            else if(arr[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int findLastTarget(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;


        while(low <= high) {
            int mid = (low+ high)/2;
            if(arr[mid] == target && (mid == arr.length-1 || arr[mid+1] > target)) {
                return mid;
            }
            else if(arr[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public void printIndexRange(int[] arr, int target) {

        int first = findFirstTarget(arr, target);
        int last = findLastTarget(arr, target);
        if(first == -1 || last == -1) {
            System.out.println(String.format("ERROR target %d not in array", target));
            return;
        }

        System.out.println(String.format("%d--%d : count %d", first, last, last -first +1));
    }



    public int findMinSmallVal(int[] arr, int target) {
        int low = 0;
        int high = arr.length -1;

        if(target <= arr[low]) {
            return low;
        }
        else if(target >= arr[high]) {
            return high;
        }

        while(low <= high) {
            int midId = (low + high)/2;
            int mid = arr[midId];

            if(mid == target) {
                return midId;
            }
            else if(midId == arr.length -1) {
                return -1;
            }
            else if(mid < target && arr[midId +1] > target) {
                return midId;
            }
            else if(mid < target) {
                low = midId + 1;
            }
            else {
                high = midId -1;
            }
        }

        return -1;
    }

    public boolean findVal(int[][] matrix, int target, int colIndex) {
        int low = 0;
        int high = matrix.length -1;

        if(target < matrix[low][colIndex]) {
            return false;
        }
        else if(target > matrix[high][colIndex]) {
            return true;
        }

        while(low <= high) {
            int midId = (low + high)/2;
            int mid = matrix[midId][colIndex];

            if(mid == target) {
                return true;
            }
            else if(mid < target) {
                low = midId +1;
            }
            else {
                high = midId -1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        FindIndexRange sol = new FindIndexRange();

        int[] arr = {60,60,60,60,60,100,120,150,250,250,250,500};
        //System.out.println(sol.findFirstTarget(arr, 60));
        sol.printIndexRange(arr, 60);
        sol.printIndexRange(arr, 10);
        sol.printIndexRange(arr, 250);
        System.out.println("-----------------");
        int[] arr4 = {0,0,0, 1, 1 };
        sol.printIndexRange(arr4, 0);

        int[] arr2 = {1,2,4,7,8,9,10};
        System.out.println("-----------------");
        System.out.println(sol.findMinSmallVal(arr2, 0));
        System.out.println(sol.findMinSmallVal(arr2, 2));
        System.out.println(sol.findMinSmallVal(arr2, 5));
        System.out.println(sol.findMinSmallVal(arr2, 10));
        System.out.println(sol.findMinSmallVal(arr2, 12));

        System.out.println("-----------------");

        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,26},
        };

        System.out.println(sol.findVal(matrix, 5, sol.findMinSmallVal(matrix[0], 5)));
        System.out.println(sol.findMinSmallVal(matrix[0], 16));
        //System.out.println(sol.findVal(matrix, 16, ));
        System.out.println(sol.findVal(matrix, 25, sol.findMinSmallVal(matrix[0], 25)));
        System.out.println(sol.findVal(matrix, 26, sol.findMinSmallVal(matrix[0], 26)));


    }
}
