package BinaryTree;

import static java.lang.Integer.max;
import static java.lang.Math.abs;

/**
 * Created by Anonealio on 7/23/2017.
 */
public class Question4_4 {
    public int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        return max( getHeight(root.left), getHeight(root.right) ) +1;
    }

    public boolean isBalanced(Node root) {
        if(root != null) {
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            System.out.println("left subtree: " + left + "  Right subtree: " + right);
            if (abs(left - right) <= 1) {
                return true;
            }
            else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Question4_4 q = new Question4_4();

        Btree b = new Btree();
        b.insert(10);b.insert(5);b.insert(100);b.insert(2);b.insert(3);b.insert(4);
        b.levelTraversal();
        System.out.println(q.isBalanced(b.getRoot()));




    }
}
