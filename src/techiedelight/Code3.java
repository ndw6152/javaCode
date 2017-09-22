package techiedelight;

/**
 * Created by Anonealio on 9/21/2017.
 * Longest Common Subsequence
 */
public class Code3 {

    public String recreateLCSstring(int[][]matrix, String str1, String str2, int r, int c) {
        StringBuilder sb = new StringBuilder();

        while(r-1 >=0 && c-1 >=0) {
            if(str1.charAt(r-1) == str2.charAt(c-1)) {
                sb.insert(0, str1.charAt(r-1));
                r = r-1;
                c = c-1;
                continue;
            }
            if(matrix[r-1][c] == matrix[r][c-1]) {
                r = r-1;
                c = c-1;
            }
            else if(matrix[r-1][c] > matrix[r][c-1]) {
                r = r-1;
            }
            else {
                c = c-1;
            }
        }

        return sb.toString();
    }

    public String findLongestCommonSubsequnce(String str1, String str2) {
        int size1 = str1.length();
        int size2 = str2.length();

        if(size1 == 0 || size2 == 0) {
            return "";
        }
        int row = size1 +1;
        int col = size2 +1;
        int[][] matrix = new int[row][col]; // adding extra row and col at top and left;

        for(int r = 0; r <row; r++) {

            for(int c = 0; c<col; c++) {
                if(r == 0 || c ==0) {
                    matrix[r][c] = 0;
                }
                else if(str1.charAt(r-1) == str2.charAt(c-1)) {
                    matrix[r][c] = matrix[r-1][c-1] + 1;
                }
                else {
                    matrix[r][c] = Math.max(matrix[r-1][c], matrix[r][c-1]);
                }
            }
        }
        System.out.println(matrix[row-1][col-1]);
        if(matrix[row-1][col-1] > 0) {
            return recreateLCSstring(matrix, str1, str2, row-1, col-1);
        }

        return "";
    }





    public static void main(String[] args) {
        Code3 c = new Code3();
        System.out.println(c.findLongestCommonSubsequnce("ACD", "ABCDE"));
        System.out.println(c.findLongestCommonSubsequnce("EEEEE", "ABECED"));
        System.out.println(c.findLongestCommonSubsequnce("ABECED", "EEEEE"));
        System.out.println(c.findLongestCommonSubsequnce("HOLEX", "HEYAX"));
        System.out.println(c.findLongestCommonSubsequnce("", "EMPTY"));
        System.out.println(c.findLongestCommonSubsequnce("EMPTY", "NOT"));
    }

}
