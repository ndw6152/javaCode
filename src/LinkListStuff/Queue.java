package LinkListStuff;

/**
 * Created by Anonealio on 6/13/2017.
 */
public class Queue {


    private Node head;
    private Node tail;


    public Queue() {

    }

    public void push(Node n) {
        if(head == null) {
            head = n;
            head.next = null;
        }
        if(tail == null) {
            tail = n;
            tail.next = null;
        }
        else {
            tail.next = n;
            tail = n;
            tail.next = null;
        }
    }

    public Node pop() {
        if(head == tail) {
            tail = null;
        }
        if(head == null) {
            return null;
        }
        else{
            Node temp = head;
            head = head.next;
            return temp;
        }
    }

    public void printQueue() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;

        }
        System.out.println();
    }





    public static void main(String[] args) {
        Queue q = new Queue();

        q.push(new Node<>(1, null));
        q.push(new Node<>(2, null));
        q.push(new Node<>(3, null));
        q.push(new Node<>(4, null));

        q.printQueue();

        q.pop();
        q.pop();
        q.printQueue();
        q.pop();
        q.pop();
        q.printQueue();


    }



}