package randomStuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Created by Anonealio on 6/21/2017.
 */
public class Question2 {

    public int ran() {
        Random rn = new Random();
        return rn.nextInt(5) +1;
    }

    public int random7() {
        int val;
        do {
            val = ran();

        }while(val >3);

        return ran() + val%3;
    }

    public int rand7() {
        int values[][]={{0,0,0,0,0,0},
                        {1,2,3,4,5,6},
                        {7,1,2,3,4,5},
                        {6,7,1,2,3,4},
                        {5,6,7,1,2,3},
                        {4,5,6,7,0,0}
                        };

        int result = values[ran()][ran()];

        if(result == 0) {
            return rand7();
        }
        else{
            return result;
        }

    }


    public static void main(String[] args) {
        Question2 q= new Question2();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i <10000000; i++ ){

            arr.add(q.rand7());

        }
        System.out.println("Freq of 0: "+ Collections.frequency(arr, 0));
        System.out.println("Freq of 1: "+ Collections.frequency(arr, 1));
        System.out.println("Freq of 2: "+ Collections.frequency(arr, 2));
        System.out.println("Freq of 3: "+ Collections.frequency(arr, 3));
        System.out.println("Freq of 4: "+ Collections.frequency(arr, 4));
        System.out.println("Freq of 5: "+ Collections.frequency(arr, 5));
        System.out.println("Freq of 6: "+ Collections.frequency(arr, 6));
        System.out.println("Freq of 7: "+ Collections.frequency(arr, 7));
        System.out.println("Freq of 8: "+ Collections.frequency(arr, 8));

    }

}
