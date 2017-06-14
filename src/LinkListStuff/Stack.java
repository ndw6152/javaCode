package LinkListStuff;

/**
 * Created by Anonealio on 6/12/2017.
 */
public class Stack {


    private Node head;

    public Stack(Node n) {
        head = n;
    }

    public void push(Node n) {
        if(head == null) {
            head = n;
            head.next = null;
        }
        else {
            n.next = head;
            head = n;
        }
    }

    public int pop() {
        if(head == null) {
            return -1;
        }
        else {
            int val = head.value;
            head = head.next;
            return val;
        }
    }

    public void printStack() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

        System.out.println("head: " + head.value);
    }

    public static void main(String[] args) {
        Stack s = new Stack(new Node(1, null));
        s.push(new Node(2, null));
        s.push(new Node(3, null));
        s.push(new Node(4, null));
        s.push(new Node(5, null));
        s.push(new Node(6, null));
        s.printStack();

        System.out.println(s.pop());

        s.printStack();

        System.out.println(s.pop());
        System.out.println(s.pop());
        s.printStack();

        s.push(new Node(100, null));
        s.push(new Node(9000, null));

        s.printStack();
        s.pop(); s.pop(); s.pop(); s.pop(); System.out.println(s.pop());

        System.out.println(s.pop());  // nothing left in stack();

        s.push(new Node(999, null));
        s.push(new Node(1000, null));
        s.printStack();
    }
}
