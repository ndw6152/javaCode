package Stack;

import LinkListStuff.Stack;

/**
 * Created by Anonealio on 7/16/2017.
 */
public class Question3_1 {


    public class StackMin {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public StackMin() {
            this.stack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        public void push(int val) {
            if(minStack.peek() == null) {
                minStack.push(val);

            }
            else {
                int minVal = minStack.peek();

                if(val < minVal) {
                    minStack.push(val);
                }
                else {
                    minStack.push(minVal);
                }
            }


            stack.push(val);
        }

        public int pop() {
            minStack.pop();
            return stack.pop();
        }

        public int min() {
            return minStack.peek();
        }

        public void printStack() {
            stack.printStack();
        }

    }


    public StackMin stackMin;

    public Question3_1() {
        this.stackMin = new StackMin();
    }




    public static void main(String[] args) {
        Question3_1 q = new Question3_1();
        q.stackMin.push(2);
        q.stackMin.push(5);
        q.stackMin.push(6);
        q.stackMin.printStack();
        System.out.println(q.stackMin.min());

        q.stackMin.push(1);
        q.stackMin.printStack();
        System.out.println(q.stackMin.min());
        q.stackMin.push(100);
        q.stackMin.printStack();
        System.out.println(q.stackMin.min());

        q.stackMin.pop();
        q.stackMin.pop();
        q.stackMin.printStack();
        System.out.println(q.stackMin.min());

    }
}
