package BinaryTree;


import LinkListStuff.Queue;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Anonealio on 6/13/2017.
 */


public class Btree {

    private Node root;

    public Btree() {

    }

    public Btree(Node n) {
        root = n;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int val) {
        if(root == null) {
            Node temp = new Node(val, null, null);
            root = temp;
        }
        else {
            insert2(root, val);
        }
    }

    public void insert(int val, Node root) {
        if(val < root.value) {
            if(root.left == null) {
                Node temp = new Node(val, null, null);
                root.left = temp;
            }
            else {
                insert(val, root.left);
            }
        }
        else{
            if(root.right == null) {
                Node temp = new Node(val, null, null);
                root.right = temp;
            }
            else {
                insert(val, root.right);
            }
        }
    }


    public Node insert2(Node root, int val) {
        if (root == null) {
            return new Node(val, null, null);
        }
        if(val < root.value) {
            root.left = insert2(root.left, val);
        }
        else {
            root.right = insert2(root.right, val);
        }
        return root;

    }

    public void BFSbtree() {
        Node temp = root;
        java.util.Queue<Node> q = new LinkedList<>();

        if (temp != null) {
            q.add(temp);

            while(!q.isEmpty()) {
                Node current = q.poll();
                if(!current.visited) {
                    System.out.print(current.value + " ");
                    q.add(current.left);
                    q.add(current.right);
                    current.visited = true;
                }
            }
        }
    }

    public void DFSbtree() {
        Node temp = root;
        Stack stack = new Stack();

        if (temp !=  null) {
            stack.push(temp);

            while(!stack.isEmpty()) {
                Node current = (Node)stack.pop();
                if(!current.visited) {
                    System.out.print(current.value + " ");
                    stack.push(current.left);
                    stack.push(current.right);
                    current.visited = true;
                }
            }
        }

    }

    public void levelTraversal() {
        Node temp = root;
        Queue<Node> currentLevel = new Queue<>();
        Queue<Node> nextLevel = new Queue<>();

        currentLevel.push(temp);

        while(currentLevel.getTail() != null) {
            while(currentLevel.getTail() != null) {
                Node val = currentLevel.pop();
                if(val != null) {

                    System.out.print(val.value + " ");
                    nextLevel.push(val.left);
                    nextLevel.push(val.right);
                }
                else {
                    System.out.print("- ");
                }

            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new Queue<>();
        }

    }


    public void inOrderTraversal(Node root, boolean ascending) {
        if(root == null) {
            return;
        }
        Node temp = root;
        if(ascending) {
            inOrderTraversal(temp.left, ascending);
            System.out.print(temp.value + " ");
            inOrderTraversal(temp.right, ascending);
        }
        else {
            inOrderTraversal(temp.right, ascending);
            System.out.print(temp.value + " ");
            inOrderTraversal(temp.left, ascending);
        }
    }

    public void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value + " ");

    }

    public boolean isPath(Node start, Node dest) {
        if(start != null || dest != null) {
            return false;
        }

        Node temp = start;
        java.util.Queue q = new LinkedList<Node>();
        q.add(temp);

        while(!q.isEmpty()) {
            Node current = (Node)q.poll();
            if(current != null) {
                if(!current.visited) {

                    if(current == dest) {
                        return true;
                    }

                    q.add(current.left);
                    q.add(current.right);
                }
            }
        }
        return false;

    }


    int checkHeight(Node root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node _25 = new Node(25, null, new Node(45, null, null));
        Node _75 = new Node(75, new Node(65, null, null), new Node(90, null, null));
        Node _50 = new Node(50, _25, _75);
        Node _200 = new Node(200, null, null);
        Node root = new Node(100, _50, _200);
        Btree b = new Btree(root);

        b.levelTraversal();
        b.insert(30);
        b.insert(35);
        b.insert(15);

        b.insert(10);
        b.levelTraversal();


        System.out.println("------------");

        Node start = new Node(100, null, null);
        Btree tree = new Btree(start);

        tree.insert2(start, 45);
        tree.insert2(start, 105);
        tree.insert2(start, 200);
        tree.insert2(start, 150);
        tree.insert2(start, 10);
        tree.insert2(start, 55);
        tree.insert2(start, 50);
        tree.insert2(start, 70);

        tree.levelTraversal();

        System.out.println("-------------");
        tree.inOrderTraversal(start, true);
        System.out.println();
        tree.inOrderTraversal(start, false);
        System.out.println();

        System.out.println("-------------");
        tree.preOrderTraversal(start);

        System.out.println("-------------");
        tree.postOrderTraversal(start);
    }


}

