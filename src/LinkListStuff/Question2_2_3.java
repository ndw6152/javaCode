package LinkListStuff;

/**
 * Created by Anonealio on 7/11/2017.
 */
public class Question2_2_3 {
    public void printNode(Node n) {

        if(n == null) {
            return;
        }

        while(n.next != null) {
            System.out.print(n.value + " > ");
            n = n.next;
        }
        System.out.print(n.value);
        System.out.println();
    }

    // return the kth to last element of a singly linkedlist.
    //
    // what is the value of the linkedlist
    // what is the parameter of the function
    // what type should the function return
    //
    // should we do check to see if it is cyclic? i.e a node point to another node inside the linkedlist
    //
    // if n = 10 and k =3 then it is the element is index 7, 8th element

    public Node findKthToLastElement(Node<Integer> start, int k) {
        Node<Integer> current = start;
        Node<Integer> end = start;

        for(int i =0; i<k; i++) {
            if(end == null)
                return null;
            end = end.next;
        }

        while(end != null) {
            end = end.next;
            current = current.next;
        }

        return current;
    }

    public void print(Node n) {

        if(n != null) {

            System.out.println(n.value);
            System.out.println();
        }
        else{
            System.out.println("null");
            System.out.println();
        }
    }

    // question 2_3
    // it is a singly linkedlist
    // what are the parameters of the function?
    // what is returned? (null)
    public void deleteNode(Node node) {
        if(node == null) {
            return;
        }

        if(node.next == null) {
            node.value = null;
            node = null;
        }
        else{
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }



    public static void main(String[] args) {
        Question2_2_3 q = new Question2_2_3();
        Node<Integer> n10 = new Node<>(10, null);
        Node<Integer> n2 = new Node<>(6, new Node<>(7, new Node<>(8, new Node<>(9, n10))));
        Node<Integer> n1 = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, n2)))));
        Node result = q.findKthToLastElement(n1, 5);
        q.print(result);

        result = q.findKthToLastElement(n1, 100);
        q.print(result);
        result = q.findKthToLastElement(n1, 1);
        q.print(result);
        result = q.findKthToLastElement(n1, 10);
        q.print(result);

        q.printNode(n1);
        q.deleteNode(n2);
        q.printNode(n1);
        System.out.println();

        q.printNode(n1);
        q.deleteNode(n10);
        q.printNode(n1);

    }
}
