package FireCode;

import BinaryTree.Node;

import java.util.Stack;

public class MinTreeDepth {

    public int minDepth(Node root) {
        if(root == null) {
            return 0;
        }


        Stack<Node> stack = new Stack<>();

        int minDepth = 0;
        int curCount = 0;

        Node cur = root;
        while(cur != null || !stack.isEmpty()) {

            if(cur != null) {
                curCount++;
                if(cur.left == null && cur.right == null) {
                    if(minDepth == 0 || curCount < minDepth) {
                        minDepth = curCount;
                        cur = null;
                    }
                }
                else {
                    stack.push(cur);
                    cur = cur.left;
                }

            }
            else{
                cur = stack.pop();
                curCount--;
                cur = cur.right;
            }
        }
        if(curCount < minDepth) {
            minDepth = curCount;
        }
        return minDepth;
    }

    public static void main(String[] argv) {
        MinTreeDepth tree = new MinTreeDepth();

        Node root = new Node(1, new Node(2, new Node(4,null,null), null), new Node(3, null,null));
        tree.minDepth(root);
    }
}
