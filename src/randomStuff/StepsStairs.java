package randomStuff;

import java.util.ArrayList;

/**
 * Created by ndw6152 on 7/28/2018.
 */
public class StepsStairs {

    public int climbStairs(int A) {
        if(A <=0) {
            return 0;
        }
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;

        int[] steps = {1, 2};  // can be  changed to however many steps

        for(int i =2; i <=A; i++) {
            int total = 0;
            for(int step : steps) {
                if(i -step >=0) {
                    total += dp[i-step];
                }
                dp[i] = total;
            }
        }

        return dp[A];
    }


    public int climbStairs2(int A, int[] steps) {
        int[] dp = new int [A+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i =2; i <= A; i++) {
            for (int step: steps) {
                if(i - step >= 0) {
                    dp[i] += dp[i-step];
                }
            }
        }

        return dp[A];
    }

    public MyLinkedList.Node detectCycle(MyLinkedList.Node a) {
        if(a == null) {
            return a;
        }

        MyLinkedList.Node slow = a;
        MyLinkedList.Node fast = a;

        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println(fast.val);
            if(slow == fast) {
                cycle = true;  // cycle;
                break;
            }
        }

        if(!cycle) {
            return null;
        }

        slow = a;
        while(slow != null) {
            slow = slow.next;
            fast = fast.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;

    }
    public int removeDuplicates(int[] arr) {
            if(arr.length == 0) {
                return 0;
            }

            int p = 0;
            for(int i = 1 ; i < arr.length; i++) {
                if(arr[i] != arr[p]) {
                    p++;
                    arr[p] = arr[i];
                }
            }

            return p+1;

    }

    public static void main(String[] args) {
        StepsStairs sol = new StepsStairs();
        int[] steps = {1,2};
        System.out.println(sol.climbStairs(4) + "  " + sol.climbStairs2(4, steps)); // 5
        System.out.println(sol.climbStairs(3) + "  " + sol.climbStairs2(3, steps)); // 3
        System.out.println(sol.climbStairs(2) + "  " + sol.climbStairs2(2, steps)); // 2
        System.out.println(sol.climbStairs(-1)); // 5


        MyLinkedList.Node head = new MyLinkedList.Node(10);
        head.next = head;
        System.out.println(sol.detectCycle(head).val);

        int[] arr2 = {1,1,1,2,2,3};
        sol.removeDuplicates(arr2);


        StringBuilder sb = new StringBuilder("hello");
        sb.append('a');sb.append('b');sb.append('c');
        sb.delete(1,2);
        sb.insert(1, "FFF");

        System.out.println(sb.toString());
    }

}
