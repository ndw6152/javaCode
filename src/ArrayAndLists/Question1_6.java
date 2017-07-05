package ArrayAndLists;

/**
 * Created by Anonealio on 7/4/2017.
 */
public class Question1_6 {

    public String compressString(String str) {
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

    public static void main(String[] args) {
        Question1_6 q = new Question1_6();
        System.out.println( q.compressString("aabcccccaaa") );
        System.out.println( q.compressString("a") );
        System.out.println( q.compressString("") );

    }


}
