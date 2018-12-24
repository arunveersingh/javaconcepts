package oopsconcepts.constructors;

import java.util.ArrayList;
import java.util.List;

public class Test implements Interfaces {
    
    private static final List list = new ArrayList<>();

    public static void main(String[] args) {

	list.add("apple");
	
	new Child().main(null);
	new Parent().main(null);
	
	//new Testest();
	
	System.out.println(new Test().x);
    }

}
