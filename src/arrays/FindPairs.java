package arrays;

import FindAngle.FindAngle;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Anonealio on 6/22/2017.
 */
public class FindPairs {

    public FindPairs() {

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

    public static void main(String[] args) {

        FindPairs p = new FindPairs();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(7);arr.add(5);arr.add(6);arr.add(3); arr.add(12);arr.add(9);
        p.getPairs(arr, 2); // expected 1,3 5,7
    }



}