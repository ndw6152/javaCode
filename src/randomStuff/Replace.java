package randomStuff;

/**
 * Created by ndw6152 on 8/4/2018.
 */
public class Replace {

    public boolean verifyPos(String str, int startIndex, String source) {
        if(startIndex >= str.length()) {
            return false;
        }

        int x = 0;
        for(int i = startIndex; i < startIndex + source.length(); i++) {
            if(str.charAt(i) != source.charAt(x)) {
                return false;
            }
            x++;
        }

        return true;
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        String[] sb = new String[S.length()];
        int[] ogStr = new int[S.length()];

        StringBuilder str = new StringBuilder();

        for(int i =0; i < indexes.length; i++) {
            if(verifyPos(S, indexes[i], sources[i])) {  // valid replacement
                sb[indexes[i]] = targets[i];             // save replacement and mark this position as 1, if 1 then look at sb instead of str
                for(int j = indexes[i]; j < indexes[i] + sources[i].length(); j++) {
                    ogStr[j] = 1;
                }
            }
        }

        for(int i =0; i < S.length(); i++) {
            if(ogStr[i] == 1) {
                if(sb[i] != null) {
                    str.append(sb[i]);
                }
            }
            else {
                str.append(S.charAt(i));
            }
        }
        return str.toString();
    }

    public String reverseWords(String s) {

        String[] arr = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i = arr.length -1; i>=0; i--) {
            sb.append(arr[i]);
            if(i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public boolean isConsecutive(int num) {
        int mask = 3;

        while(mask <= num) {
            if((num & mask) == mask) {
                return true;
            }
            mask = mask <<1;
        }
        return false;
    }

    public int findIntegers(int num) {

        int count = 1;

        for(int i =1; i <= num; i++) {
            if(!isConsecutive(i)) {
                count += 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Replace sol = new Replace();

//        int[] indexes = {0,2};
//        String[] sources = {"a", "cd"};
//        String[] targets = {"eee", "ff"};
//
//        System.out.println(sol.findReplaceString("abcd", indexes, sources, targets));
//        String[] sarr = (" a   b".split("\\s+"));
//
//        System.out.println(sol.reverseWords(" 2".trim()));
//        System.out.println();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(0);
//        sb.append(1);
//        sb.append(0);
//        sb.append(1);
//        if(sb.charAt(sb.length()-1) == '1') {
//            System.out.println("finish with 1");
//        }
//        System.out.println(sb.toString());

        System.out.println(sol.findIntegers(1000));
        System.out.println(Integer.toBinaryString(4));
    }
}
