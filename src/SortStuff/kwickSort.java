package SortStuff;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anonealio on 7/23/2017.
 */
public class kwickSort {


    public void quickSort(ArrayList<Integer> arr, int low, int high) {

        if(low <= high) {

            int pivotIndex = (low+high) /2;
            int pivot = arr.get(pivotIndex);

            int i = low;
            int j = high;

            while(arr.get(i) < pivot) {
                i++;
            }
            while(arr.get(j) > pivot) {
                j--;
            }
            if(i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);

            }

            quickSort(arr, low, j-1);
            quickSort(arr, i+1, high);
        }
    }

    public static void main(String[] args) {
        kwickSort q = new kwickSort();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);arr.add(2);arr.add(1);arr.add(5);arr.add(70);arr.add(25);arr.add(15);arr.add(500);

        q.quickSort(arr, 0, arr.size()-1);
        System.out.println(arr);
    }
}
