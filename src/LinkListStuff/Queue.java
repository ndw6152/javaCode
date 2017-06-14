package LinkListStuff;

/**
 * Created by Anonealio on 6/13/2017.
 */
public class Queue<T>{


    private Node head;
    private Node tail;


    public Queue() {

    }

    public void push(T n) {
        if(head == null && tail == null) {
            head = new Node<>(n, null);
            tail = head;
            head.next = null;
        }
        else {
            tail.next = new Node<>(n, null);
            tail = tail.next;
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


    public Node getTail() {
        return tail;
    }




    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.printQueue();

        q.pop();
        q.pop();

        q.printQueue();
        q.push(1000);
        q.pop();
        q.pop();
        q.printQueue();


    }



}