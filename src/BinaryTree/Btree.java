package BinaryTree;


import LinkListStuff.Queue;

/**
 * Created by Anonealio on 6/13/2017.
 */


public class Btree {

    private Node root;


    public Btree(Node n) {
        root = n;
    }


    public void insert(int val) {
        if(root == null) {
            Node temp = new Node(val, null, null);
            root = temp;
        }
        else {
            insert(val, root);
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

    public void bfsTraversal() {
        Node temp = root;
        Queue<Node> currentLevel = new Queue<>();
        Queue<Node> nextLevel = new Queue<>();

        currentLevel.push(temp);

        while(currentLevel.getTail() != null) {
            while(currentLevel.getTail() != null) {
                LinkListStuff.Node val = currentLevel.pop();
                if(val.value != null) {
                    Node content = (Node)val.value;

                    System.out.print(content.value + " ");
                    nextLevel.push(content.left);
                    nextLevel.push(content.right);
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


    public static void main(String[] args) {
        Node _25 = new Node(25, null, new Node(45, null, null));
        Node _75 = new Node(75, new Node(65, null, null), new Node(90, null, null));
        Node _50 = new Node(50, _25, _75);
        Node _200 = new Node(200, null, null);
        Node root = new Node(100, _50, _200);
        Btree b = new Btree(root);

        b.bfsTraversal();
        b.insert(30);
        b.insert(35);
        b.insert(15);

        b.insert(10);
        b.bfsTraversal();


        System.out.println("------------");

        Node start = new Node(100, null, null);
        Btree tree = new Btree(start);

        tree.insert2(start, 45);
        tree.insert2(start, 105);
        tree.insert2(start, 85);
        tree.insert2(start, 10);
        tree.insert2(start, 25);

        tree.bfsTraversal();


    }


}

