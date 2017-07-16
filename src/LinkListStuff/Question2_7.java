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

    public Node<Integer> isIntersection(Node<Integer> n1, Node<Integer> n2) {
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

    }

}