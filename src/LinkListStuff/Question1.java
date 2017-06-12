package LinkListStuff;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Created by Anonealio on 6/5/2017.
 */


public class Question1 {


    public void printNode(Node n) {
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public Node reverse(Node start) {
        Node prev = null;
        while(start != null) {
            Node next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }

        return prev;
    }

    public void runReverse() {

        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        Node n0 = new Node(0, n1);

        Node newHead = reverse(n0);
        printNode(newHead);
    }

    public String reverseAllWords(String str) {
        String[] temp = str.split(" ");
        String result = "";
        for( int i = temp.length-1; i >= 0; i-- ) {
            result += temp[i] + " ";
        }
        System.out.println(result);
        return result;
    }

    public void reverseString(String str) {
        System.out.println("Starting String: " + str);
        String result = "";
        String[] arr = str.split("");
        for(int i = arr.length - 1; i >= 0; i--) {
            result += arr[i];
        }

        System.out.println(result);
    }

    private ArrayList<Integer> copyArr(ArrayList<Integer> current, ArrayList<Integer> result) {
        result.addAll(current);
        return result;
    }

    public void largestSumOfNonContiguousNumbers(ArrayList<Integer> arr) {

        HashMap<Integer, ArrayList<Integer>> table = new HashMap<>();

        ArrayList<Integer> maxArr = new ArrayList<>();
        ArrayList<Integer> tempArr = new ArrayList<>();
        int maxSum = 0;
        int temp = 0;
        for(int i = 0; i< arr.size(); i++) {
            temp += arr.get(i);
            tempArr.add(arr.get(i));
            if(temp > maxSum) {
                maxSum = temp;
                maxArr.clear();
                for(Integer val : tempArr) {
                    maxArr.add(val);
                }
            }
            if(temp < 0) {
                temp = 0;
                // reset map?
                tempArr.clear();
            }
        }

        System.out.println(maxSum);

    }




    public static void main(String[] args) {
        System.out.println("Running question 1");
        Question1 program = new Question1();
        // program.runReverse();
        // program.reverseString("Testing");

        ArrayList<Integer> arr = new ArrayList();
        arr.add(1); arr.add(-1); arr.add(50); arr.add(-100); arr.add(5); arr.add(-10); arr.add(15);
        program.largestSumOfNonContiguousNumbers(arr);

    }
}
