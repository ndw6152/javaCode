package BinaryTree;

/**
 * Created by ndw6152 on 6/23/2018.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val  = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val  = val;
        this.left = left;
        this.right = right;
    }

}
