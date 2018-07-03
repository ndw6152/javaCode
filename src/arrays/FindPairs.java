package arrays;

import FindAngle.FindAngle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

/**
 * Created by Anonealio on 6/22/2017.
 */
public class FindPairs {

    public FindPairs() {
    }

    private static int compare(Pairs lhs, Pairs rhs) {
        return Integer.compare(lhs.x, rhs.x);
    }

    public class Pairs {
        private int x, y;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return  x + " " + y;
        }
    }


    public void getPairs(ArrayList<Integer> arr, int diff) {

        Hashtable<Integer, Integer> table = new Hashtable<>();
        ArrayList<Pairs> result = new ArrayList<>();
        for(int i=0; i < arr.size(); i++) {
            int current = arr.get(i);

            if(table.containsKey(current)) {
                Pairs p = new Pairs(current, table.get(current));
                result.add(p);
            }
            else {
                table.put(current + diff, current);
                table.put(current - diff, current);
            }
        }

        for( Pairs value : result ) {
            System.out.println(value.toString());
        }
    }

    public void sortSomeArraysCompact() {
        ArrayList<Pairs> arr = new ArrayList<>();
        Collections.sort(arr, // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                FindPairs::compare);
    }

    public ArrayList sortSomeArrays() {
        ArrayList<Pairs> arr = new ArrayList<>();
        arr.sort(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs lhs, Pairs rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.x < rhs.x ? -1 : (lhs.x > rhs.x) ? 1 : 0;
            }
        });
        return arr;
    }

    public static void main(String[] args) {

        FindPairs p = new FindPairs();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(7);arr.add(5);arr.add(6);arr.add(3); arr.add(12);arr.add(9);
        p.getPairs(arr, 2); // expected 1,3 5,7
    }
}