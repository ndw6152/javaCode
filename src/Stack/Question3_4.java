package Stack;

import LinkListStuff.Stack;

/**
 * Created by Anonealio on 7/19/2017.
 */
class QueueViaStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int val) {
        stack1.push(val);
    }

    public void pop() {
        if (stack2.count != 0) {
            System.out.println("Removing: " + stack2.peek());
            stack2.pop();
        } else {
            while (stack1.count != 0) {
                int top = stack1.peek();
                stack1.pop();
                stack2.push(top);
            }
            if (stack2.count != 0) {
                System.out.println("Removing: " + stack2.peek());
                stack2.pop();
            }
        }
    }

    public void printQueue() {
        System.out.print("stack1: ");stack1.printStack();
        System.out.print("stack2: ");stack2.printStack();
        System.out.println();
    }

}

public class Question3_4 {


    public static void main(String[] args) {

        QueueViaStacks q = new QueueViaStacks();
        q.push(1);q.push(2);q.push(3);q.push(4);q.push(5);
        System.out.println("--->");
        q.printQueue();

        System.out.println("removing first element");
        q.pop();
        q.printQueue();
        q.pop();
        q.pop();
        q.pop();
        q.printQueue();
        System.out.println("pushing two numbers");
        q.push(6);q.push(7);
        q.printQueue();
        q.pop();
        q.pop();

    }

}

