package randomStuff;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by ndw6152 on 7/10/2018.
 */
public class GenerateStrings {


    public boolean isStringValid(String str) {
        return true;
    }

    public boolean isWildCard(String str, int index) {
        if(index >= str.length()) {
            return false;
        }
        char ch = str.charAt(index);
        return (ch == '?' || ch == '*');
    }

    public void helper(ArrayList<String> result, String str, String current, int index, ArrayList<Character> choice) {
        if(index == str.length()) {
            result.add(current);
            return;
        }

        char ch = str.charAt(index);
        if(isWildCard(str, index)) {
            for(Character c:  choice) {
                helper(result, str, current+c, index+1, choice);
            }
        }
        else {
            helper(result, str, current+ch, index+1, choice);
        }
    }


    public ArrayList<String> generate(String str, ArrayList<Character> choiceArr) {
        ArrayList<String> result = new ArrayList<>();

        helper(result, str, "", 0, choiceArr);

        return result;
    }


    public static void main(String[] args) {
        GenerateStrings sol = new GenerateStrings();
        ArrayList<Character> choiceArr = new ArrayList<>();
        choiceArr.add('a'); choiceArr.add('b');

        ArrayList<String> result = sol.generate("01?0?", choiceArr);
        System.out.println(result);
    }
}
