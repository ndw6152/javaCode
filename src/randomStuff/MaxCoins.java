package randomStuff;

/**
 * Created by ndw6152 on 6/11/2018.
 */
public class MaxCoins {


    public int maxVal(boolean me, int[] arr , int start, int end) {
        if(start == end) {
            return arr[start];
        }

        if(me) {
            return Math.max(arr[start] + maxVal(false, arr, start +1, end), arr[end] + maxVal(false, arr, start, end-1));
        }
        else {
            return Math.min(maxVal(true, arr, start+1, end), maxVal(true, arr, start, end-1));
        }
    }

    public static void main(String[] arg) {
        int[] arr = {2,1,4}; //{1, 4, 1, 1000, 8};
        MaxCoins q = new MaxCoins();


        System.out.println(q.maxVal(true, arr, 0, arr.length -1));

    }

}
