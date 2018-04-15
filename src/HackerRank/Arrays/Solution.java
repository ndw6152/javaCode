package HackerRank.Arrays;

import java.io.*;
import java.util.*;

public class Solution {
    private ArrayList<ArrayList<Integer> > seqList = new ArrayList<>();
    private int N = 0;
    private int lastAnswer = 0;

    Solution(int N) {
        this.N = N;
        for(int i=0; i< N; i++) {
            seqList.add(new ArrayList());
        }
    }


    public void placeInSequence(int x, int y) {
        int index = (x^lastAnswer)%N;
        ArrayList<Integer> temp = seqList.get(index);
        temp.add(y);
    }

    public void findValue(int x, int y) {
        int index = (x^lastAnswer)%N;
        ArrayList<Integer> arr = seqList.get(index);
        int arrayIndex = y%arr.size();
        this.lastAnswer = arr.get(arrayIndex);
        System.out.println(lastAnswer);
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int Q = in.nextInt();
//        Solution s = new Solution(N);
//
//        for(int i =0; i<Q; i++) {
//            int arr[] = new int[3];
//            for(int j=0; j<3; j++){
//                arr[j] = in.nextInt();
//            }
//            if(arr[0] == 1) {
//                s.placeInSequence(arr[1], arr[2]);
//            }
//            else {
//                s.findValue(arr[1], arr[2]);
//            }
//        }

//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//
////This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
//        long[] arr = new long[n];
//
//        int lower;
//        int upper;
//        long sum;
//
//        for(int i=0;i<n;i++) arr[i]=0;
//
//        for(int i=0;i<m;i++){
//            lower=scan.nextInt();
//            upper=scan.nextInt();
//            sum=scan.nextInt();
//            arr[lower-1]+=sum;
//            if(upper<n) arr[upper]-=sum;
//        }
//
//        long max=0;
//        long temp=0;
//
//        for(int i=0;i<n;i++){
//            temp += arr[i];
//            if(temp> max)
//                max=temp;
//        }
//
//        System.out.println(max);


        int arr2[] = new int[2];
        System.out.println("SIZE: " + arr2.length);
    }
}