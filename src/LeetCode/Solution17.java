package LeetCode;

/**
 * Created by Anonealio on 9/4/2017.
 */
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Hashtable;
        import java.util.List;

class Solution17 {
    Hashtable<Character, List<Character>> table;

    public void initializeTable() {
        table = new Hashtable<>();
        List<Character> lst = Arrays.asList('a','b','c');
        this.table.put('2', lst);
        lst = Arrays.asList('d','e','f');
        this.table.put('3', lst);
        lst = Arrays.asList('g','h','i');
        this.table.put('4', lst);
        lst = Arrays.asList('j','k','l');
        this.table.put('5', lst);
        lst = Arrays.asList('m','n','o');
        this.table.put('6', lst);
        lst = Arrays.asList('p','q','r','s');
        this.table.put('7', lst);
        lst = Arrays.asList('t','u','v');
        this.table.put('8', lst);
        lst = Arrays.asList('w','x','y','z');
        this.table.put('9', lst);
    }

    public ArrayList<String> createCombinations(String str) {
        if(str.length() == 1) {
            char ch = str.charAt(0);
            List<Character> charList = table.get(ch);
            ArrayList<String> arr = new ArrayList<>();
            if(charList != null) {
                for(char ch2: charList) {
                    arr.add(ch2 +"");
                }
            }
            return arr;
        }


        char firstChar = str.charAt(0);
        ArrayList<String> result = new ArrayList<String>();

        ArrayList<String> arr2 = createCombinations(str.substring(1));
        for(char ch1: table.get(firstChar)) {
            for(String str2: arr2) {
                String s = ch1+ str2;
                result.add(s);
            }
        }

        return result;
    }



    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return null;
        }
        initializeTable();
        return createCombinations(digits);
    }


    public static void main(String[] args) {
        Solution17 s = new Solution17();
        List<String> result = s.letterCombinations("234");
    }
}