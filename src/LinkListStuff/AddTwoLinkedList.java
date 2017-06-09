package LinkListStuff;

/**
 *
 * Created by Anonealio on 6/8/2017.
 */
public class AddTwoLinkedList {

    public void printNode(Node n) {
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public void addTwoLinkedList(Node a, Node b) {

        Node head = new Node(0, null);
        Node start = head;
        int carry = 0;

        while(a != null) {

            int temp  = a.value + b.value;
            int sum = temp%10 + carry;
            if(temp >= 10) {
                carry = 1;
            }
            else{
                carry = 0;
            }


            head.next = new Node(sum, null);
            head = head.next;

            a = a.next;
            b = b.next;
        }

        if(carry > 0) {
            head.next = new Node(carry, null);
            head = head.next;
        }

        printNode(start);
    }

    public void setUpNodes() {
        Node n3 = new Node(1, null);
        Node n2 = new Node(1, n3);
        Node n1 = new Node(1, n2);  // 111

        Node b3 = new Node(9, null);
        Node b2 = new Node(0, b3);
        Node a1 = new Node(9, b2);  // 909


        addTwoLinkedList(n1, a1);


    }

    public static void main(String[] args) {
        AddTwoLinkedList q1 = new AddTwoLinkedList();
        q1.setUpNodes();
    }
}
