package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 8/14/2018.
 */
public class FindPerm {


    public void helper(ArrayList<Integer> result, String str, int n,
                       int index, ArrayList<Integer> array) {
        if(index == str.length()) {
            result.addAll(array);
            return;
        }

        if(result.size() !=0) {
            return;
        }

        for(int i =1; i <= n; i++) {

            if(!array.contains(i)) { // not using this yet
                if(str.charAt(index) == 'D') { // current number need to be less than last number in array
                    if(i > array.get(array.size()-1)) {
                        return;
                    }
                }
                else {  // number needs to be larger
                    if(i < array.get(array.size()-1)) {
                        return;
                    }
                }
                array.add(i);
                helper(result, str, n, index+1, array);
                array.remove(array.size()-1);
            }
        }

    }



    public ArrayList<Integer> findPerm(final String str, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if(str.length() == 0 || n <= str.length()) {
            return result;
        }

        for( int i = 1; i <= n; i++) {
            ArrayList<Integer> array = new ArrayList<>();
            array.add(i);
            helper(result, str, n, 0, array);
            if(result.size() != 0) {
                return result;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        FindPerm sol = new FindPerm();
        sol.findPerm("IDIDI", 6);
    }
}


