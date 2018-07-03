package randomStuff;

/**
 * Created by ndw6152 on 6/24/2018.
 */
public class FindFirstOne {

    int findFirstOne(int[] arr) {
        if(arr.length == 0 || arr[0] != 0 || arr[arr.length -1] != 1) {
            return -1;
        }
        int low = 0;
        int high = arr.length -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                if (mid - 1 >= 0) {
                    if (arr[mid - 1] == 0) {
                        return mid - 1;
                    }
                }
                high = mid - 1;
            } else {
                if (mid + 1 < arr.length) {
                    if (arr[mid + 1] == 1) {
                        return mid;
                    }
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,1,1};
        FindFirstOne sol = new FindFirstOne();
        System.out.println(sol.findFirstOne(arr));


        int[] arr2 = {0,0,0,0,0,1,1};
        System.out.println(sol.findFirstOne(arr2));

        int[] arr3 = {1,1,1,1};
        System.out.println(sol.findFirstOne(arr3));
    }

}
