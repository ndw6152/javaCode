package LeetCode;

/**
 * Created by Anonealio on 8/29/2017.
 */
public class Solution42 {

    

        public int getWater(int[] nums, int i) {
            int water = 0;
            if(i >= nums.length) {
                return 0;
            }

            int left = nums[i];
            int current;
            int right;
            int blocks = 0;
            int possibleWater = 0;
            int width = 0;
            if(i <= nums.length-2) {
                while(i <= nums.length-2) {
                    current = nums[i];
                    right = nums[i+1];

                    if(right >= left) {
                        int height = Math.min(left, right);
                        int resultWater = height*width;
                        resultWater -= blocks;

                        water += resultWater;
                        blocks = 0;
                        possibleWater =0;
                        left = right;
                        width = 0;
                    }
                    else if(right < current) {
                        blocks += right;
                        width++;
                    }
                    else {  // mini water content
                        if(left != 0) {
                            possibleWater += width * right;  // width count is still going
                            /// possibleWater -= blocks;  // need to subtract previous blocks in the way
                            blocks += right;
                            width++;
                        }
                    }
                    i++;
                }
                water += possibleWater;

                return water;
            }
            else {
                return 0;
            }




    }

    public int trapRight(int[] nums) {

        int right = 0;
        int left = nums[0];
        int width =0;
        int water = 0;
        int blocks = 0;

        for(int i = 0; i<= nums.length-2; i++) {
            right = nums[i+1];

            if(right >= left) {
                int height = Math.min(left, right);
                int resultWater = height*width;
                resultWater -= blocks;

                water += resultWater;

                left = right;
                width = 0;
                blocks = 0;
            }
            else {
                blocks += right;
                width++;
            }

        }
        return water;
    }

    public int trapLeft(int[] nums) {
        int right = 0;
        int left = nums[nums.length-1];
        int width =0;
        int water = 0;
        int blocks = 0;

        for(int i = nums.length-1; i> 0; i--) {
            right = nums[i-1];

            if(right > left) {
                int height = Math.min(left, right);
                int resultWater = height*width;
                resultWater -= blocks;

                water += resultWater;

                left = right;
                width = 0;
                blocks = 0;
            }
            else {
                blocks += right;
                width++;
            }

        }

        return water;
    }

    public static void main(String[] args) {
        Solution42 s = new Solution42();
//        int[] arr = {2,0,0,1,2};
//        System.out.println(s.getWater(arr , 0));
//
//        System.out.println(s.trap(arr));
//
//
//        int[] arr2 = {1,0,2};
//        System.out.println(s.getWater(arr2 , 0));
//        System.out.println(s.trap(arr2));
//
//        int[] arr3 = {2,1,0,1,3};
//        System.out.println(s.getWater(arr3 , 0));
////        System.out.println(s.trap(arr3));
//        int[] arr6 = {3,1,0,1};
//        //System.out.println(s.getWater(arr6 , 0));
//        System.out.println(s.trapRight(arr6));
//        System.out.println(s.trapLeft(arr6));
//
//        System.out.println("---------------");
//        int[] arr7 = {5,4,1,2};
//        //System.out.println(s.getWater(arr7 , 0));
//        System.out.println(s.trapRight(arr7));
//        System.out.println(s.trapLeft(arr7));

        System.out.println("---------------");

        int[] arr5 = {2,0,2};
        //System.out.println(s.getWater(arr5 , 0));
        System.out.println(s.trapRight(arr5));
        System.out.println(s.trapLeft(arr5));
    }
}