package randomStuff;

import java.util.Hashtable;
class LRUCache {
    class Node {
        public int val;
        public int key;
        public Node prev;
        public Node next;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }


    public Node head;
    public Node tail;

    public Hashtable<Integer, Node> table;
    int capacity = 0;

    public LRUCache(int capacity) {
        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, null, null);
        head.next = tail;
        tail.prev = head;

        table = new Hashtable<>();
        this.capacity = capacity;
    }

    public Node insertAtEnd(int key, int val) {
        Node temp = new Node(key, val, null, null);

        temp.prev = tail.prev;
        tail.prev.next = temp;
        temp.next = tail;
        tail.prev = temp;
        return temp;
    }

    public void removeNode(Node node) {
        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;

    }


    public int get(int key) {
        if(table.containsKey(key)) {
            Node cur = table.get(key);
            // need to remove node, then add to end;
            removeNode(cur);
            insertAtEnd(cur.key, cur.val);

            return cur.val;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(table.containsKey(key)) {
            Node cur = table.get(key);
            // need to remove node, then add to end;
            removeNode(cur);
            Node insert = insertAtEnd(key, value);
            table.put(key, insert);
        }
        else {
            if(table.size() == capacity) {
                table.remove(head.next.key);
                removeNode(head.next);
            }
            // not full, just add new node
            Node insert = insertAtEnd(key, value);
            table.put(key, insert);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);

        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

}

