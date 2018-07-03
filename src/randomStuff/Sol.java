package randomStuff;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by ndw6152 on 6/13/2018.
 */
public class Sol {
//    HashSet<Integer> set;
//    int[] prevMin;
//
//    public int getSumOfPrevMin(int n) {
//        int min = Integer.MAX_VALUE;
//
//        for(Integer key: set) {
//            if(key <= n) {
//                int temp = prevMin[n - key] + prevMin[key];
//                if (temp < min) {
//                    min = temp;
//                }
//            }
//        }
//        return min;
//    }
//
//    public int findMinSquares(int n) {
//        for (int i=1; i < n+1; i++) {
//            if (set.contains(i)) {
//                prevMin[i] = 1;
//            }
//            else {
//                prevMin[i] = getSumOfPrevMin(i);
//            }
//        }
//        return prevMin[n];
//    }
//
//
//    public int numSquares(int n) {
//        if(n <= 0) {
//            return 0;
//        }
//        set = new HashSet<>();
//        prevMin = new int[n+1];
//
//        for(int i =1; i<= Math.sqrt(n); i++) {
//            set.add(i*i);
//        }
//
//        return findMinSquares(n);
//    }

    HashSet<Integer> perfectSquaresSet;
    Hashtable<Integer, Integer> minTable;

    public void initTables(int n) {
        perfectSquaresSet = new HashSet<>();
        minTable = new Hashtable<>();

        for(int i =1; i<= Math.sqrt(n); i++) {
            perfectSquaresSet.add(i*i);
            minTable.put(i*i, 1);
        }
    }

    public int findMinSoFar(int n) {
        if(minTable.containsKey(n)) {
            return minTable.get(n);
        }

        int min = Integer.MAX_VALUE;
        for(Integer keys : perfectSquaresSet) {
            if(keys > n) {
                continue;
            }
            int temp = findMinSoFar(n-keys) + findMinSoFar(keys);
            if(temp < min) {
                min = temp;


            }
        }
        minTable.put(n, min);
        return min;
    }

    public int numSquares(int n) {
        if(n <=0) {
            return 0;
        }
        initTables(n);

        if(minTable.containsKey(n)) {
            return minTable.get(n);
        }
        else {
            for(int i = 1; i<=n ;i++) {
                findMinSoFar(i);
            }
        }
        return minTable.get(n);
    }

    public static void main(String[] args) {
        Sol s = new Sol();
        System.out.println(s.numSquares(12));

    }
}