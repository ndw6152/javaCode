package LinkListStuff;

/**
 * Created by Anonealio on 7/15/2017.
 */
public class Util {

    public static void printNode(Node n) {

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

}
