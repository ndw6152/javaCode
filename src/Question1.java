/**
 *
 * Created by Anonealio on 6/5/2017.
 */


public class Question1 {


    public void printNode(Node n) {
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public Node reverse(Node start) {
        Node prev = null;
        while(start != null) {
            Node next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }

        return prev;
    }

    public void runReverse() {

        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        Node n0 = new Node(0, n1);

        Node newHead = reverse(n0);
        printNode(newHead);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        Question1 program = new Question1();
        program.runReverse();


    }
}
