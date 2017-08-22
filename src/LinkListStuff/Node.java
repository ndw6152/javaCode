package LinkListStuff;

/**
 *
 * Created by Anonealio on 6/5/2017.
 */
public class Node<T> {

    public T value;
    public Node next;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

}