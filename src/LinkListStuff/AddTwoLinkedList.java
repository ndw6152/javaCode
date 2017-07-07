package LinkListStuff;

import java.util.Hashtable;

/**
 *
 * Created by Anonealio on 6/8/2017.
 */
public class AddTwoLinkedList{

    public void printNode(Node n) {

        while(n.next != null) {
            System.out.print(n.value + " > ");
            n = n.next;
        }
        System.out.print(n.value);
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

        findLongestLinkedlist(n1, y1); //total 1110  // creating new node

    }


    public void removeDuplicates(Node<Integer> head) {  // O(n) space O(n)

        Node<Integer> previous = head;
        Node<Integer> current = head.next;
        Hashtable<Integer, Integer> table = new Hashtable<>();

        table.put(previous.value, 1);

        while(current != null) {

            if(table.get(current.value) != null) { // it is a duplicate
                previous.next = current.next;
                current = current.next;
            }
            else {
                table.put(current.value, 1);
                previous = current;
                current = current.next;
            }
        }
    }

    public void removeDupNoExternalSpace(Node<Integer> head) { // O(n^2)

        Node<Integer> current = head;

        while(current != null) {
            Node prev = current;
            Node next = current.next;
            while(next != null) {
                if(next.value == current.value) {
                    prev.next = next.next;
                    next = next.next;
                }
                else {
                    prev = next;
                    next = next.next;
                }
            }
            current = current.next;
        }
    }


    public void testDuplicatesRemoval() {
        Node<Integer> b5 = new Node<>(1, null);
        Node<Integer> b4 = new Node<>(5, b5);
        Node<Integer> b3 = new Node<>(9, b4);
        Node<Integer> b2 = new Node<>(9, b3);
        Node<Integer> b1 = new Node<>(6, b2);  // 169951
        Node<Integer> b0 = new Node<>(1, b1);

        printNode(b0);
        removeDupNoExternalSpace(b0); //removeDuplicates(b0);
        System.out.println();
        printNode(b0);


        System.out.println();
        Node n3 = new Node<>(1, null);
        Node n2 = new Node<>(1, n3);
        Node n1 = new Node<>(1, n2);  // 111
        printNode(n1);
        removeDuplicates(n1);
        System.out.println();
        printNode(n1);
        System.out.println();

        Node y3 = new Node<>(3, null);
        Node y2 = new Node<>(2, y3);
        Node y1 = new Node<>(1, y2);  // 999
        printNode(y1);
        removeDuplicates(y1);
        System.out.println();
        printNode(y1);
    }


    public static void main(String[] args) {
        AddTwoLinkedList q1 = new AddTwoLinkedList();
        // q1.setUpNodes();

        q1.testDuplicatesRemoval();
    }
}
