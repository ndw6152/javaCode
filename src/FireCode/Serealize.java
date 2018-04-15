package FireCode;

import BinaryTree.Btree;
import BinaryTree.Node;

import java.util.*;

public class Serealize {

    public String serialize(Node root) {
        if(root == null) {
            return "null";
        }
        String str = serialize(root.left);
        String str2 = serialize(root.right);

        return root.value + "," + str + "," + str2;

    }

    public String serealizeTree(Node root) {
        if(root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Stack<Node> s = new Stack<>();

        Node current = root;
        while(current != null || !s.isEmpty()) {
            if(current != null) {
                sb.append(",").append(current.value);
                s.add(current);
                current = current.left;
            }
            else {
                sb.append(",null");
                current = s.pop().right;
            }
        }
        sb.append(",null");
        if(sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    // preeorder restore
    public Node restoreTree(LinkedList<String> nodes) {
        String head = nodes.remove();
        if(head.equals("null")) {
            return null;
        }
        Node tree = new Node(Integer.parseInt(head), null, null);
        tree.left = restoreTree(nodes);
        tree.right = restoreTree(nodes);
        return tree;
    }

    public Node restoreTreeArr(ArrayList<String> arr) {
        String head = arr.remove(0);
        if(head.equals("null")) {
            return null;
        }
        Node tree = new Node(Integer.parseInt(head), null, null);
        tree.left = restoreTreeArr(arr);
        tree.right = restoreTreeArr(arr);
        return tree;
    }

    public Node restore(ArrayList<String> array) {
        String cur = array.remove(0);
        System.out.println(cur);
        if(cur == "null") {
            return null;
        }
        Node curNode = new Node(Integer.parseInt(cur), null, null);
        curNode.left = restore(array);
        curNode.right = restore(array);
        return curNode;
    }

    public static void main(String[] args) {
        Serealize s = new Serealize();
        String str = "1,2,null,null,3,4,null,6,null,null,null";
        String[] arr = str.split(",");
        LinkedList<String> theList = new LinkedList<>(Arrays.asList(arr));
        Node root1 = s.restoreTree(theList);
        System.out.println(root1);

        ArrayList<String> array = new ArrayList<>();
        Collections.addAll(array, arr);
        Node root2 = s.restoreTreeArr(array);
        System.out.println(root2);

        String result = s.serealizeTree(root2);
        System.out.println(result);



        String result3 = (s.serialize(root1));
        String[] str3 = str.split(",");
        ArrayList<String> array3 = new ArrayList<>();
        Collections.addAll(array3, str3);
        Node root3 = s.restore((array3));
    }
}
