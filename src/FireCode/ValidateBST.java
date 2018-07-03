package FireCode;

import BinaryTree.Node;

import java.util.Collections;
import java.util.PriorityQueue;

public class ValidateBST {

    // given a binary tree, return true if it is a BST
    public static boolean validateNode(Node root, int left, int right) {
        if (root == null) {
            return true;
        }
        boolean current = root.value > left && root.value < right;

        return current && validateNode(root.left, left, root.value) && validateNode(root.right, root.value, right);
    }

    static int[] sortKMessedArray(int[] arr, int k) {
        if(k < 1) {
            return arr;
        }
        /*
         Input:    [1,0,3,2,4,5,7,6,8], 1
         Expected: [0,1,2,3,4,5,6,7,8]
         Actual: [0, 0, 1, 2, 3, 4, 5, 6, 7]
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] output = new int[arr.length];

        if(k >= arr.length) {
            k = arr.length -1;
        }

        for(int i =0; i<= k; i++) {
            heap.add(arr[i]);
        }
        int temp;
        for(int index = 0; index < arr.length; index++) {
            temp = heap.poll();
            output[index] = temp;

            if(index + k + 1 < arr.length) {
                heap.add(arr[index + k + 1]);
            }
        }

        return output;
    }


    static int[] sortKMessedArray1(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue(k+1);
        int windowIndex = k+1;
        int initialIndex = 0;
        while((initialIndex <= windowIndex) && (initialIndex < arr.length ) ) {
            minHeap.add(arr[initialIndex]);
            initialIndex++;
        }

        for (int i=0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
            windowIndex++;
            if (windowIndex < arr.length) {
                minHeap.add(arr[windowIndex]);
            }
        }
        return arr;
    }

    public static boolean validateBST(Node root) {
        return validateNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
