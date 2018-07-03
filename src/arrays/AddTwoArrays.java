package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddTwoArrays {

    public ArrayList<Integer> add(int[] arr, int[] arr2) {
        int carry = 0;
        int index = 0;
        int val = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0; i < arr2.length; i++) {
            val = arr2[index] + arr[index] + carry;
            if(val >= 10) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            index++;
            result.add(val%10);
        }

        for(int j = index; j < arr.length; j++) {
            val = arr[j] + carry;
            if(val >= 10) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            index++;
            result.add(val%10);
        }
        if(carry == 1) {
            result.add(1);
        }

        return result;
    }

    public ArrayList<Integer> addition(int[] arr, int[] arr2) {
        if (arr.length > arr2.length) {
            return add(arr, arr2);
        } else {
            return add(arr2, arr);
        }
    }

    public void print(ArrayList<Integer> arr) {
        for(int i = 0; i< arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }


    public static void main(String[] args) {
        AddTwoArrays q = new AddTwoArrays();

        int[] arr = {4, 2};
        int[] arr2 = {6, 2, 7};

        ArrayList<Integer> res = q.addition(arr, arr2);
        q.print(res);
        System.out.println();


        String str = "AT";
        System.out.println(str.substring(0,0));
        char ch = 'C';
        for(int i =0; i<= str.length(); i++) {
            System.out.println(str.substring(0,i) + ch + str.substring(i));
        }
    }
}
