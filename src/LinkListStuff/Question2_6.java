package LinkListStuff;

import java.util.ArrayList;

/**
 * Created by Anonealio on 7/15/2017.
 *
 // what is the type of the content of the node
 // palindrome: racecar
 // every character has even number or every char even except one is odd
 // is it a singly linkedlist?
 */




public class Question2_6 {

    //if doubly linkedlist
//    public boolean checkIfPalindromeLinkedListDoubly(Node head) {
//
//        if(head == null){
//            return false;
//        }
//        Node start = head;
//        Node end = head.next;
//        int size = 1;
//        while(end != null) {
//            end = end.next;
//            size++;
//        }
//
//        for(int i = 0; i < size/2; i++) {
//            if(start.value != end.value) {
//                return false;
//            }
//            start = start.next;
//            end = end.prev;
//        }
//        return true;
//    }

    // if singly
    public boolean checkIfPalindromeLinkedListSingly(Node head) {
        Node<Character> start = head;
        ArrayList<Character> arr = new ArrayList<>();
        while(start != null) {
            arr.add(start.value);
            start = start.next;
        }
        int size = arr.size();

        for(int i =0; i<size/2; i++) {
            if(arr.get(i) != arr.get(arr.size()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node<>('r', new Node<>('a', new Node<>('c', new Node<>('e', new Node<>('c', new Node<>('a', new Node<>('r', null)))))));
        Node n2 = new Node<>('r', new Node<>('r', new Node<>('c', new Node<>('e', new Node<>('c', new Node<>('a', new Node<>('r', null)))))));
        Node n3 = new Node<>('r', new Node<>('a', new Node<>('c', new Node<>('c', new Node<>('a', new Node<>('r', null))))));

        Node n4 = new Node<>("A", null);
        Node n5 = new Node<>('r', new Node<>('a', new Node<>('c', new Node<>('c', new Node<>('r', null)))));


        Question2_6 q = new Question2_6();
        System.out.println(q.checkIfPalindromeLinkedListSingly(n1)); //racecar
        System.out.println(q.checkIfPalindromeLinkedListSingly(n3)); //raccar
        System.out.println(q.checkIfPalindromeLinkedListSingly(n4)); //A
        System.out.println(q.checkIfPalindromeLinkedListSingly(new Node<Character>(' ', null))); //rrcecar
        System.out.println(q.checkIfPalindromeLinkedListSingly(n2)); //rrcecar
        System.out.println(q.checkIfPalindromeLinkedListSingly(n5)); // raccr


        System.out.println("----");
        Node<Integer> nt = new Node("199", null);
        Node test = nt;
        Node test2 = nt;
        Node test3 = new Node("199", null);
        System.out.println(test == test2);
        System.out.println(test == test3);



    }
}