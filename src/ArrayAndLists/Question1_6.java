package ArrayAndLists;

import java.util.Arrays;

/**
 * Created by Anonealio on 7/4/2017.
 */
public class Question1_6 {

    public String inefficientCompressString(String str) {
        if(str.length() > 0) {
            char current = str.charAt(0);
            int count = 1;
            String results = "";
            for(int i =1; i< str.length(); i++) {
                char next = str.charAt(i);

                if(current != next) {
                    results += Character.toString(current) + count;
                    count = 1;
                    current = next;

                }
                else{
                    count++;

                }

            }
            results += Character.toString(current) + count;

            if(results.length() > str.length()){
                return str;
            }
            else{
                return results;
            }

        }
        else {
            return "";
        }

    }

    public int getSpaceNeeded(String str) {
        if(str.length() > 0) {
            int differentElements = 1;
            char current = str.charAt(0);
            for(int i =1; i<str.length(); i++) {
                char next = str.charAt(i);
                if(current != next) {
                    differentElements++;
                    current = next;
                }
            }
            return differentElements*2;
        }
        else{
            return 0;
        }
    }

    public String[] createCompressArray(String[] arr, String str) {
        int count = 1;
        char current = str.charAt(0);
        int index = 0;

        for(int i =1; i<str.length(); i++) {
            char next = str.charAt(i);
            if(current != next) {
                arr[index] = Character.toString(current);
                arr[index+1] = count + "";
                count = 1;
                current = next;
                index += 2;
            }
            else{
                count++;
            }
        }
        arr[index] = Character.toString(current);
        arr[index+1] = count + "";
        return arr;
    }

    public String compressString(String str) {

        if(str.length() > 0) {
            int space = getSpaceNeeded(str);
            if(space > str.length()) {
                return str;
            }
            String[] arr = createCompressArray(new String[space], str);
            StringBuilder sb = new StringBuilder();
            for(String s : arr) {
                sb.append(s);
            }
            return sb.toString();


        }
        else{
            return "";
        }

    }



    public static void main(String[] args) {
        Question1_6 q = new Question1_6();
        System.out.println( q.inefficientCompressString("aabcccccaaa") );
        System.out.println( q.inefficientCompressString("a") );
        System.out.println( q.inefficientCompressString("") );


        System.out.println( q.compressString("aabcccccaaa") );
        System.out.println( q.compressString("a") );
        System.out.println( q.compressString("") );

    }


}
