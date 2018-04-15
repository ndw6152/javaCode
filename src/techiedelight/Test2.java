package techiedelight;

/**
 * Created by Anonealio on 9/23/2017.
 */
public class Test2 {
    public String addOneToArray(String str) {
        int carry  =1;
        int temp;
        StringBuilder sb = new StringBuilder();

        for( int i = str.length()-1; i>= 0; i--) {  // 1 0 1   i =2  1+1;
            temp = Integer.parseInt(str.charAt(i) + "") + carry;
            if(temp == 2) {
                sb.insert(0, "0"); // inserting in front
                carry = 1;
            }
            else {
                sb.insert(0, temp);
                carry = 0;
            }
        }
        if(carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public void createAllBinariesTo(int input) {
        if(input ==0) {
            System.out.print(0);
        }
        if(input == 1) {
            System.out.print(1);
        }
        else {
            String currentString = "1";
            System.out.print("0 ");
            System.out.print(currentString);
            for(int i = 2; i < input; i++) {
                currentString = addOneToArray(currentString);
                System.out.print(" "  +currentString);
            }
        }
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.createAllBinariesTo(7);

    }

}
