package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anonealio on 9/10/2017.
 */
public class Traversals {

    public List<Integer> postOrder(Node root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        Node current = root;
        Stack<Node> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(current != null || !s.isEmpty()) {
            if(current != null) {
                result.add(0, current.value);
                s.push(current);
                current = current.right;
            }
            else {
                Node temp = s.pop();
                current = temp.left;
            }
        }
        return result;
    }

    public List<Integer> preOrder(Node root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        Node current = root;
        Stack<Node> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(current != null || !s.isEmpty()) {
            if(current != null) {
                result.add(current.value);
                s.push(current);
                current = current.left;
            }
            else {
                Node temp = s.pop();
                current = temp.right;
            }
        }
        return result;
    }

    public List<Integer> inOrder(Node root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        Node current = root;
        Stack<Node> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(current != null || !s.isEmpty()) {
            if(current != null) {
               s.push(current);
               current = current.left;
            }
            else {
                Node temp = s.pop();
                result.add(temp.value);
                current = temp.right;
            }
        }
        return result;
    }

}
