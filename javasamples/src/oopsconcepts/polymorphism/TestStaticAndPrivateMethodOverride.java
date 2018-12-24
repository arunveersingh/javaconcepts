package oopsconcepts.polymorphism;

public class TestStaticAndPrivateMethodOverride {
    
 
    
    public TestStaticAndPrivateMethodOverride() {
	System.out.println("2");

    }
    
    {
	System.out.println("3");

    }
    
    static {
 	System.out.println("1");
     }
    
    public static void main(String[] args) {
	
	//Child c = new Parent();
	
	Parent p = new Parent();
	Parent pc = new Child();
	System.out.println("-------");
	p.inParent();
	pc.inParent();
	
	System.out.println("-------");

	
	
	invoke(new Parent());
	invoke(new Child());
	new Child().methodStatic();
	
	
	new TestStaticAndPrivateMethodOverride();


    }
    
    
    
    static void invoke(Parent parent){
	
	
	parent.methodStatic();
	
	parent.inParent();
	
	parent.onlyInParent();
	
    }

}
