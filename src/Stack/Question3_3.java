package Stack;

import LinkListStuff.Stack;

import java.util.ArrayList;

/**
 * Created by Anonealio on 7/19/2017.
 */

class SetofStacks {

    private ArrayList<Stack<Integer>> stackList = new ArrayList<>();
    int threshold;

    public SetofStacks(int threshold) {
        this.threshold = threshold;
    }


    public void push(int val) {
        if (stackList.size() == 0) {
            Stack<Integer> s = new Stack<>();
            s.push(val);
            stackList.add(s);
        }
        else {
            Stack<Integer> current = stackList.get(stackList.size() - 1);
            if(current.count == threshold) {
                Stack<Integer> s = new Stack<>();
                s.push(val);
                stackList.add(s);
            }
            else {
                current.push(val);
            }
        }
    }

    public void pop() {
        if (stackList.size() == 0) {
            return;
        }
        else {
            Stack<Integer> current = stackList.get(stackList.size() -1);
            current.pop();
            if(current.count == 0) {
                stackList.remove(current);
            }
        }
    }

    public void popAt(int val) {
        try {
            Stack<Integer> current = stackList.get(val);
            if(current.count != 0) {
                current.pop();
                if(current.count == 0) {
                    //stackList.remove(current);
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Wrong index as argument");
        }
    }

    public void printAllStacks() {
        for(Stack<Integer> s : stackList) {
            s.printStack();
        }
        System.out.println("------------");
    }

}

public class Question3_3 {
    SetofStacks setofStacks;
    public Question3_3(int threshold) {
        this.setofStacks = new SetofStacks(threshold);
    }

    public static void main(String[] args) {
        Question3_3 q = new Question3_3(3);
        System.out.println("added 3");
        q.setofStacks.push(1);
        q.setofStacks.push(10);
        q.setofStacks.push(100);
        q.setofStacks.printAllStacks();
        System.out.println("added 3 more which shows up in new stack");
        q.setofStacks.push(200);
        q.setofStacks.push(300);
        q.setofStacks.push(400);
        q.setofStacks.printAllStacks();
        System.out.println("added 2 more");
        q.setofStacks.push(500);
        q.setofStacks.push(600);
        q.setofStacks.printAllStacks();
        System.out.println("removed 1 from set of stacks");
        q.setofStacks.pop();
        q.setofStacks.printAllStacks();
        System.out.println("added 1");
        q.setofStacks.push(700);
        q.setofStacks.printAllStacks();
        System.out.println("removed 3 from set of stacks");
        q.setofStacks.pop();
        q.setofStacks.pop();
        q.setofStacks.pop();
        q.setofStacks.printAllStacks();
        System.out.println("removed 1 in stack 0");
        q.setofStacks.popAt(0);
        q.setofStacks.printAllStacks();
        System.out.println("removed 2 in stack 0");
        q.setofStacks.popAt(0);
        q.setofStacks.popAt(0);
        q.setofStacks.printAllStacks();
        System.out.println("removed 1 in stack 0");
        q.setofStacks.popAt(0);
        q.setofStacks.printAllStacks();


        Question3_3 q2 = new Question3_3(5);
        System.out.println("new set of stacks with threshold 5");
        q2.setofStacks.push(1);
        q2.setofStacks.push(10);
        q2.setofStacks.push(10);
        q2.setofStacks.printAllStacks();
        System.out.println("added 3 more which shows up in new stack");
        q2.setofStacks.push(20);
        q2.setofStacks.push(30);
        q2.setofStacks.push(40);
        q2.setofStacks.printAllStacks();
    }
}
