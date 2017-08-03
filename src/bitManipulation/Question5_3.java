package bitManipulation;

import java.util.ArrayList;

/**
 * Created by Anonealio on 8/3/2017.
 */
public class Question5_3 {


    public ArrayList<Integer> createBinaryArray(int value) {
        ArrayList<Integer> array = new ArrayList<>();

        while(value != 0) {
            if(value %2 == 0) {
                array.add(0, 0);
            }
            else {
                array.add(0,1);
            }
            value = value/2;

        }
        return array;
    }

    public void printArray(ArrayList<Integer> array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public ArrayList<Integer> createConsecutiveOnes(ArrayList<Integer> array) {
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(Integer cur: array) {
            if(cur != 0) {
                count += cur;
            }
            else {
                if(count !=0) {
                    result.add(count);
                }
                count = 0;
                result.add(0);
            }
        }
        if(count !=0) {
            result.add(count);
        }
        return result;
    }

    public int getLongestOnes(ArrayList<Integer> array) {
        int prev = 0;
        int current;
        int currentCount = 0;
        int max = 0;
        boolean flipped = false;
        if(array.size() > 1) {
            currentCount = array.get(0);

            for(int i =1; i < array.size(); i++) {
                current = array.get(i);

                if(current != 0) {
                    currentCount += current;
                    if(flipped) {
                        prev += current;
                    }
                }
                else { // current is a 0
                    if(!flipped) {
                        currentCount += 1;
                        flipped = true;
                    }
                    else {
                        if(max < currentCount) {
                            max = currentCount;
                        }
                        currentCount = prev;
                        currentCount += 1;
                        prev = 0;
                    }
                }
            }
            if(max < currentCount)
                max = currentCount;
            return max;

        }
        else {
            return array.get(0);
        }


    }



    public static void main(String[] args) {

        Question5_3 q = new Question5_3();

        ArrayList<Integer> arr = q.createBinaryArray(1775);
        q.printArray(arr);
        arr = q.createBinaryArray(11);
        q.printArray(arr);
        arr = q.createBinaryArray(15);
        q.printArray(arr);
        arr = q.createBinaryArray(1647);
        q.printArray(arr);
        arr = q.createBinaryArray(12);
        q.printArray(arr);
        arr = q.createBinaryArray(6631);
        q.printArray(arr);
        arr = q.createBinaryArray(13199);
        q.printArray(arr);
        System.out.println("---------");

        arr = q.createConsecutiveOnes(q.createBinaryArray(1775));
        q.printArray(arr);
        arr = q.createConsecutiveOnes(q.createBinaryArray(11));
        q.printArray(arr);
        arr = q.createConsecutiveOnes(q.createBinaryArray(15));
        q.printArray(arr);
        arr = q.createConsecutiveOnes(q.createBinaryArray(1647));
        q.printArray(arr);
        arr = q.createConsecutiveOnes(q.createBinaryArray(12));
        q.printArray(arr);
        arr = q.createConsecutiveOnes(q.createBinaryArray(6631));
        q.printArray(arr);
        arr = q.createConsecutiveOnes(q.createBinaryArray(13199));
        q.printArray(arr);
        System.out.println("---------");
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(1775))));
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(11))));
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(15))));
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(1647))));
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(12))));
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(6631))));
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(q.createBinaryArray(13199))));
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);array.add(0);array.add(0);array.add(0);
        System.out.println(q.getLongestOnes(q.createConsecutiveOnes(array)));

    }
}
