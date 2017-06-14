package LinkListStuff;

/**
 *
 * Created by Anonealio on 6/8/2017.
 */
public class AddTwoLinkedList{

    public void printNode(Node n) {
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }


    public void findLongestLinkedlist(Node a, Node b) {
        int aCount = 0;
        int bCount = 0;
        Node headA = a;
        Node headB = b;
        while(a != null) {
            aCount++;
            a = a.next;
        }
        while(b != null) {
            bCount++;
            b = b.next;
        }

        if(aCount < bCount) {
            addTwoLinkedList(headA, headB);
        }
        else {
            addTwoLinkedList(headB, headA);
        }

    }

    public void addTwoLinkedList(Node a, Node b) {

        Node head = new Node<>(-1, null);
        Node start = head;
        int carry = 0;

        while(a != null) {

            int sum  = (Integer)a.value + (Integer)b.value;
            int total = sum%10 + carry;
            if(sum >= 10) {
                carry = 1;
            }
            else{
                carry = 0;
            }

            if(total > 9) {  // current sum and carry
                carry = 1;
            }

            head.next = new Node<>(total%10, null);
            head = head.next;

            a = a.next;
            b = b.next;
        }


        while(b != null) {
            int sum  = (Integer)carry + (Integer)b.value;
            int total = sum%10;
            if(sum >= 10) {
                carry = 1;
            }
            else {
                carry = 0;
            }

            head.next = new Node<>(total, null);
            head = head.next;
            b = b.next;
        }


        if(carry > 0) {
            head.next = new Node<>(carry, null);
            head = head.next;
        }

        printNode(start);
    }

    public void setUpNodes() {
        Node n3 = new Node<>(1, null);
        Node n2 = new Node<>(1, n3);
        Node n1 = new Node<>(1, n2);  // 111

        Node y3 = new Node<>(9, null);
        Node y2 = new Node<>(9, y3);
        Node y1 = new Node<>(9, y2);  // 999

        Node b4 = new Node<>(5, null);
        Node b3 = new Node<>(9, b4);
        Node b2 = new Node<>(9, b3);
        Node b1 = new Node<>(9, b2);  // 5999


        Node a2 = new Node<>(1, null);
        Node a1 = new Node<>(1, a2);  // 11




        findLongestLinkedlist(a1, b1); //total 6010
        System.out.println("-----");
        findLongestLinkedlist(n1, y1); //total 1110  // creating new node

    }

    public static void main(String[] args) {
        AddTwoLinkedList q1 = new AddTwoLinkedList();
        q1.setUpNodes();
    }
}
