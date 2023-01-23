package randomStuff;

/**
 * Created by ndw6152 on 8/13/2018.
 */

class DerivedClass extends BaseClass {

    @Override
    public void doSomething() {
        System.out.println("SOMETHING");
    }



}


class DerivedOver extends BaseClass {

    public void doSomething() {
        System.out.println("Something better");
    }
    public void printWorld() {
        System.out.println("hello Monde " + hello);
    }

}



public abstract class BaseClass {
    int hello = 100;
    int world;

    public abstract void doSomething();

    public void printWorld() {
        System.out.println("hello world");
    }


    public static void main(String[] args) {
        DerivedClass sol = new DerivedClass();
        sol.doSomething();
        sol.printWorld();


        DerivedOver sol2 = new DerivedOver();
        sol2.doSomething();
        sol2.printWorld();
    }
}



