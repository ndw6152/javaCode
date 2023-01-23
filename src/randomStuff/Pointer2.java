package randomStuff;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ndw6152 on 9/5/2018.
 */
public class Pointer2 {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        if(A.size() == 0 || B.size() == 0) {
            return result;
        }
        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < A.size() && ptr2 < B.size()) {
            while(A.get(ptr1) < B.get(ptr2)) {
                ptr1++;
            }
            while(B.get(ptr2) < A.get(ptr1)) {
                ptr2++;
            }
            if(B.get(ptr2).equals(A.get(ptr1))) {
                result.add(B.get(ptr2));
                System.out.println(B.get(ptr2));

                ptr2++;
                ptr1++;
                System.out.println(ptr1 < A.size() && ptr2 < B.size());
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Pointer2 sol = new Pointer2();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(1000); arr1.add(444); arr1.add(55555);
        arr2.add(1000);arr2.add(222);arr2.add(22);arr2.add(33);arr2.add(44);arr2.add(55);
        sol.intersect(arr1, arr2);
    }
}
