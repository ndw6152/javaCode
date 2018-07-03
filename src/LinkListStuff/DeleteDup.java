package LinkListStuff;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by ndw6152 on 6/20/2018.
 */
public class DeleteDup {

    public Node<Integer> deleteDuplicatesLinkedList(Node<Integer> head) {
        if(head == null) {
            return null;
        }
        SortedMap<Integer, Integer> map = new TreeMap<>();

        while(head != null) {
            int data = head.value;
            if(map.containsKey(data)) {
                int count = map.get(data);
                map.put(data, count+1);
            }
            else {
                map.put(data, 1);
            }
            head = head.next;
        }
        Node<Integer> start = null;
        Node<Integer> cur = null;
        for(Integer key : map.keySet()) {
            if(map.get(key) == 1) {
                if(start == null) {
                    Node temp = new Node<Integer>(key);
                    temp.next = null;
                    start = temp;
                    cur = start;
                }
                else {
                    Node temp = new Node<Integer>(key);
                    temp.next = null;
                    cur.next = temp;
                    cur = cur.next;
                }
            }
        }
        return start;
    }

    public void backtrack(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> cur, ArrayList<Integer> arr, int index) {
        if(index == arr.size()) {
            results.add(new ArrayList<>(cur));
        }
        else {
            backtrack(results, cur, arr, index+1);
            cur.add(arr.get(index));
            backtrack(results, cur, arr, index+1);
            cur.remove(cur.size()-1);
        }

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A.size() == 0) {
            return result;
        }
        backtrack(result, new ArrayList<>(), A, 0);

        return result;
    }


    public ArrayList<ArrayList<Integer>> backtrack2(ArrayList<Integer> arr, int index) {

        if(arr.size() -1 == index) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            results.add(new ArrayList<>());
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(arr.get(index));
            results.add(cur);
            return results;
        }
        else {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            ArrayList<ArrayList<Integer>> arr2;
            int temp = arr.get(index);
            arr2 = backtrack2(arr, index + 1);
            for(ArrayList<Integer> a : arr2) {
                results.add(new ArrayList<>(a));
                a.add(0, temp);
                results.add(new ArrayList<>(a));
            }
            return results;
        }
    }

    public ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A.size() == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result = backtrack2(A, 0);
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {

        DeleteDup sol = new DeleteDup();
        Integer[] a = new Integer[]{1, 2, 3};

        List<Integer> aa =  Arrays.asList(a);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(aa);
        sol.subsets2(arr);

    }


}
