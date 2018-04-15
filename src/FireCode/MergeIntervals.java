package FireCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {

    public ArrayList<Interval> mergeIntervals(ArrayList<Interval> array) {
        ArrayList<Interval> result = new ArrayList<>();
        if (array.size() <= 0) {
            return result;
        }
        int start = array.get(0).start;
        int end = array.get(0).end;

        Interval current;
        int first;
        int second;

        for (int i = 1; i < array.size(); i++) {
            current = array.get(i);
            first = current.start;
            second = current.end;

            if (first < start) {
                result.add(new Interval(start, end));
                start = first;
                end = second;
            } else {
                if (first <= end) { // merge
                    end = Math.max(end, second);
                } else {
                    result.add(new Interval(start, end));
                    start = first;
                    end = second;
                }
            }
        }
        result.add(new Interval(start, end));

        result.sort(new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                //ascending order
                return Integer.compare(int1.start, int2.start);
            }
        });

        return result;
    }


    public ArrayList<Interval> mergeIntervalsBetter(ArrayList<Interval> array) {
        ArrayList<Interval> result = new ArrayList<>();
        if (array.size() < 2) {
            return array;
        }
        array.sort(new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                //ascending order
                return Integer.compare(int1.start, int2.start);
            }
        });

        int start = array.get(0).start;
        int end = array.get(0).end;

        Interval cur;
        for(int i = 1; i < array.size(); i++) {
            cur = array.get(i);
            if(cur.start <= end) { // merge
                end = Math.max(end, cur.end);
            }
            else {
                result.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        result.add(new Interval(start, end));

        return result;
    }

    public void print(ArrayList<Interval> array) {
        for( Interval section: array) {
            System.out.println(section.start + " " + section.end);
        }
    }

    public static void main(String[] args) {
        MergeIntervals q = new MergeIntervals();

        ArrayList<Interval> array = new ArrayList<>();
        array.add(new Interval(1,3));array.add(new Interval(2,5));
        ArrayList<Interval> result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(1,5));array.add(new Interval(2,4));
        result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(2,5));array.add(new Interval(1,4));
        result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(1,3));array.add(new Interval(5,8));
        result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(1,7));array.add(new Interval(5,8));
        result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(1,5));array.add(new Interval(3,8));array.add(new Interval(3,12));
        result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(3,5));array.add(new Interval(2,8));
        result = q.mergeIntervalsBetter(array);
        q.print(result);

        System.out.println("----------------");
        array = new ArrayList<>();
        array.add(new Interval(1,5));array.add(new Interval(1,5));array.add(new Interval(1,5));
        result = q.mergeIntervalsBetter(array);
        result.sort(new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                //ascending order
                return Integer.compare(int1.start, int2.start);
            }
        });
        q.print(result);
    }
}
