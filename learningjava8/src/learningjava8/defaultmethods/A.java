package learningjava8.defaultmethods;

public interface A {
	
	default public void hello(){
		System.out.println("Hello From A");
	}

}
