package SortStuff;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anonealio on 7/23/2017.
 */
public class kwickSort {

    public void printArray(ArrayList<Integer> arr, int low, int high) {
        for(int i =low; i< high; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    // inefficient quicksort that recurse on the array too many times and have overlaps on the left array and right array
    public void quickSort(ArrayList<Integer> arr, int low, int high) {

        if(low < high) {

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
            System.out.print(arr);
            System.out.println(" pivot = " + pivot +" i =" + i + "  j=" +j);
            quickSort(arr, low, j-1);
            quickSort(arr, i+1, high);
        }
    }


    // reducing the number of recursive calls with additional while loops
    public void quickSort2(ArrayList<Integer> arr, int low, int high) {

        if(low < high) {

            int pivotIndex = (low+high) /2;
            int pivot = arr.get(pivotIndex);

            int i = low; //low
            int j = high;
            while(i <= j) {

                while(arr.get(i) < pivot) {
                    i++;
                }
                while(arr.get(j) > pivot) {
                    j--;
                }
                if(i <= j) {  // swap them
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    i++;
                    j--;
                    System.out.print(arr);
                    System.out.println(" pivot = " + pivot +" i =" + i + "  j=" +j);
                }
//                System.out.print(arr);
//                System.out.println(" pivot = " + pivot +" i =" + i + "  j=" +j);
            }
            quickSort2(arr, low, i-1);
            quickSort2(arr, i, high);
        }
    }

    /////////////////
    // use high as the pivotIndex
    // loop through all elements starting from the left, if the value is less than the pivot swap with leftMost i index.
    // Once loop is over, swap pivot with i, all elements on the left is now smaller than pivot, all elements on right
    // is larger than pivot.
    // recurse the quicksort with low to pivotIndex-1 and pivotIndex+1 to high
    public int partition(ArrayList<Integer> arr, int low, int high) {
        if(low >= high) {
            return -1;
        }
        int i = low;
        int pivotIndex = high;
        int pivot = arr.get(high);

        for(int j = low; j < high; j++) {
            if(arr.get(j) <= pivot) {
                if(i != j){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
                i++;
                System.out.println(arr + " pivot =" +  pivot + " i=" + i + " j=" + j);
            }
        }
        System.out.println(arr + " pivot =" +  pivot + " i=" + i);
        if(i != pivotIndex) {
            int temp = arr.get(i);
            arr.set(i, pivot);
            arr.set(pivotIndex, temp);
        }
        return i;
    }

    public void quickSort3(ArrayList<Integer> arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);

            if(pi > 0) {
                quickSort3(arr, low, pi -1);
                quickSort3(arr, pi +1, high);
            }
        }
    }




    public static void main(String[] args) {
        kwickSort q = new kwickSort();

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(100, 2, 1, 5, 70, 25, 15, 500));
        System.out.println(arr);
        q.quickSort(arr, 0, arr.size()-1);
        System.out.println(arr);

        System.out.println("---------------quicksort 2---------------");
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(100, 2, 1, 5, 70, 25, 15, 500));
        System.out.println(arr2);
        q.quickSort2(arr2, 0, arr2.size()-1);
        System.out.println(arr2);
        System.out.println("----------------quicksort --------------");

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(54, 26, 93, 17, 77, 31, 44, 55, 20));
        System.out.println(arr3);
        q.quickSort(arr3, 0, arr3.size()-1);
        System.out.println(arr3);

        System.out.println("-----------------quick sort 2 -------------");
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(54, 26, 93, 17, 77, 31, 44, 55, 20));
        System.out.println(arr4);
        q.quickSort2(arr4, 0, arr4.size()-1);
        System.out.println(arr4);


        System.out.println("-----------------quick sort  2-------------");
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(22, 2, 3, 2, 2 , 2));
        System.out.println(arr5);
        q.quickSort2(arr5, 0, arr5.size()-1);
        System.out.println(arr5);


        System.out.println("-----------------quick sort  3-------------");
        ArrayList<Integer> arr6 = new ArrayList<>(Arrays.asList(54, 26, 93, 17, 20, 31, 44, 55, 77));
        System.out.println(arr6);
        q.quickSort3(arr6, 0, arr6.size()-1);
        System.out.println(arr6);


        System.out.println("-----------------quick sort  3-------------");
        ArrayList<Integer> arr7 = new ArrayList<>(Arrays.asList(22, 2, 3, 2, 2 , 2));
        System.out.println(arr7);
        q.quickSort3(arr7, 0, arr7.size()-1);
        System.out.println(arr7);

        System.out.println("-----------------quick sort  3-------------");
        ArrayList<Integer> arr8 = new ArrayList<>(Arrays.asList(100, 2, 1, 5, 70, 25, 15, 500));
        System.out.println(arr8);
        q.quickSort3(arr8, 0, arr8.size()-1);
        System.out.println(arr8);

        System.out.println("-----------------quick sort  3-------------");
        ArrayList<Integer> arr9 = new ArrayList<>(Arrays.asList(2, 3, 1, 5, 4, 6, 7, 1));
        System.out.println(arr9);
        q.quickSort3(arr9, 0, arr9.size()-1);
        System.out.println(arr9);

        System.out.println("-----------------quick sort  3-------------");
        ArrayList<Integer> arr10 = new ArrayList<>(Arrays.asList(-2, -3, 1, 5, 4, 6, 7, -1));
        System.out.println(arr10);
        q.quickSort3(arr10, 0, arr10.size()-1);
        System.out.println(arr10);

        System.out.println("-----------------quick sort 3-------------");
        ArrayList<Integer> arr11 = new ArrayList<>(Arrays.asList(10, 80, 30, 90, 40, 50, 70));
        System.out.println(arr11);
        q.quickSort3(arr11, 0, arr11.size()-1);
        System.out.println(arr11);


        System.out.println("-----------------quick sort 3-------------");
        ArrayList<Integer> arr12 = new ArrayList<>(Arrays.asList(5, 1, 100, 55, 2, 3, 10));
        System.out.println(arr12);
        q.quickSort3(arr12, 0, arr12.size()-1);
        System.out.println(arr12);


    }
}
