package bitManipulation;

/**
 * Created by Anonealio on 7/28/2017.
 */
public class Question5_1 {

    public void replaceDigitsAt(int N, int M, int j, int i) {
        int mask = 1;
        for(int k = 0; k <(j-i); k++) {
            mask |= mask<<1; // j-i 1s;
        }
        for(int a = 0; a <i; a++) {
            mask = mask<<1; // adding i 0s;
            M = M<<1;
        }
        System.out.println(Integer.toBinaryString(mask));
        mask = ~mask;

        int result = N & mask; // clearing j to i bits;
        System.out.println(Integer.toBinaryString(result));

        result = N | M;
        System.out.println(Integer.toBinaryString(result));

    }

    public static void main(String[] args) {
        Question5_1 q = new Question5_1();
        q.replaceDigitsAt(1024, 19, 4, 2);

    }
}
