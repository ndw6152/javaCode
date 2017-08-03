package BinaryTree;

import LinkListStuff.Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anonealio on 8/3/2017.
 */
public class Question4_9 <T>{

    public ArrayList<ArrayList<T>> merge(T str, ArrayList<T> array) {
        ArrayList<ArrayList<T>> result = new ArrayList<>();
        ArrayList<T> array2;
        for(int i = 0; i <array.size(); i++) {
            array2 = (ArrayList<T>) array.clone();
            array2.add(i, str);
            result.add(array2);
        }
        array2 = (ArrayList<T>) array.clone();
        array2.add(str);
        result.add(array2);
        return result;
    }

    public void printArray(ArrayList<ArrayList<T>> array) {
        System.out.println(array.size());
        for(ArrayList<T> arr : array) {
            for(T str : arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public ArrayList<ArrayList<T>> permutation(ArrayList<T> array) {
        ArrayList<ArrayList<T>> result = new ArrayList<>();
        if(array.size() == 2) {
            T s = array.get(0);
            array.remove(0);
            return merge(s, array);
        }

        T s = array.get(0);
        array.remove(0);
        ArrayList<ArrayList<T>> arrayRes = permutation(array);
        for(ArrayList<T> arrString : arrayRes) {
            ArrayList<ArrayList<T>> mergeRes =  merge(s, arrString);
            result.addAll(mergeRes);
        }

        return result;
    }


    public void printByLevel(Node root) {

        Queue<Node> queue = new Queue<>();
        Queue<Node> queue2 = new Queue<>();


        if(root != null) {
            queue.push(root);

            while(queue.getSize() != 0) {

                while(queue.getSize() != 0) {
                    Node current = queue.pop();
                    System.out.print(current.value + " ");
                    if(current.left != null)
                        queue2.push(current.left);
                    if(current.right != null)
                        queue2.push(current.right);
                }
                System.out.println();
                queue = queue2;
                queue2 = new Queue<>();
            }
        }


    }

    public static void main(String[] args) {

        Question4_9<String> q = new Question4_9<>();
        ArrayList<String> array = new ArrayList<>();
        array.add("c");
        q.printArray(q.merge("d", array));
        System.out.println("-----------");

        ArrayList<String> array2 = new ArrayList<>();
        array2.add("a");array2.add("b");array2.add("c");array2.add("d");
        ArrayList<ArrayList<String>> res = q.permutation(array2);
        q.printArray(res);
        System.out.println("-----------");

        Question4_9<Integer> q2 = new Question4_9<>();
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(2);arrInt.add(3);arrInt.add(4);
        ArrayList<ArrayList<Integer>> res2 = q2.permutation(arrInt);
        q2.printArray(res2);
        System.out.println("-----------");


        Btree b = new Btree();
        b.insert(15);b.insert(10);b.insert(20);b.insert(5);b.insert(11);b.insert(25);b.insert(100);

        q2.printByLevel(b.getRoot());


    }
}
