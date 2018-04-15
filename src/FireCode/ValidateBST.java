package FireCode;

import BinaryTree.Node;

public class ValidateBST {

    // given a binary tree, return true if it is a BST
    public static boolean validateNode(Node root, int left, int right) {
        if (root == null) {
            return true;
        }
        boolean current = root.value > left && root.value < right;

        return current && validateNode(root.left, left, root.value) && validateNode(root.right, root.value, right);
    }

    public static boolean validateBST(Node root) {
        return validateNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
