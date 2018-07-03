package randomStuff;

/**
 * Created by ndw6152 on 6/2/2018.
 */
public class MaxRect {

    /**
     * Function returns the count for the number of ways a num can be formed from consecutive numbers
     * @return int count, e.g 15 = 3 ways to sum to 15 using consecutive numbers
     */
    static int consecutive(long num) {
        int count = 0;

        int sum = 0;
        int end = (int) (num+1)/2;

        for(int i = 1; i<= end; i++) {
            for(int j = i; j <= end; j++) {
                sum += j;
                if(sum == num) {
                    count++;
                }
                if(sum > num) {
                    break;
                }
            }
            sum = 0;
        }
        return count;
    }


    public static int checlConsecutiveWidth(int[] arr, int index, int height) {
        int width = 0;
        for(int i = index; i<arr.length; i++) {
            if(height <= arr[i]) {
                width++;
            }
            else {
                break;
            }
        }

        for(int i = 0; i <index; i++) {
            if(height <= arr[i]) {
                width++;
            }
            else {
                break;
            }
        }

        return width;
    }

    /**
     * Function returns largest rectangle that can be formed from an array of elements
     * @param arr
     * @return
     */
    static long largestRectangle(int[] arr) {
        int maxRectSize = 0;

        int width = 0;
        int height = 0;
        int area = 0;
        for(int i = 0; i < arr.length; i++) {
            height = arr[i];

            width = checlConsecutiveWidth(arr, i, height);
            area = height*width;
            if(area > maxRectSize) {
                maxRectSize = area;
            }
        }
        return maxRectSize;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        System.out.println("rect size: " + largestRectangle(arr1));



        System.out.println(consecutive(15));
    }
}
