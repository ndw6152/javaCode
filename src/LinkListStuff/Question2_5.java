package LinkListStuff;

/**
 * Created by Anonealio on 7/15/2017.
 */
public class Question2_5 {

    private int mMultiplier = 0;

    public int getIntValue(Node start) {
        Node current = start;
        int multiplier = 1;
        int result = 0;
        while(current != null) {
            result += (Integer)current.value * multiplier;
            multiplier = multiplier * 10;
            current = current.next;

        }
        if(multiplier > mMultiplier) {
            mMultiplier = multiplier;
        }
        return result;
    }

    public Node createNodeOutOfInt(int value) {  // 912 // mMultiplier = 100
        int multiplier = mMultiplier *10;
        Node<Integer> head = null;

        while(multiplier >= 1) {
            int temp = value/multiplier;


            if(temp >0) {
                if(head == null){
                    head = new Node<>(temp, null);
                }
                else{
                    Node<Integer> tmp = new Node<>(temp, head);
                    head = tmp;
                }

                value = value%multiplier;
                multiplier = multiplier/10;

            }
            else{ // temp = 0
                if(head != null) {
                    Node<Integer> tmp = new Node<>(temp, head);
                    head = tmp;

                    value = value % multiplier;
                    multiplier = multiplier / 10;
                }
                else{
                    multiplier = multiplier/10;
                }

            }
        }
        return head;


    }

    public int getIntValueInOder(Node start) {
        Node current = start;
        int result = 0;
        int multiplier = 1;
        while(current != null){
            if(result == 0) {
                result += (Integer)current.value;
            }
            else{
                result = result*10;
                result += (Integer)current.value;
            }
            current = current.next;

        }
        System.out.println(result);
        return result;
    }

    public Node createNodeFromInt(int value) {
        int multiplier = 1;
        int result = value;
        while(result > 1) {
            result = value/multiplier;
            multiplier = multiplier*10;
        }

        Node head = null;
        Node end = null;

        while(multiplier >= 1) {
            int temp = value/multiplier;
            if(temp >0) {
                if(head == null){
                    head = new Node(temp, null);
                    end = head;
                }
                else{
                    Node tmp = new Node(temp, null);
                    end.next = tmp;
                    end = tmp;
                }

                value = value%multiplier;
                multiplier = multiplier/10;

            }
            else{
                multiplier = multiplier/10;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        Question2_5 q = new Question2_5();

        Node<Integer> n1 = new Node<>(0, new Node<>(0, new Node<>(9, null)));
        Node<Integer> n2 = new Node<>(0, new Node<>(0, new Node<>(2, null)));

        int val1 = q.getIntValue(n1);
        int val2 = q.getIntValue(n2);

        System.out.println(val1+val2);

        Node start = q.createNodeOutOfInt(val1+val2);
        Util.printNode(start);


        System.out.println("------");

        Node<Integer> b1 = new Node<>(9, new Node<>(0, new Node<>(0, null)));
        Node<Integer> b2 = new Node<>(4, new Node<>(0, new Node<>(2, null)));
        System.out.println(q.getIntValueInOder(b1) + q.getIntValueInOder(b2));
        Util.printNode(q.createNodeFromInt(912));


        Util.printNode(q.createNodeFromInt(12345));


    }
}