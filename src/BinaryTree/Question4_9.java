package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anonealio on 8/3/2017.
 */
public class Question4_9 {

    public ArrayList<ArrayList<String>> merge(String str, ArrayList<String> array) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> array2;
        for(int i = 0; i <array.size(); i++) {
            array2 = (ArrayList<String>) array.clone();
            array2.add(i, str);
            result.add(array2);
        }
        array2 = (ArrayList<String>) array.clone();
        array2.add(str);
        result.add(array2);
        return result;
    }

    public void printArray(ArrayList<ArrayList<String>> array) {
        System.out.println(array.size());
        for(ArrayList<String> arr : array) {
            for(String str : arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public ArrayList<ArrayList<String>> permutation(ArrayList<String> array) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(array.size() == 2) {
            String s = array.get(0);
            array.remove(0);
            return merge(s, array);
        }

        String s = array.get(0);
        array.remove(0);
        ArrayList<ArrayList<String>> arrayRes = permutation(array);
        for(ArrayList<String> arrString : arrayRes) {
            ArrayList<ArrayList<String>> mergeRes =  merge(s, arrString);
            result.addAll(mergeRes);
        }

        return result;
    }






    public static void main(String[] args) {

        Question4_9 q = new Question4_9();
        ArrayList<String> array = new ArrayList<>();
        array.add("c");
        q.printArray(q.merge("d", array));
        System.out.println("-----------");

        ArrayList<String> array2 = new ArrayList<>();
        array2.add("a");array2.add("b");array2.add("c");array2.add("d");
        ArrayList<ArrayList<String>> res = q.permutation(array2);
        q.printArray(res);



    }
}
