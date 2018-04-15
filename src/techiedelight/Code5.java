package techiedelight;

/**
 * Created by Anonealio on 10/12/2017.
 */
public class Code5 {
    // java.util.* has been imported for this problem.
// You don't need any other imports.

    public static String recurseCheck(String str) {
        if(str.length() == 2) {
            if(str.charAt(0) == str.charAt(1)) {
                return str.charAt(0) +"*"+ str.charAt(1);
            }
            return str;
        }

        char ch = str.charAt(0);
        String result = recurseCheck(str.substring(1));
        if(result.charAt(0) == ch) {
            return ch +"*"+ str;
        }
        return ch + str;
    }

    public static String insertPairStar(String s) {
        if(s == null) {
            return null;
        }
        if(s.length() == 1) {
            return s;
        }

        return recurseCheck(s);
    }

    public static void main(String[] args) {
        System.out.println(insertPairStar("acc"));
    }
}
