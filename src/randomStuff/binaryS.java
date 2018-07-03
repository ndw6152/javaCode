package randomStuff;

/**
 * Created by ndw6152 on 6/12/2018.
 */
public class binaryS {

    public int binarySearch(int a) {
        int low = 1;
        int high = a;

        while(low < high) {
            int median = (low + high)/2;
            if(median*median == a) {
                return median;
            }

            if(median> a/median) {  // look at left side
                high = median -1;
            }
            else {
                low = median +1; // look right side;
            }

        }
        return low;
    }

    public int sqrt(int a) {
        long low = 1;
        long high = a;
        while (low<=high) {
            long mid = (high + low) / 2;
            if (mid*mid == a) {
                return (int) mid;
            }
            if (mid*mid > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // if we did not find an exact match the high variable is smaller than low
        // and therefore contains the floor value of sqrt.
        return (int) high;
    }
    public int binarySearch2(int a) {
        int low = 1;
        int high = a;
        int result = 0;
        while(low <= high) {
            int median = (low + high)/2;

            if(median > a/median) {  // look at left side
                high = median -1;
            }
            else {
                low = median +1; // look right side;
                result = median;
            }

        }
        return result;
    }

    int sqrt2(int x) {
        if (x == 0) return 0;
        int start = 1, end = x, ans =0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid <= x / mid) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        binaryS s = new binaryS();
        System.out.println(s.binarySearch(2147483647));
    }
}
