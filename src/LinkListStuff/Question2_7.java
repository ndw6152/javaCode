package LinkListStuff;

import java.util.Hashtable;

/**
 * Created by Anonealio on 7/15/2017.
 */
public class Question2_7 {

    public Hashtable<Node, Integer> createTable(Node n) {
        Hashtable<Node, Integer> table = new Hashtable<>();
        while(n != null) {
            table.put(n, 1);
            n = n.next;
        }
        return table;
    }

    public Node<Integer> isIntersection(Node<Integer> n1, Node<Integer> n2) {  // O(n) Space: O(n)
        Hashtable<Node, Integer> table = createTable(n1);

        Node<Integer> start = n2;
        while(start != null) {
            if(table.get(start) != null) {
                return start;
            }
            start = start.next;
        }
        return null;
    }


    public int getSize(Node n1) {
        int count = 0;
        while(n1 != null) {
            count++;
            n1 = n1.next;
        }
        return count;
    }

    public Node<Integer> checkIfIntersection(Node<Integer> n1, Node<Integer> n2) {
        //n1 and n2 same size;
        while(n1 != null) {
            if(n1 == n2){
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }

    public Node<Integer> isIntersectionNoExSpace(Node<Integer> n1, Node<Integer> n2){  // O(n) space: O(1)
        // find larger linkedlist and discount extra nodes, then start comparing one by one.

        int size1 = getSize(n1);
        int size2 = getSize(n2);

        Node startN1 = n1;
        Node startN2 = n2;

        Node<Integer> result = null;

        if(size1 > size2) {
            int loop = size1 -size2;
            for(int i=0; i<loop; i++) {
                startN1 = startN1.next;
            }
        }
        else{
            int loop = size2 -size1;
            for(int i=0; i<loop; i++) {
                startN2 = startN2.next;
            }
        }
        result = checkIfIntersection(startN1, startN2);
        return result;
    }




    public void printIntersect(Node result) {
        if(result != null){
            System.out.println(result.value);
        }
        else {
            System.out.println("No intersections");
        }
    }

    public static void main(String[] args) {
        Question2_7 q = new Question2_7();

        Node<Integer> n = new Node<Integer>(100, new Node<Integer>(4, new Node<Integer>(5, null)));
        Node<Integer> n1 = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, n)));
        Node<Integer> n2= new Node<Integer>(500, n1);
        Node<Integer> n3 = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, null)));

        q.printIntersect(q.isIntersection(n, n1));
        q.printIntersect(q.isIntersection(n, n2));
        q.printIntersect(q.isIntersection(n1, n2));

        q.printIntersect(q.isIntersection(n1, n3));
        q.printIntersect(q.isIntersection(n, n3));

        System.out.println("-------------------");
        q.printIntersect(q.isIntersectionNoExSpace(n, n1));
        q.printIntersect(q.isIntersectionNoExSpace(n, n2));
        q.printIntersect(q.isIntersectionNoExSpace(n1, n2));

        q.printIntersect(q.isIntersectionNoExSpace(n1, n3));
        q.printIntersect(q.isIntersectionNoExSpace(n, n3));

    }

}