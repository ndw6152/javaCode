package LeetCode;

/**
 * Created by Anonealio on 8/28/2017.
 */
class Solution13 {

    // roman to integer using a bunch of if statements
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            if(ch == 'I') {
                if(i+1 < arr.length) {
                    if(arr[i+1] == 'V') {
                        result += 4;
                        i++;
                    }
                    else if(arr[i+1] == 'X') {
                        result += 9;
                        i++;
                    }
                    else {
                        result += 1;
                    }

                }
            }
            else if(ch == 'X') {
                if(i+1 < arr.length) {
                    if(arr[i+1] == 'L') {
                        result += 40;
                        i++;
                    }
                    else if(arr[i+1] == 'C') {
                        result += 90;
                        i++;
                    }
                    else {
                        result += 10;
                    }
                }
                else {
                    result += 10;
                }
            }
            else if (ch == 'L') {
                result += 50;
            }
            else if(ch == 'C') {
                result += 100;
            }
            else if(ch == 'D') {
                result += 500;
            }
            else if(ch == 'M') {
                result += 1000;
            }

        }
        return result;
    }

    // easy way to count roman numeral, change the character to an int, then compare with next one,
    // if the value is smaller than the next one remove current value
    // else add value e.g IX, I < X therefore result = -1 + 10
    // eg XIX, result = 10 > 1 add 10, 1 < 10 remove 1, then add last digit result = 10 - 1 + 10;

    public int getValue(char ch) {
        if(ch == 'I') {
            return 1;
        }
        else if(ch == 'V') {
            return 5;
        }
        else if(ch == 'X') {
            return 10;
        }
        else if(ch == 'L') {
            return 50;
        }
        else if(ch == 'C') {
            return 100;
        }
        else if(ch == 'D') {
            return 500;
        }
        else if(ch == 'M') {
            return 1000;
        }
        else {
            return -1;
        }
    }
    // http://www.rapidtables.com/convert/number/roman-numerals-converter.htm
    public int romanToInt2(String s) {
        if(s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return getValue(s.charAt(0));
        }
        int result = 0;
        for(int i =0; i<s.length()-1; i++){
            if(getValue(s.charAt(i)) < getValue(s.charAt(i+1))) {
                result -= getValue(s.charAt(i));
            }
            else {
                result += getValue(s.charAt(i));
            }
        }
        result += getValue(s.charAt(s.length()-1));
        return result;
    }

    public static void main(String[] args) {
        Solution13 s = new Solution13();
        System.out.println("XIX, 19 = " + s.romanToInt2("XIX"));
        System.out.println("XXX, 30 = " + s.romanToInt2("XXX"));
        System.out.println("V, 5 = " + s.romanToInt2("V"));
        System.out.println("MIV, 1004 = " + s.romanToInt2("MIV"));
    }


}
