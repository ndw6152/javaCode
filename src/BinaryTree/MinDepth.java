package BinaryTree;

import randomStuff.MinStep;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ndw6152 on 6/23/2018.
 */
public class MinDepth {
    public int minDepth(Node root) {
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        int count = 0;
        Node cur;
        queue.add(root);

        while(!queue.isEmpty()) {
            count++;
            while(!queue.isEmpty()) {

                cur = queue.poll();

                if(cur.left == null && cur.right == null) {
                    return count;
                }
                if(cur.left != null)
                    queue2.add(cur.left);
                if(cur.right != null)
                    queue2.add(cur.right);
            }

            queue = queue2;
            queue2 = new LinkedList<>();
        }
        return count;
    }


    public void bst(int[] arr, int low, int high) {
        if(low > high) {
            System.out.println("\t " + low + " " + high);
            return;
        }
        int mid = (low+high)/2;
        System.out.println(mid);
        bst(arr, low, mid-1);
        bst(arr, mid+1, high);
    }


    public void createFibArr(int[] arr, int n) {
        int a =1;
        int b =1;

        while(b <= n) {
            arr[b] = 1;
            int temp = a;
            a = b;
            b = temp + b;
        }
    }

    public int fibsum(int n) {
        if(n <= 0) {
            return 0;
        }

        int[] arr = new int[n+1];
        createFibArr(arr, n);

        for(int j = 1; j <= n; j++) {
            if(arr[j] == 0) {
                int min = Integer.MAX_VALUE;
                for(int i = 1; i< j; i++) {
                    int temp = arr[j-i] + arr[i];
                    min = Math.min(min, temp);
                }
                arr[j] = min;
            }
        }
        return arr[n];
    }



    public static void main(String[] args) {
        MinDepth sol = new MinDepth();

        Btree tree = new Btree();
        tree.insert(5); tree.insert(3);tree.insert(15);
        //sol.minDepth(tree.getRoot());



        int[] arr = {1,2,3,4,5,6};
        sol.bst(arr, 0, arr.length -1);


        sol.fibsum(1);
    }



}
