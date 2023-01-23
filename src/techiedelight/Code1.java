package techiedelight;

/**
 * Created by Anonealio on 9/19/2017.
 */
public class Code1 {

    // http://www.techiedelight.com/check-given-set-moves-circular-not/
    // Check if given set of moves is circular or not.
    // The move is circular if its starting and ending coordinates are the same.
    // The moves can contain instructions to move one unit in same direction (M),
    // to change direction to left of current direction (L) and to change direction to right of current direction (R).
    public boolean isCircular(String str) {
        int currentDir = 0;
        int vertical = 0;
        int horizontal = 0;

        for(char ch : str.toCharArray()) {
            if(ch == 'M') {
                switch (currentDir) {
                    case 0:
                        vertical++;
                        break;
                    case 1:
                        horizontal++;
                        break;
                    case 2:
                        vertical--;
                        break;
                    case 3:
                        horizontal--;
                        break;
                    default:
                        break;
                }
            }
            else if(ch == 'R') {
                currentDir = (Math.abs(currentDir+1))%4;
            }
            else if(ch == 'L') {
                currentDir = currentDir-1 <0 ? 3: currentDir -1;
            }

            boolean flag = 'c' == 'c';
        }

        if(vertical != 0 || horizontal != 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        Code1 code = new Code1();
        System.out.println(code.isCircular("MRMRMRM"));
        System.out.println(code.isCircular("MLMLMLM"));
        System.out.println(code.isCircular("LMRRM"));
        System.out.println(code.isCircular("LLLL"));
        System.out.println(code.isCircular("RRR"));
        System.out.println(code.isCircular("LMRMRMRM"));

        System.out.println("--------");
        System.out.println(code.isCircular("MMMM"));
        System.out.println(code.isCircular("MRMR"));
        System.out.println(code.isCircular("LLMLL"));


    }
}
