package BinaryTree;

/**
 * Created by Anonealio on 8/3/2017.
 */
public class Question4_6 {


    public Node findSuccessor(Node node) {

        if(node != null) {
            if(node.right != null) {
                Node successor = node.right;
                while(successor.left != null) {
                    successor = successor.left;
                }
                return successor;
            }
            else {
//                while(node.parent != null) {
//                    Node successor = node.parent;
//                    if(successor.value > node.value) {
//                        return successor;
//                    }
//                    else {
//                        successor = successor.parent;
//                    }
//                }
                return null;  //////////// REMOVE THIS LINE WHEN PARENT IS ADDED TO NODE STRUCTURE
            }
        }
        else {
            return null;
        }
    }
}
