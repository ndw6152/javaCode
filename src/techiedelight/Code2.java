package techiedelight;

/**
 * Created by Anonealio on 9/20/2017.
 * The longest common substring problem is the problem of finding the longest string (or strings)
 * that is a substring (or are substrings) of two strings.
 * ABABC and BABCA = length 4 = BABC
 */
public class Code2 {

    public String recreateStringFromMatrix(int[][]matrix, String str1, String str2, int r, int c) {
        StringBuilder sb = new StringBuilder();
        while(r>= 1 && c>= 1) {
            if(str1.charAt(r) == str2.charAt(c)) {
                sb.insert(0, str1.charAt(r));
            }
            r = r-1;
            c = c-1;
        }
        if(str1.charAt(r) == str2.charAt(c)) {
            sb.insert(0, str1.charAt(r));
        }
        return sb.toString();
    }

    public String findLongestSubstring(String str1, String str2) {
        int row = str1.length();
        int col = str2.length();

        if(row == 0 || col == 0) {
            return "";
        }
        int[][] matrix = new int[row][col];

        for(int i =0; i < col; i++) { // looping through the first row
            if(str1.charAt(0) == str2.charAt(i)) {
                matrix[0][i] = 1;
            }
        }

        for(int i =0; i< row; i++) { // looping through first column
            if(str2.charAt(0) == str1.charAt(i)) {
                matrix[i][0] = 1;
            }
        }

        int same = 0;
        int posVal = 0;
        int maxLength = 0;
        int rCoord= -1;
        int cCoord = -1;
        for(int r = 1; r <row; r++) {
            for(int c = 1; c <col; c++) {
                if(str1.charAt(r) == str2.charAt(c)) {
                    same = 1;
                    posVal = matrix[r-1][c-1] + same;//Math.max(matrix[r-1][c], matrix[r-1][c-1]) + same;
                    matrix[r][c] = posVal;
                }

                if(posVal > maxLength) {
                    rCoord = r;
                    cCoord = c;
                    maxLength = posVal;
                }
            }
        }
        if(maxLength > 0) {
            return recreateStringFromMatrix(matrix, str1, str2, rCoord, cCoord);
        }

        return "";
    }


    public static void main(String[] args) {
        Code2 c = new Code2();

        System.out.println(c.findLongestSubstring("ABABC", "BABCA"));
        System.out.println(c.findLongestSubstring("BABCA", "ABABC"));
        System.out.println(c.findLongestSubstring("HILA", "YEILLOW"));
        System.out.println(c.findLongestSubstring("HELLOX", "HOWLLO"));
        System.out.println(c.findLongestSubstring("", "EMPTY"));
        System.out.println(c.findLongestSubstring("NOTEMPTY", "EMPTY"));
        System.out.println(c.findLongestSubstring("EMPTY", ""));
        System.out.println(c.findLongestSubstring("123456", "123456"));
        System.out.println(c.findLongestSubstring("ABCEEEEEXXX", "EEEEE"));
        System.out.println(c.findLongestSubstring("EEEEE", "ABCEExEEEx"));
        System.out.println(c.findLongestSubstring("ABCEExEEEx", "EEEEE"));
    }

}
