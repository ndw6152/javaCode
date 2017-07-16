package LinkListStuff;

/**
 * Created by Anonealio on 6/12/2017.
 */
public class Stack<T>{


    private Node<T> top;

    public Stack() {}
    public Stack(Node n) {
        top = n;
    }


    public void push(T val) {
        Node<T> n = new Node<>(val, null);
        n.next = top;
        top = n;
    }

    public void push(Node n) {
        if(top == null) {
            top = n;
            top.next = null;
        }
        else {
            n.next = top;
            top = n;
        }
    }

    public T pop() {
        if(top == null) {
            return null;
        }
        else {
            T val = top.value;
            top = top.next;
            return val;
        }
    }

    public T peek() {
        if(top == null) {
            return null;
        }
        else {
            return top.value;
        }
    }

    public void printStack() {
        Node temp = top;

        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack(new Node<Integer>(1, null));
        s.push(new Node<Integer>(2, null));
        s.push(new Node<Integer>(3, null));
        s.push(new Node<Integer>(4, null));
        s.push(new Node<Integer>(5, null));
        s.push(new Node<Integer>(6, null));
        s.printStack();

        System.out.println("pop: " + s.pop());

        s.printStack();

        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        s.printStack();

        s.push(new Node<Integer>(100, null));
        s.push(new Node<Integer>(9000, null));

        s.printStack();
        s.pop(); s.pop(); s.pop(); s.pop();
        System.out.println("removed 9000 100 3 2");
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());  // nothing left in stack();

        s.push(new Node<Integer>(999, null));
        s.push(new Node<Integer>(1000, null));
        s.printStack();

        System.out.println("-----------------");
        Stack<Integer> s2 = new Stack<Integer>();
        s2.push(1);s2.push(2);s2.push(3);s2.push(4);s2.push(5);s2.push(6);
        s2.printStack();

        System.out.println("pop: " + s2.pop());

        s2.printStack();

        System.out.println("pop: " + s2.pop());
        System.out.println("pop: " + s2.pop());
        s2.printStack();

        s2.push(100);
        s2.push(9000);

        s2.printStack();
        s2.pop(); s2.pop(); s2.pop(); s2.pop();
        System.out.println("removed 9000 100 3 2");
        System.out.println("pop: " + s2.pop());
        System.out.println("pop: " + s2.pop());  // nothing left in stack();

        s2.push(999);
        s2.push(1000);
        s2.printStack();
        System.out.println(s2.peek());

    }
}
