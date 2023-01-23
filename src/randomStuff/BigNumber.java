package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 7/9/2018.
 */
public class BigNumber {

    public ArrayList<Integer> addArrays(ArrayList<Integer> arr, ArrayList<Integer> arr2) {
        if(arr.size() < arr2.size()) {
            return addArrays(arr2, arr);
        }

        int carry = 0;

        for(int i = 0; i < arr.size(); i++) {
            int val2 = 0;
            if(i < arr2.size()) {
                val2 = arr2.get(i);
            }
            int result = arr.get(i) + val2 + carry;
            carry = result/10;
            result = result%10;
            arr.set(i, result);
        }
        if(carry == 1) {
            arr.add(1);
        }
        return arr;
    }

    public static void main(String[] args) {
        BigNumber sol = new BigNumber();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);arr.add(4);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(9);arr2.add(2);
        sol.addArrays(arr, arr2);

        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.add(1);arr4.add(2);arr4.add(3);arr4.add(4);
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(9); arr3.add(0); arr3.add(0); arr3.add(7);
        sol.addArrays(arr3, arr4);

        System.out.println(arr);
        System.out.println(arr3);

        ArrayList<Integer> arr6 = new ArrayList<>();
        arr6.add(1);
        ArrayList<Integer> arr7 = new ArrayList<>();
        arr7.add(4); arr7.add(6); arr7.add(1); arr7.add(2);
        System.out.println(sol.addArrays(arr6, arr7));
    }
}
