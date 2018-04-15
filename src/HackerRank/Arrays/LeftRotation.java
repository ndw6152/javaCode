package HackerRank.Arrays;

        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LeftRotation s = new LeftRotation();

        Queue<Integer> q = new LinkedList<>();

        int n = in.nextInt();
        int d = in.nextInt();

        for (int a_i = 0; a_i < n; a_i++) {
            q.add(in.nextInt());

        }

        for (int j = 0; j < d; j++) {
            int temp = q.poll();
            q.add(temp);
        }

        for (int i = 0; i < q.size(); i++) {
            System.out.print(q.poll() + (i != q.size() - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}