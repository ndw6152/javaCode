package randomStuff;

/**
 * Created by ndw6152 on 8/15/2018.
 */
public class Power {

    public String divide(String str, int n) {
        if(str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for(int i = 0 ; i < str.length(); i++) {
            int first =  Character.getNumericValue(str.charAt(i));
            first = first + carry * 10;

            if(first >= n) {
                carry = first%n;
                sb.append(first/n);
            }
            else {
                carry = first;
                sb.append("0");
            }
        }

//        if(carry == 1) {
//            return "-1";
//        }

        int index = 0;
        while(sb.charAt(index) == '0') {
            index++;
        }
        String s =  sb.substring(index);
        System.out.println("divide: " + str + " by " + n + " = " + s + " , carry = " + carry);
        return s;
    }


        public String divide2(String str, int n) {
            if(str.length() == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for(int i = 0 ; i < str.length(); i++) {
                int first =  Character.getNumericValue(str.charAt(i));
                first = first + carry * 10;

                if(first >= n) {
                    carry = first%n;
                    sb.append(first/n);
                }
                else {
                    carry = first;
                    sb.append("0");
                }
            }
            if(carry == 1) {
                return "-1";
            }

            int index = 0;
            while(sb.charAt(index) == '0') {
                index++;
            }
            return sb.substring(index);
        }

        public int power(String str) {
            if(str.length() == 0) {
                return 1;
            }
            if(str.charAt(0) == '-') { // negative number
                return 0;
            }

            while(str.length() != 1) {
                str = divide2(str, 2);
                if(str.equals("-1")) {
                    return 0;
                }
            }

            int val = Character.getNumericValue(str.charAt(0));
            if(val%2 == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

    public String print(int[] result) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(result[index] ==0) {
            index++;
        }

        for(int i =index; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public String mult(String s1, String s2) { //s1 is bigger
        int max = s1.length() + s2.length();
        int[] result = new int[max];

        int carry = 0 ;
        int carrySum = 0;
        int startIndex = max-1;
        int curIndex;
        for(int i = s2.length()-1 ; i >=0; i--) {
            curIndex = startIndex;
            int s2Val = Character.getNumericValue(s2.charAt(i));

            for(int j = s1.length()-1; j >=0; j--) {
                int s1Val = Character.getNumericValue(s1.charAt(j));

                int res = (s1Val * s2Val) + carry;
                carry = res/10;
                int val = res%10;


                int sumRes = result[curIndex] + val + carrySum;
                carrySum = sumRes/10;
                int actualRes = sumRes%10;
                result[curIndex] = actualRes;
                curIndex--;
            }
            result[curIndex] = carry;
            if(carrySum != 0) {
                result[curIndex] = result[curIndex] + carrySum;
            }

            startIndex--;
            carry = 0;
            carrySum = 0;
        }

        String s = print(result);
        return s;
    }

    public String multiply(String s1, String s2) {


        if(s1.length() == 1 && s1.equals("0")) {
            return "0";
        }
        else if(s2.length() == 1 && s2.equals("0")) {
            return "0";
        }



        if(s1.length() > s2.length()) {
            return mult(s1, s2);
        }
        else {
            return mult(s2, s1);
        }

    }



    public static void main(String[] args) {
        Power sol = new Power();

        sol.divide("145", 2);
        sol.divide("144", 2);
        sol.divide("14", 2);
        sol.divide("200", 2);
        sol.divide("4", 2);
        sol.divide("5", 2);
        sol.divide("2", 2);

        System.out.println();

        sol.multiply("99", "99");
        sol.multiply("99", "1");
        sol.multiply("1234567", "10");
    }
}
