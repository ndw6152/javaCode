package randomStuff;

/**
 * Created by ndw6152 on 7/22/2018.
 */
class MyLinkedList {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.count = 0;
        this.tail = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < count) {
            Node cur = head;
            for(int i =0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
        else {
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null) {
            head = new Node(val);
            tail = head;
        }
        else {
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }
        count++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
        }
        else {
            Node prev = head;
            Node cur = head;

            while(cur != null) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = new Node(val);
        }
        count++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index >=0 && index <= count) {
            if(index == 0) {
                addAtHead(val);
            }
            else {
                Node prev = head;
                Node cur = head;

                for(int i = 0; i< index; i++) {
                    prev = cur;
                    cur = cur.next;
                }
                Node temp = new Node(val);
                prev.next = temp;
                temp.next = cur;
                count++;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >=0 && index < count) {
            if(index == 0) {
                head = head.next;
                count--;
            }
            else {
                Node prev = head;
                Node cur = head;

                for(int i = 0; i< index; i++) {
                    prev = cur;
                    cur = cur.next;
                }

                prev.next = cur.next;
                count--;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */