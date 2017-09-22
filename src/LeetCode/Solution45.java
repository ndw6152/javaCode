package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static java.lang.Math.max;

/**
 * Created by Anonealio on 9/12/2017.
 */
class Solution45 {
    class Pair {
        int index;
        int val;
        int jumps;
        Pair(int index, int val, int jumps) {
            this.index = index;
            this.val = val;
            this.jumps = jumps;
        }
    }


    public int jump(int[] nums) {
        Queue<Pair> q = new LinkedList<>();
        if (nums.length < 2) {
            return 0;
        } else {
            q.add(new Pair(0, nums[0], 0));
            Set<Integer> visited = new HashSet<>();

            int maxReach = nums[0];

            int target = nums.length - 1;

            while (!q.isEmpty()) {
                Pair temp = q.poll();
                maxReach = temp.index + temp.val;
                if (maxReach >= target) {
                    return temp.jumps + 1;
                }

                if (!visited.contains(temp.index)) {
                    visited.add(temp.index);

                    int maxVal = 0;
                    int maxIndex = 0;
                    for (int i = 1; i <= temp.val; i++) {
                        int nextSpotIndex = temp.index + i;
                        if (nextSpotIndex >= target) {
                            return temp.jumps + 1;
                        }

                        int curVal = nums[nextSpotIndex];
                        int curMax = nums[nextSpotIndex] + i;


                        if (curMax >= maxReach) {
                            maxReach = curMax;
                            maxVal = curVal;
                            maxIndex = nextSpotIndex;
                        }
                    }
                    q.add(new Pair(maxIndex, maxVal, temp.jumps + 1));
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution45 s = new Solution45();
        int[] arr = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(s.jump(arr));
    }
}
