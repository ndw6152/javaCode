package techiedelight;

/**
 * Created by Anonealio on 9/24/2017.
 */
public class Test3 {

    public String reverseTheSentence(String str) {
        String curWord;
        StringBuffer sb = new StringBuffer();
        int startIndex = 0;
        for(int i =0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                curWord = str.substring(startIndex, i);
                if(curWord.length() > 0) {
                    sb.insert(0, curWord);
                    sb.insert(0, ' ');
                }
                startIndex = i +1;
            }
        }
        if(startIndex < str.length()) {
            curWord = str.substring(startIndex);
            if(curWord.length() > 0) {
                sb.insert(0, curWord);
            }
        }
        return sb.toString();
    }

    int[] temp(int[] arr) {
        arr[1] = 0;
        return arr;
    }

    public static void main(String[] args) {

        Test3 t = new Test3();
        System.out.println(t.reverseTheSentence("We provide tests"));
        System.out.println(t.reverseTheSentence("We provide      tests"));

        int[] arr = {1,2,3,4};
        t.temp(arr);
        System.out.println();
    }
}
