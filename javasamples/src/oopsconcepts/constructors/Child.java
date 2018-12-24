package oopsconcepts.constructors;

public class Child extends Parent {
    
    // Cannot override final method
    /*public  void test() {

    }*/
    
    //Illegal modifier for the constructor in type Child; only public, protected & private are permitted
   /* public final Child() {

    
    }*/
    
/* public final void methodFinal() {
	
    }*/
    
    public static void main(String[] args) {
	
	System.out.println("Hello Child");
    }

}
