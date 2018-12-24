package oopsconcepts.polymorphism;

public class Parent {
    
    private void method() {
	System.out.println("Parent#method");

    }
    
    public static void methodStatic() {
	System.out.println("Parent#methodStatic");

    }
    
    public void onlyInParent() {
	System.out.println("Parent#onlyInParent");

    }
    
    public void inParent() {
	System.out.println("Parent#inParent");

    }

}
