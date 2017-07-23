package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anonealio on 7/23/2017.
 */
public class Question4_3 {

    public ArrayList<ArrayList<LinkListStuff.Node> > createLevelsList(Node root) {
        if(root == null) {
            return null;
        }
        ArrayList< ArrayList<LinkListStuff.Node> > arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            ArrayList<LinkListStuff.Node> levelList = new ArrayList<>();

            while(!q.isEmpty()) {
                Node current = q.poll();
                if(current != null) {

                    q2.add(current.left);
                    q2.add(current.right);
                    levelList.add(new LinkListStuff.Node(current.value, null));
                    System.out.print(current.value + " ");
                }

            }
            q = q2;
            q2 = new LinkedList<>();
            arr.add(levelList);
            System.out.println();
        }
        return arr;
    }

    public void printLinkedListInArr(ArrayList<ArrayList<LinkListStuff.Node>> arr) {
        for(int i = 0; i < arr.size(); i++) {

            for(LinkListStuff.Node n : arr.get(i)) {
                if(n != null) {
                    System.out.print(n.value + " ");
                    n = n.next;
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Question4_3 q = new Question4_3();

        Btree b = new Btree();
        b.insert(6);b.insert(1);b.insert(3);b.insert(115);b.insert(150);b.insert(200);b.insert(2);b.insert(5);
        b.levelTraversal();
        ArrayList<ArrayList<LinkListStuff.Node>> arr = q.createLevelsList(b.getRoot());
        System.out.println();
        q.printLinkedListInArr(arr);

    }

}