package BinaryTree;

import java.util.ArrayList;

/**
 * Created by Anonealio on 7/23/2017.
 */
public class Question4_2 {
    Btree b;

    Question4_2() {
        this.b = new Btree();
    }

    public void partition(ArrayList<Integer> arr, int low, int high) {
        if(low <= high) {
            int pivotIndex = (low +high)/2;
            int pivot = arr.get(pivotIndex);

            b.insert(pivot);

            partition(arr, low, pivotIndex-1);
            partition(arr, pivotIndex+1, high);
        }
    }

    public static void main(String[] args) {

        Question4_2 q = new Question4_2();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);arr.add(1);arr.add(2);arr.add(3);arr.add(4);arr.add(5);arr.add(6);arr.add(7);arr.add(8);arr.add(9);arr.add(10);arr.add(11);

        q.partition(arr, 0, arr.size()-1);
        q.b.levelTraversal();

    }
}
