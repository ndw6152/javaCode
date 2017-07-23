package BinaryTree;

/**
 * Created by Anonealio on 6/13/2017.
 */
public class Node {

    public Node left;
    public Node right;
    public int value;

    public boolean visited = false;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}