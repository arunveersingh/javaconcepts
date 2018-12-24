package oopsconcepts.polymorphism;

public class Child extends Parent {

    // @Override
    public void method() {
	System.out.println("Child#method");

    }

    public static void methodStatic() {
	System.out.println("Child#methodStatic");

    }
    
    public void inParent() {
	System.out.println("Child#inParent");

    }

}
