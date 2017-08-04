package SortStuff;

import java.util.ArrayList;

/**
 * Created by Anonealio on 8/3/2017.
 */
public class BinarySearch {

    public int binarySearch(ArrayList<Integer> arr, int low, int high, int x) {
        if(low <= high) {
            int pivotIndex = (low+high)/2;
            int pivot = arr.get(pivotIndex);

            if(pivot == x) {
                return pivotIndex;
            }

            if(x < pivot) {
                return binarySearch(arr, low, pivotIndex-1, x);
            }
            else{
                return binarySearch(arr, pivotIndex +1, high, x);
            }
        }
        return -1;
    }
}
