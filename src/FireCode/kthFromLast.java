package FireCode;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class kthFromLast {

    ArrayList<Integer> result = new ArrayList<>();

    public void inOrder(Node root, int k) {
        if(root == null) {
            return;
        }
        inOrder(root.right, k);

        result.add(root.value);

        inOrder(root.left, k);
    }




    public int inOrder2(Node root, int k) {
        if(root == null) {
            return k;
        }
        k = inOrder2(root.right, k);
        if(--k == 0) {
            result.add(root.value);
        }

        k = inOrder2(root.left, k);
        return k;
    }

    public class Pair {
        int k;
        Node result;

        public Pair(int k, Node result) {
            this.k = k;
            this.result = result;
        }
    }

    public Pair inOrder3(Node root, int k) {
        if(root == null) {
            return new Pair(k, null);
        }
        Pair p;
        p = inOrder3(root.right, k);
        if(p.result != null) {
            return p;
        }
        if(p.k - 1 == 0) {
            return new Pair(0, root);
        }
        p.k  = p.k - 1;
        p = inOrder3(root.left, p.k);
        return p;
    }
    public ArrayList getArray() {
        return this.result;
    }

    public void clear() {
        this.result.clear();
    }

    public Node findKthLargest(Node root, int k) {

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            else{
                cur = stack.pop();
                if(--k == 0) {
                    return cur;
                }
                cur = cur.left;
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        kthFromLast q = new kthFromLast();

        Node root = new Node(4, new Node(2, null, null), new Node(8, new Node(5, null, null), new Node(10, null, null)));
        int k = 2;
        q.inOrder(root, k);
        System.out.println(q.getArray());
        System.out.println(q.getArray().get(k-1 ));
        q.clear();
        q.inOrder2(root, k);
        System.out.println(q.getArray());
        q.clear();

        Pair p = q.inOrder3(root, k);
        System.out.println(p.result.value);
    }
}
