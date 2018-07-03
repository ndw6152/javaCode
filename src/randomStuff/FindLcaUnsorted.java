package randomStuff;

import BinaryTree.Btree;
import BinaryTree.Node;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 6/10/2018.
 */
public class FindLcaUnsorted {

    public void findPath(Node root, int val, ArrayList<Node> result, ArrayList<Node> curPath) {

        if(root == null || result.size() != 0) {
            return;
        }
        curPath.add(root);

        if(root.value == val) {
            result.addAll(curPath);
        }

        findPath(root.left, val, result, curPath);
        findPath(root.right, val, result, curPath);
        curPath.remove(curPath.size()-1);
    }

    public int findLcaNotSorted(Node root, int val1, int val2) {
        ArrayList<Node> path1 = new ArrayList<>();
        findPath(root, val1, path1, new ArrayList<>());

        ArrayList<Node> path2 = new ArrayList<>();
        findPath(root, val2, path2, new ArrayList<>());

        if(path1.isEmpty() || path2.isEmpty()) {
            return -1;
        }
        int size = Math.min(path1.size(), path2.size());

        int result = -1;
        for(int i = 0; i <size; i++) {
            if(path1.get(i) == path2.get(i)) {
                result = path1.get(i).value;
            }
            else {
                break;
            }
        }
        return result;
    }

    public int findLca(Node root, int val1, int val2) {
        if(val1 > val2) {
            int temp = val2;
            val2 = val1;
            val1 = temp;
        }

        if(root == null) {
            return -1;
        }
        if(val1 <= root.value && val2 >= root.value) {
            return root.value;
        }
        else if(val1 <= root.value && val2 <= root.value) {
            return findLca(root.left, val1, val2);
        }
        else if(val1 >= root.value && val2 >= root.value) {
            return findLca(root.right, val1, val2);
        }
        else {
            return -1;
        }

    }




    public static void main(String[] args) {
        FindLcaUnsorted q = new FindLcaUnsorted();

        Node _25 = new Node(25, null, new Node(45, null, null));
        Node _75 = new Node(75, new Node(65, null, null), new Node(90, null, null));
        Node _50 = new Node(50, _25, _75);
        Node _200 = new Node(200, null, null);
        Node root = new Node(100, _50, _200);
        Btree tree = new Btree(root);

        System.out.println(q.findLcaNotSorted(tree.getRoot(), 90, 65));
        System.out.println(q.findLca(tree.getRoot(), 90, 65));

        System.out.println(q.findLcaNotSorted(tree.getRoot(), 100, 200));
        System.out.println(q.findLca(tree.getRoot(), 100, 200));

        System.out.println(q.findLcaNotSorted(tree.getRoot(), 65, 65));
        System.out.println(q.findLca(tree.getRoot(), 65, 65));

        System.out.println(q.findLcaNotSorted(tree.getRoot(), 25, 65));
        System.out.println(q.findLca(tree.getRoot(), 65, 25));
    }

}
