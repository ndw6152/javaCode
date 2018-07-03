package randomStuff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ndw6152 on 6/11/2018.
 */


class MyObject {
    String name;

    public MyObject(String name) {
        this.name = name;
    }
}


class Coord {
    int r, c;

    public Coord(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}

public class Roombot {

    int borderSize = 3;
    private HashSet<String> visited;

    private Coord goLeft(Coord pt) {
        Coord temp = new Coord(pt.r, pt.c-1);

        if(pt.c -1 < 0 || visited.contains(temp.toString())) {
            return null;
        }
        return temp;
    }
    private Coord goRight(Coord pt) {
        Coord temp = new Coord(pt.r, pt.c+1);
        if(pt.c + 1 > borderSize || visited.contains(temp.toString())) {
            return null;
        }
        return temp;
    }
    private Coord goTop(Coord pt) {
        Coord temp = new Coord(pt.r-1, pt.c);
        if(pt.r -1 < 0 || visited.contains(temp.toString())) {
            return null;
        }
        return temp;
    }
    private Coord goBottom(Coord pt) {
        Coord temp = new Coord(pt.r +1, pt.c);
        if(pt.r + 1 > borderSize || visited.contains(temp.toString())) {
            return null;
        }
        return temp;
    }


    // functions goes in all spaced in the bordder from the initial posisition
    // the path followed is printed and the backtracking steps are shown as well.
    public void visitAllSpaces(Coord loc) {
        visited = new HashSet<>();
        move(loc);
    }

    public void move(Coord loc) {

        System.out.print(loc.toString() + " ");
        visited.add(loc.toString());

        Coord temp = goLeft(loc);
        if(temp != null) {
            move(temp);
            System.out.println();
            System.out.print(loc.toString());
        }
        temp = goRight(loc);
        if(temp != null) {
            move(temp);
            System.out.println();
            System.out.print(loc.toString());
        }
        temp = goTop(loc);
        if(temp != null) {
            move(temp);
            System.out.println();
            System.out.print(loc.toString());
        }
        temp = goBottom(loc);
        if(temp != null) {
            move(temp);
            System.out.println();
            System.out.print(loc.toString());
        }

    }



    public static void main(String[] args) {
        Roombot q = new Roombot();

        q.visitAllSpaces(new Coord(2,2));
    }
}
