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


    public void insert(Node n) {
        if(root == null) {
            root = n;
            root.left = null;
            root.right = null;
        }

        Node tempRoot = root;
        if(n.value < tempRoot.value) {

            while(tempRoot.left != null) {

                if(n.value < tempRoot.value) {
                    tempRoot = tempRoot.left;
                }
                else {
                    while(tempRoot.right != null) {
                        if(n.value < tempRoot.right.value) {
                            n.right = tempRoot.right;
                            n.left = null;
                            tempRoot.right = n;
                        }
                        else {
                            tempRoot = tempRoot.right;
                        }
                    }
                    tempRoot.right = n;
                    n.right = null;
                    n.left = null;
                }
            }
        }
    }

    public void bfsTraversal() {
        Node temp = root;
        Queue<Node> q = new Queue<>();

        q.push(temp);

        while(q.getTail() != null) {

            LinkListStuff.Node val = q.pop();
            Node content = (Node)val.value;

            System.out.print(content.value + " - ");
            if(content.left != null)
                q.push(content.left);
            if(content.right != null)
                q.push(content.right);
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

    }


}

