package randomStuff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Anonealio on 9/11/2017.
 *
 */
public class Question91 {


    public ArrayList<String> merge(Character ch, String str) {
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i <= str.length(); i++) {
            arr.add(str.substring(0, i) + ch + str.substring(i, str.length()));
        }

        return arr;
    }

    public ArrayList<String> merge(Character ch, ArrayList<String> arr) {
        ArrayList<String> result = new ArrayList<>();
        for(String str : arr) {
            for (int i = 0; i <= str.length(); i++) {
                result.add(str.substring(0, i) + ch + str.substring(i, str.length()));
            }
        }
        return result;
    }

    // this function has duplicates, can use a hashset to remove duplicates
    // this functions creates all the permutations of a string and save it in an array
    // the permutations are done using merging and insertion recursively.
    public ArrayList<String> perm(String str) {
        ArrayList<String> arr = new ArrayList<>();
        if(str.length() <1) {
            return arr;
        }
        else if (str.length() == 1) {
            arr.add(str);
            return arr;
        }
        else if(str.length() == 2) {
            arr.addAll(merge(str.charAt(0), str.substring(1)));
        }
        else {
            char first = str.charAt(0);

            arr.addAll(merge(first, perm(str.substring(1))));

        }
        return arr;
    }

    /////////////////////////
    public static void permutation2(String str) {
        permutation2("", str);
    }
    private static void permutation2(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation2(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
    /////////////////////////

    public void permBackTrack(HashSet<String> allSolution, StringBuilder solution, String str, boolean[]visited) {
        if(solution.toString().length() == str.length()) {
            allSolution.add(solution.toString());
            return;
        }
        for(int i =0; i<str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution.append(str.charAt(i));
                permBackTrack(allSolution, solution, str, visited);
                solution.deleteCharAt(solution.length()-1);
                visited[i] = false;
            }
        }

    }

    public HashSet<String> permutationStringUsingBackTrack(String str) {
        HashSet<String> result = new HashSet<>();
        if(str.length() == 0) {
            return result;
        }
        boolean[] visited = new boolean[str.length()];
        permBackTrack(result, new StringBuilder(), str, visited);
        return result;
    }


    public static void main(String[] args) {
        Question91 q = new Question91();
        //q.permutation("ABC");
        //System.out.println("ABC".substring(0,1));

        System.out.println("------");
        System.out.println(q.perm("ABC"));
        System.out.println("------");
        System.out.println(q.perm("123"));
        System.out.println("------");
        System.out.println(q.perm("112"));
        System.out.println("------");
        System.out.println(q.perm("AAA"));
        System.out.println("--- using backtracking ---");
        System.out.println(q.permutationStringUsingBackTrack("112"));
        System.out.println("------");
        System.out.println(q.permutationStringUsingBackTrack("123"));
        System.out.println("------");
        System.out.println(q.permutationStringUsingBackTrack("ABC"));
        System.out.println("------");
        System.out.println(q.permutationStringUsingBackTrack("AAA"));
    }


}
