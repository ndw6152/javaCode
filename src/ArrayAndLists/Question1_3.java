package ArrayAndLists;

/**
 * Created by Anonealio on 6/27/2017.
 */
public class Question1_3 {

    public char[] URLify(char[] arr, int size) {
        int trueSize = 0;

        for(int i =0; i<size; i++) {
            if(arr[i] == ' ')  {
                trueSize += 3;
            }
            else {
                trueSize += 1;
            }
        }

        int index = trueSize -1;
        for(int j = size-1; j>= 0; j--) {
            if(arr[j] == ' ') {
                arr[index] = '0';
                arr[index - 1] = '2';
                arr[index - 2] = '%';
                index = index - 3;
            }
            else {
                arr[index] = arr[j];
                index -=1;
            }
        }
        return arr;
    }

    public char[] createArr(String str) {
        int trueSize = 0;
        for(int i= 0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                trueSize += 3;
            }
            else {
                trueSize += 1;
            }
        }
        char[] resultArr = new char[trueSize];
        char[] chArr = str.toCharArray();
        int index = 0;
        for(char ch : chArr) {
            resultArr[index++] = ch;
        }
        return resultArr;
    }

    public static void main(String[] args) {

        Question1_3 q = new Question1_3();

        String s = "MR JOHN SMITH";
        System.out.println(q.URLify(q.createArr(s), s.length()));

        String s1 = "A   hello ";
        System.out.println(q.URLify(q.createArr(s1), s1.length()));

        String s2 = " ";
        System.out.println(q.URLify(q.createArr(s2), s2.length()));
    }

}
