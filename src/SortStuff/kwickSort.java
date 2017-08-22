package SortStuff;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anonealio on 7/23/2017.
 */
public class kwickSort {

    public void printArray(ArrayList<Integer> arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

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
            if(i < j) {  // swap them
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);

            }
            printArray(arr);
            System.out.println("i =" + i + "  j=" +j);
            quickSort(arr, low, j-1);
            quickSort(arr, i+1, high);
        }
    }


    public void quickSort2(ArrayList<Integer> arr, int low, int high) {

        if(low < high) {

            int pivotIndex = (low+high) /2;
            int pivot = arr.get(pivotIndex);

            int i = low; //low
            int j = high;
            while(i < j) {
                while(arr.get(i) < pivot) {
                    i++;
                }
                while(arr.get(j) > pivot) {
                    j--;
                }
                if(i < j) {  // swap them
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
                printArray(arr);
                System.out.println("pivot = " + pivot +" i =" + i + "  j=" +j);
            }
            quickSort2(arr, low, i-1);
            quickSort2(arr, i+1, high);
        }
    }

    public static void main(String[] args) {
        kwickSort q = new kwickSort();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);arr.add(2);arr.add(1);arr.add(5);arr.add(70);arr.add(25);arr.add(15);arr.add(500);
        System.out.println(arr);
        q.quickSort(arr, 0, arr.size()-1);
        System.out.println(arr);

        System.out.println("------------------------------");
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(100);arr2.add(2);arr2.add(1);arr2.add(5);arr2.add(70);arr2.add(25);arr2.add(15);arr2.add(500);
        System.out.println(arr2);
        q.quickSort2(arr2, 0, arr2.size()-1);
        System.out.println(arr2);
        System.out.println("------------------------------");

        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(54);arr3.add(26);arr3.add(93);arr3.add(17);arr3.add(77);arr3.add(31);arr3.add(44);arr3.add(55);arr3.add(20);
        System.out.println(arr3);
        q.quickSort(arr3, 0, arr3.size()-1);
        System.out.println(arr3);
        System.out.println("------------------------------");

        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.add(54);arr4.add(26);arr4.add(93);arr4.add(17);arr4.add(77);arr4.add(31);arr4.add(44);arr4.add(55);arr4.add(20);
        System.out.println(arr4);
        q.quickSort2(arr4, 0, arr4.size()-1);
        System.out.println(arr4);
    }
}
