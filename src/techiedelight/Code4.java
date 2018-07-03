package techiedelight;

import BinaryTree.Btree;
import BinaryTree.Node;

/**
 * Created by Anonealio on 9/21/2017.
 */
public class Code4 {

    public boolean checkBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.value > min && root.value < max) {
            return checkBST(root.left, min, root.value) && checkBST(root.right, root.value, max);
        }
        return false;
    }

    public boolean isBST(Node root) {
        if(root == null) {
            return true;
        }
        return checkBST(root.left, Integer.MIN_VALUE, root.value) && checkBST(root.right, root.value, Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        Code4 c=  new Code4();

        Node root = new Node(10, null, null);
        Btree tree = new Btree(root);
        tree.insert(5);tree.insert(25);tree.insert(7);tree.insert(16);

        System.out.println(c.isBST(root));

        Node badRoot = new Node(10, new Node(5,null, new Node(15, null, null)), new Node(25, null, null));
        System.out.println(c.isBST(badRoot));

    }

}
