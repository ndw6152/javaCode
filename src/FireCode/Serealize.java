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
        if(cur.equals("null")) {
            return null;
        }
        Node curNode = new Node(Integer.parseInt(cur), null, null);
        curNode.left = restore(array);
        curNode.right = restore(array);
        return curNode;
    }


    // str = 1,2,3 or 1,*,2,*,*,3,4  it is always balanced
    // make a string[] from string
    // loop through array
    // push each new node into the queue
    // when popping, assign left and right if they exist move index by 2
    public Node decompressTree(String str){
        if(str.length() < 1) {
            return null;
        }
        if(str.length() == 1 && str.equals("*")) {
            return null;
        }

        String[] arr = str.split(",");

        Node head = new Node(Integer.parseInt(arr[0]), null, null);
        Node cur = head;
        Queue<Node> q = new LinkedList<>();
        q.add(cur);

        for(int i =1; i < arr.length;) {
            cur = q.poll();

            if(cur != null) {
                Node left = (arr[i]).equals("*") ? null: new Node(Integer.parseInt(arr[i]), null, null);
                cur.left = left;
                q.add(left);

                Node right = (arr[i+1]).equals("*") ? null :new Node(Integer.parseInt(arr[i+1]), null, null);
                cur.right = right;
                q.add(right);
            }
            i+=2;
        }
        return head;
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


        int[] arr2 = {1,2,3,4,5,6};

    }
}
