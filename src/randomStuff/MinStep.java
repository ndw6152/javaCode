package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 6/7/2018.
 */

class Point {
    public int r;
    public int c;

    public Point(int x, int y) {
        this.r = x;
        this.c = y;
    }

    public String toString() {
        return "(" + r + "," + c +")";
    }
}


public class MinStep {

    // where a.c < b.c
    public int findMinPath(Point a, Point b) {
        int row = Math.abs(b.r - a.r) + 1;
        int col = Math.abs(b.c - a.c) + 1;

        int steps1 = Math.min(row, col) -1;
        //System.out.println("row " + row + "  col " + col + "  step1 = " + steps1);

        int diff = Math.abs(row - col);
        //System.out.println("diff " + diff);

        //System.out.println( Math.abs(steps1 + diff));
        return Math.abs(steps1 + diff);
    }


    public int coverPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size() <= 1 || b.size() <= 1 || b.size() != a.size()) {
            return 0;
        }

        int sumPath = 0;
        for(int i = 1; i<a.size(); i++) {
            sumPath += findMinPath(new Point(a.get(i),b.get(i)), new Point(a.get(i-1),b.get(i-1)));
        }

        return sumPath;
    }


    public static void main(String[] args) {
        MinStep s = new MinStep();

//        Point a = new Point(3, -4);
//        Point b = new Point(-2, 2 );
//        s.findMinPath(a, b);
//        s.findMinPath(b, a);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3); a.add(-2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(-4); b.add(2);

        System.out.println(s.coverPoints(a, b));

    }
}
