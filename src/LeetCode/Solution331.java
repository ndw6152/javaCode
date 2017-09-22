package LeetCode;

/**
 * Created by Anonealio on 9/5/2017.
 */

import java.util.Stack;
import java.util.*;
class Solution331 {
    public boolean isValidSerialization(String str) {
        String[] arr = str.split(",");
        Stack<String> stack = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
            String cur = arr[i];
            if(cur.equals("#")) {
                stack.push(cur);
            }
            else{
                try {
                    stack.pop();
                    stack.pop();
                }
                catch(EmptyStackException ex) {
                    return false;
                }
                stack.push(cur);
            }
        }

        if(stack.size() == 1) {
            if(stack.peek().equals(arr[0])) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution331 s = new Solution331();
        s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}