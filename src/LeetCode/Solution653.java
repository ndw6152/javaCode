package LeetCode;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}


class Solution653 {

    public boolean breadthFirstSearch(TreeNode root, int sum) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root != null) {
            queue.add(root);

            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node != null) {
                    if(table.get(node.val) == null) {
                        table.put(sum - node.val, 1);
                    }
                    else {
                        return true;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }

            }
            return false;
        }
        else {
            return false;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        return breadthFirstSearch(root, k);
    }
//     public boolean inOrderTraversal(Hashtable<Integer, Integer> table, TreeNode node, int sum) {
//         boolean val = false;
//         if(node == null) {
//             return false;
//         }


//         val |= inOrderTraversal(table, node.left, sum);
//         if(table.get(node.val) == null) {
//             table.put(sum - node.val, 1);
//         }
//         else{
//             return true;
//         }
//         val |= inOrderTraversal(table, node.right, sum);
//         return val;
//     }

//     public boolean findTarget(TreeNode root, int k) {
//         Hashtable<Integer, Integer> table = new Hashtable<>();
//         return inOrderTraversal(table, root, k);

//     }
}