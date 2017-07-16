package LinkListStuff;

/**
 * Created by Anonealio on 7/11/2017.
 */
public class Question2_4 {

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


    public Node partitionLinkedList(Node<Integer> head, int x) {  //O(n) space O(n)
        Node headLess = null;
        Node headMore = null;
        Node currentLess = null;
        Node currentMore = null;

        while(head != null) {
            if(head.value < x) {
                if(headLess == null) {
                    Node temp = new Node<>(head.value, null);
                    headLess = temp;
                    currentLess = headLess;
                }
                else{
                    currentLess.next = new Node<>(head.value, null);
                    currentLess = currentLess.next;
                }
            }
            else{
                if(headMore == null) {
                    headMore = new Node<>(head.value, null);
                    currentMore = headMore;
                }
                else {
                    currentMore.next = new Node<>(head.value, null);
                    currentMore = currentMore.next;
                }
            }
            head = head.next;
        }
        if(currentLess != null) {
            currentLess.next = headMore;
        }

        if(headLess != null) {
            return headLess;
        }
        else{
            return headMore;
        }

    }


    public void swap(Node<Integer> current, int x) {
        Node<Integer> start = current;
        Node<Integer> next = current.next;
        while(next != null) {
            if(next.value < x) {
                int temp = current.value;
                current.value = next.value;
                next.value = temp;
                break;
            }
            next = next.next;
        }

    }

    public Node partitionLLinPlace(Node<Integer> start, int x) {  // O(n^2) space O(1)
        Node<Integer> head = start;
        Node<Integer> current = head;

        while(current != null) {

            if(current.value >= x) {
                swap(current, x);
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Question2_4 q = new Question2_4();

        Node<Integer> n1 = new Node<>(3, new Node<>(5, new Node<>(8, new Node<>(5, new Node<>(10, new Node<>(2, new Node<>(1, null)))))));
        q.printNode(n1);
        Node result = q.partitionLLinPlace(n1, 5);
        q.printNode(result);
        System.out.println();

        Node<Integer> nb = new Node<>(26, new Node<>(5, new Node<>(8, null)));
        q.printNode(nb);
        result = q.partitionLLinPlace(nb, 100);
        q.printNode(result);
        System.out.println();

        Node<Integer> nc = new Node<>(26, new Node<>(5, new Node<>(8, new Node<>(2, null))));
        q.printNode(nc);
        result = q.partitionLLinPlace(nc, 3);
        q.printNode(result);
        System.out.println();

        Node<Integer> nNull = null;
        q.printNode(nNull);
        result = q.partitionLLinPlace(nNull, 3);
        q.printNode(result);
        System.out.println();

        System.out.println("---------------");
        Node<Integer> n2 = new Node<>(3, new Node<>(5, new Node<>(8, new Node<>(5, new Node<>(10, new Node<>(2, new Node<>(1, null)))))));
        q.printNode(n2);
        result = q.partitionLinkedList(n2, 5);
        q.printNode(result);

    }
}
