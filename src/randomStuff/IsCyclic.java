package randomStuff;

import LinkListStuff.Node;

/**
 * Created by ndw6152 on 6/28/2018.
 */
public class IsCyclic {

    public Boolean isCyclic(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return true;
            }
        }

        return false;
    }



}
